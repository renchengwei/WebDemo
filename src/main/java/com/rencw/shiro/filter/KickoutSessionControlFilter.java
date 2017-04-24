package com.rencw.shiro.filter;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.rencw.shiro.redis.RedisSessionDAO;
import com.rencw.shiro.redis.SerializeUtils;
import com.rencw.shiro.redis.ShiroRedisManager;

public class KickoutSessionControlFilter extends AccessControlFilter{

	private String kickoutUrl; //踢出后到的地址
    private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数 默认1
    
    @Resource
	private ShiroRedisManager shiroRedisManager;
    @Resource
    private RedisSessionDAO redisSessionDAO;
    
	public String getKickoutUrl() {
		return kickoutUrl;
	}

	public void setKickoutUrl(String kickoutUrl) {
		this.kickoutUrl = kickoutUrl;
	}

	public boolean isKickoutAfter() {
		return kickoutAfter;
	}

	public void setKickoutAfter(boolean kickoutAfter) {
		this.kickoutAfter = kickoutAfter;
	}

	public int getMaxSession() {
		return maxSession;
	}

	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		
		Subject subject = getSubject(request, response);
        if(!subject.isAuthenticated() && !subject.isRemembered()) {
            //如果没有登录，直接进行之后的流程
            return true;
        }

        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        Serializable sessionId = session.getId();
        
        String key = "shiro-kickout-session:" + username;
        String lockKey = "shiro-kickout-session-lock:" + username;
        
        //分布式并发锁控制，不依赖jvm，采用redis做同步锁控制，在分布式结构中仍然适用
        //同步锁锁定时间为5秒，5秒后自动释放锁
        boolean lock = shiroRedisManager.setNX(lockKey,sessionId.toString().getBytes(), 5L);
        while(!lock) {
        	Thread.sleep(100);
        	lock = shiroRedisManager.setNX(lockKey,sessionId.toString().getBytes(), 5L);
        }
        
        //获得同步锁以后继续执行
        byte[] bytes = shiroRedisManager.get(key.getBytes());
        Deque<Serializable> deque;
        if(bytes == null) {
        	deque = new LinkedList<Serializable>(); 
        } else {
        	deque = (Deque<Serializable>) SerializeUtils.deserialize(bytes);
        }
        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if(!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }
        
        //如果队列里的sessionId数超出最大会话数，开始踢人
        while(deque.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if(kickoutAfter) { //如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { //否则踢出前者
                kickoutSessionId = deque.removeLast();
            }
            try {
            	Session kickoutSession = redisSessionDAO.readSession(kickoutSessionId);
            	
                if(kickoutSession != null) {
                    //设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                    redisSessionDAO.update(kickoutSession);
                }
            } catch (Exception e) {//ignore exception
            }
        }
        
        shiroRedisManager.set(key, SerializeUtils.serialize(deque));
        //让出同步锁给等待的线程
        shiroRedisManager.del(lockKey.getBytes());

        //如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            //会话被踢出了
            try {
                subject.logout();
            } catch (Exception e) { //ignore
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        }
		return true;
	}

}

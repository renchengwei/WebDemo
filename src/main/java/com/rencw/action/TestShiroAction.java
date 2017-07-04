package com.rencw.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import com.rencw.pojo.User;

@Controller
public class TestShiroAction {

	public void login(User user) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword().toCharArray());
		subject.login(token);
	}
	
	@RequiresPermissions(value={"user_create"})
	public void createUser() {
		
	}
	
	@RequiresRoles(value={"admin"})
	public void deleteUser() {
		
	}
	
}

package com.rencw.dao.mapper;

import org.springframework.stereotype.Repository;

import com.rencw.pojo.User;
import com.rencw.pojo.UserRole;

/**  
 * @ClassName: UserMapper  
 * @Description: 用户DAO，
 * @author renchengwei  
 * @date 2017年6月17日  
 *    
 */
/**  
 * @ClassName: UserMapper  
 * @Description: 定义用户相关的数据库层操作
 * @author renchengwei  
 * @date 2017年6月17日  
 *    
 */
@Repository
public interface UserMapper {

	/**
     * 创建用户
     * @param user
     */
    public void createUser(User user);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(UserRole userRole);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(UserRole userRole);
    
    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    public User findById(Long id);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findByUserName(String userName);
    
}

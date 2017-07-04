package com.rencw.service;

import java.util.List;
import java.util.Set;

import com.rencw.pojo.Permission;
import com.rencw.pojo.Role;
import com.rencw.pojo.User;
import com.rencw.pojo.UserRole;

public interface UserService {

	/**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPasswordr);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(List<UserRole> userRoleList);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(List<UserRole> userRoleList);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findByUserName(String userName);

    /**
     * 根据用户名查找其角色对象
     * @param userName
     * @return
     */
    public List<Role> findRolesByUserName(String userName);
    
    /**
     * 根据用户名查找其权限对象
     * @param userName
     * @return
     */
    public List<Permission> findPermissionsByUserName(String userName);
    /**
     * 根据用户名查找其权限对象
     * @param userName
     * @return
     */
    public Set<String> selectPermissionsByUserName(String userName);
    
    /**
     * 根据用户名查找其角色
     * @param userName
     * @return
     */
    public Set<String> selectRolesByUserName(String userName);

}

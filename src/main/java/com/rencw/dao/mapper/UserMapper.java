package com.rencw.dao.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.rencw.bean.Permission;
import com.rencw.bean.Role;
import com.rencw.bean.User;
import com.rencw.bean.UserRole;

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

    /**
     * 根据用户名查找其角色
     * @param userName
     * @return
     */
    public List<Role> selectRoles(String userName);

    /**
     * 根据用户名查找其权限
     * @param userName
     * @return
     */
    public List<Permission> selectPermissions(String userName);
    
    /**
     * 根据用户名查找其角色
     * @param userName
     * @return
     */
    public Set<String> findRoles(String userName);
    
    /**
     * 根据用户名查找其权限对象
     * @param userName
     * @return
     */
    public Set<String> findPermissions(String userName);
}

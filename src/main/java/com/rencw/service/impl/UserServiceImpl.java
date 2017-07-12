package com.rencw.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.dao.mapper.PermissionMapper;
import com.rencw.dao.mapper.RoleMapper;
import com.rencw.dao.mapper.UserMapper;
import com.rencw.framework.shiro.PasswordHelper;
import com.rencw.pojo.Permission;
import com.rencw.pojo.Role;
import com.rencw.pojo.User;
import com.rencw.pojo.UserRole;
import com.rencw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private PermissionMapper permissionMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private PasswordHelper passwordHelper;
	
	@Override
	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		userMapper.createUser(user);
		return user;
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		User user = userMapper.findById(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userMapper.updateUser(user);
	}

	@Override
	public void correlationRoles(List<UserRole> userRoleList) {
		if(userRoleList != null) {
			for(UserRole userRole : userRoleList) {
				userMapper.correlationRoles(userRole);
			}
		}
	}

	@Override
	public void uncorrelationRoles(List<UserRole> userRoleList) {
		if(userRoleList != null) {
			for(UserRole userRole : userRoleList) {
				userMapper.uncorrelationRoles(userRole);
			}
		}
	}

	@Override
	public User findByUserName(String userName) {
		return userMapper.findByUserName(userName);
	}

	@Override
	public List<Role> findRolesByUserName(String userName) {
		return roleMapper.findRolesByUserName(userName);
	}

	@Override
	public List<Permission> findPermissionsByUserName(String userName) {
		return permissionMapper.queryPermissionsByUserName(userName);
	}

	@Override
	public Set<String> selectRolesByUserName(String userName) {
		return roleMapper.selectRolesByUserName(userName);
	}

	@Override
	public Set<String> selectPermissionsByUserName(String userName) {
		return permissionMapper.selectPermissionsByUserName(userName);
	}

}

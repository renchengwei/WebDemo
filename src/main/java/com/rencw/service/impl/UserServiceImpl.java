package com.rencw.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.bean.Permission;
import com.rencw.bean.Role;
import com.rencw.bean.User;
import com.rencw.bean.UserRole;
import com.rencw.dao.mapper.UserMapper;
import com.rencw.service.UserService;
import com.rencw.shiro.PasswordHelper;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
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
	public List<Role> selectRoles(String userName) {
		return userMapper.selectRoles(userName);
	}

	@Override
	public List<Permission> selectPermissions(String userName) {
		return userMapper.selectPermissions(userName);
	}

	@Override
	public Set<String> findRoles(String userName) {
		return userMapper.findRoles(userName);
	}

	@Override
	public Set<String> findPermissions(String userName) {
		return userMapper.findPermissions(userName);
	}

}

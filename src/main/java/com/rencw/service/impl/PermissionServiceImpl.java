package com.rencw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.dao.mapper.PermissionMapper;
import com.rencw.pojo.Permission;
import com.rencw.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public Permission addPermission(Permission permission) {
		permissionMapper.addPermission(permission);
		return permission;
	}

	@Override
	public void deletePermission(Long permissionId) {
		permissionMapper.deletePermission(permissionId);
	}

}

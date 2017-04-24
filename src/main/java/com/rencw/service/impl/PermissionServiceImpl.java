package com.rencw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.bean.Permission;
import com.rencw.dao.mapper.PermissionMapper;
import com.rencw.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public Permission createPermission(Permission permission) {
		permissionMapper.createPermission(permission);
		return permission;
	}

	@Override
	public void deletePermission(Long permissionId) {
		permissionMapper.deletePermission(permissionId);
	}

}

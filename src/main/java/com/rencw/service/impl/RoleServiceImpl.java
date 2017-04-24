package com.rencw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.bean.Role;
import com.rencw.bean.RolePermission;
import com.rencw.dao.mapper.RoleMapper;
import com.rencw.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Override
	public Role createRole(Role role) {
		roleMapper.createRole(role);
		return role;
	}

	@Override
	public void deleteRole(Long roleId) {
		roleMapper.deleteRole(roleId);
	}

	@Override
	public void correlationPermissions(List<RolePermission> rolePermissionList) {
		if(rolePermissionList != null) {
			for(RolePermission rolePermission : rolePermissionList) {
				roleMapper.correlationPermissions(rolePermission);
			}
		}
	}

	@Override
	public void uncorrelationPermissions(List<RolePermission> rolePermissionList) {
		if(rolePermissionList != null) {
			for(RolePermission rolePermission : rolePermissionList) {
				roleMapper.uncorrelationPermissions(rolePermission);
			}
		}
	}

}

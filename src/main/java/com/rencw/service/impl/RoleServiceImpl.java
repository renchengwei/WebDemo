package com.rencw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.dao.mapper.RoleMapper;
import com.rencw.dto.query.RoleQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.pojo.Role;
import com.rencw.pojo.RolePermission;
import com.rencw.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Override
	public Role addRole(Role role) {
		roleMapper.addRole(role);
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

	@Override
	public DatatablesViewPage<Role> queryRolesByPage(RoleQuery query) {
		DatatablesViewPage<Role> viewPage = new DatatablesViewPage<Role>();
		
		viewPage.setDraw(query.getDraw());
		Long count = roleMapper.queryRolesCount(query);
		List<Role> roleList = new ArrayList<Role>();
		if(count > 0) {
			roleList = roleMapper.queryRolesByPage(query);
			viewPage.setData(roleList);
		}
		
		viewPage.setRecordsTotal(count);
		return viewPage;
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return null;
	}

}

package com.rencw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rencw.common.enums.EnumsPermissionType;
import com.rencw.dao.mapper.PermissionMapper;
import com.rencw.dto.query.PermissionQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.pojo.Permission;
import com.rencw.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public Permission addPermission(Permission permission) {
		//目录类型上级权限ID为-1
		if(EnumsPermissionType.DIRECTORY.getValue().equals(permission.getType())) {
			permission.setParentId(-1L);
		}
		permissionMapper.addPermission(permission);
		return permission;
	}

	@Override
	public void deletePermission(Long permissionId) {
		permissionMapper.deletePermission(permissionId);
	}

	@Override
	public DatatablesViewPage<Permission> queryPermissionsByPage(PermissionQuery query) {
		DatatablesViewPage<Permission> viewPage = new DatatablesViewPage<Permission>();
		
		viewPage.setDraw(query.getDraw());
		Long count = permissionMapper.queryPermissionsCount(query);
		List<Permission> permissionList = new ArrayList<Permission>();
		if(count > 0) {
			permissionList = permissionMapper.queryPermissions(query);
			viewPage.setData(permissionList);
		}
		
		viewPage.setRecordsTotal(count);
		return viewPage;
	}

	@Override
	public Long queryPermissionsCount(PermissionQuery query) {
		Long count = permissionMapper.queryPermissionsCount(query);
		return count;
	}

	@Override
	public List<Permission> queryPermissions(PermissionQuery query) {
		List<Permission> list = permissionMapper.queryPermissions(query);
		List<Permission> result = new ArrayList<Permission>();
		if(list != null) {
			sort(list,result,-1L);
		}
		return result;
	}
	
	private void sort(List<Permission> list,List<Permission> result,Long id) {
		for(Permission p : list) {
			if(p.getParentId().equals(id)) {
				result.add(p);
				sort(list,result,p.getId());
			}
		}
	}

	@Override
	public Permission getPermissionById(Long id) {
		return permissionMapper.getPermissionById(id);
	}

	@Override
	public void editPermission(Permission permission) {
		permissionMapper.editPermission(permission);
	}
}

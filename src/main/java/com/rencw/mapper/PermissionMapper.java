package com.rencw.mapper;

import org.springframework.stereotype.Repository;

import com.rencw.bean.Permission;

@Repository
public interface PermissionMapper {
	public void createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}

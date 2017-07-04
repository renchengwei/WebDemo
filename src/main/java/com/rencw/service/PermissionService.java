package com.rencw.service;

import com.rencw.pojo.Permission;

public interface PermissionService {
	public Permission addPermission(Permission permission);
    public void deletePermission(Long permissionId);
}

package com.rencw.service;

import com.rencw.bean.Permission;

public interface PermissionService {
	public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}

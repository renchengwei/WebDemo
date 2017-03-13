package com.rencw;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.bean.Permission;
import com.rencw.service.PermissionService;

public class TestPermission extends TestSpringBase {

	@Resource
	private PermissionService permissionService;
	
	@Test
	public void testCreatePermission() {
		Permission permission = new Permission("user_create", "user_create", Boolean.TRUE);
		permissionService.createPermission(permission);
	}
	@Test
	public void testDeletePermission() {
		permissionService.deletePermission(2L);
	}
}

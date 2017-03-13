package com.rencw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.bean.Permission;
import com.rencw.bean.Role;
import com.rencw.bean.User;
import com.rencw.bean.UserRole;
import com.rencw.service.UserService;

public class TestUser extends TestSpringBase {

	@Resource
	private UserService userService;
	
	@Test
	public void testCreatUser() {
		User user = new User();
		user.setUserName("lisi");
		user.setPassword("123456");
		userService.createUser(user);
	}
	@Test
	public void testChangePassword() {
		userService.changePassword(1L, "345678");
	}
	@Test
	public void testFindByName() {
		User user = userService.findByUserName("zhangsan");
		System.out.println(user.toString());
	}
	
	
	@Test
	public void testCorrelationRoles() {
		UserRole userRole = new UserRole();
		userRole.setUserId(1L);
		userRole.setRoleId(2L);
		
		UserRole userRole1 = new UserRole();
		userRole1.setUserId(1L);
		userRole1.setRoleId(3L);
		
		List<UserRole> userRoleList = new ArrayList<>();
		userRoleList.add(userRole);
		userRoleList.add(userRole1);
		userService.correlationRoles(userRoleList);
	}
	
	@Test
	public void testUncorrelationRoles() {
		UserRole userRole = new UserRole();
		userRole.setUserId(1L);
		userRole.setRoleId(1L);
		
		UserRole userRole1 = new UserRole();
		userRole1.setUserId(1L);
		userRole1.setRoleId(2L);
		
		List<UserRole> userRoleList = new ArrayList<>();
		userRoleList.add(userRole);
		userRoleList.add(userRole1);
		userService.uncorrelationRoles(userRoleList);
	}
	
	@Test
	public void testSelectRoles() {
		List<Role> list = userService.selectRoles("zhangsan");
		if(list != null) {
			for(Role role : list) {
				System.out.println(role);
			}
		}
	}
	
	@Test
	public void testSelectPermissions() {
		List<Permission> list = userService.selectPermissions("zhangsan");
		if(list != null) {
			for(Permission permission : list) {
				System.out.println(permission);
			}
		}
	}
	@Test
	public void testFindPermissions() {
		Set<String> list = userService.findPermissions("zhangsan");
		if(list != null) {
			for(String permission : list) {
				System.out.println(permission);
			}
		}
	}
	@Test
	public void testFindRoles() {
		Set<String> list = userService.findRoles("zhangsan");
		if(list != null) {
			for(String permission : list) {
				System.out.println(permission);
			}
		}
	}
}

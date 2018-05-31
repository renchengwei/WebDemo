package com.rencw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rencw.common.enums.EnumsRole;
import com.rencw.dto.query.RoleQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.dto.result.PageItem;
import com.rencw.dto.result.PageResult;
import com.rencw.pojo.Role;
import com.rencw.service.RoleService;

/**
 * @ClassName: RoleController
 * @Description: 角色视图控制器
 * @author renchengwei
 * @date 2017年7月30日
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Resource
	private RoleService roleService;

	@ResponseBody
	@RequestMapping("/queryRoleByPage.json")
	public DatatablesViewPage<Role> queryRolesByPage(HttpServletRequest request, HttpServletResponse response,
			RoleQuery query) {
		DatatablesViewPage<Role> viewPage = roleService.queryRolesByPage(query);
		return viewPage;
	}
//	
//	@ResponseBody
//	@RequestMapping("/deletePermission.json")
//	public void deletePermission(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam(value="id",required=true) Long id) {
//		permissionService.deletePermission(id);
//	}
//	
//	@ResponseBody
//	@RequestMapping("/getPermissionById.json")
//	public Permission getPermissionById(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam(value="id") Long id) {
//		return permissionService.getPermissionById(id);
//	}
//	
//	@ResponseBody
//	@RequestMapping("/queryPermissions.json")
//	public List<Permission> queryPermissions(HttpServletRequest request, HttpServletResponse response,
//			PermissionQuery query) {
//		return permissionService.queryPermissions(query);
//	}
//	
	@RequestMapping("/roleList")
	public String roleList() {
		return "role/roleList";
	}
	/**  
	 * @Title: addRole  
	 * @Description: 新增角色
	 * @param @param request
	 * @param @param response
	 * @param @param modelAndView
	 * @param @param role
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws  
	 */
	@RequestMapping("/addRole")
	public ModelAndView addRole(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, Role role) {
		EnumsRole result = verification(role);
		PageResult pageResult = new PageResult();
		if(result.getCode() != 0) {
			modelAndView.setViewName("error");
			pageResult.setMessage(result.getMessage());
			pageResult.setCode(result.getCode());
			modelAndView.addObject("result", pageResult);
			logger.warn("RoleController.addRole:" + result.getMessage());
			return modelAndView;
		}
		
		try {
			roleService.addRole(role);
			modelAndView.setViewName("success");
			pageResult.setMessage(EnumsRole.ADD_SUCCES.getMessage());
			pageResult.setCode(EnumsRole.ADD_SUCCES.getCode());
			pageResult.addPageItem(new PageItem("role/roleList", "返回角色列表"));
			pageResult.addPageItem(new PageItem("role/toAddRole", "继续新增角色"));
			modelAndView.addObject("result", pageResult);
		}catch (Exception e) {
			logger.error("RoleController.addRole:",e);
			pageResult.setMessage(EnumsRole.ERROR_SERVER.getMessage());
			pageResult.setCode(EnumsRole.ERROR_SERVER.getCode());
			modelAndView.addObject("result", pageResult);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
//	
//	@RequestMapping("/editPermission.html")
//	public ModelAndView editPermission(HttpServletRequest request, HttpServletResponse response,
//			ModelAndView modelAndView, Permission permission) {
//		EnumsPermission result = verification(permission);
//		PageResult pageResult = new PageResult();
//		if(result.getCode() != 0) {
//			modelAndView.setViewName("error");
//			pageResult.setMessage(result.getMessage());
//			pageResult.setCode(result.getCode());
//			modelAndView.addObject("result", pageResult);
//			logger.error("PermissionAction.editPermission:" + pageResult.getMessage());
//			return modelAndView;
//		}
//		
//		if(permission.getId() == null) {
//			modelAndView.setViewName("error");
//			pageResult.setMessage(EnumsPermission.ERROR_ILLEGAL.getMessage());
//			pageResult.setCode(EnumsPermission.ERROR_ILLEGAL.getCode());
//			modelAndView.addObject("result", pageResult);
//			logger.error("PermissionAction.editPermission:" + pageResult.getMessage());
//			return modelAndView;
//		}
//		
//		try {
//			permissionService.editPermission(permission);
//			modelAndView.setViewName("success");
//			pageResult.setMessage(EnumsPermission.EDIT_SUCCES.getMessage());
//			pageResult.setCode(EnumsPermission.EDIT_SUCCES.getCode());
//			pageResult.addPageItem(new PageItem("/permission/permissionList.html", "返回权限列表"));
//			modelAndView.addObject("result", pageResult);
//		}catch (Exception e) {
//			logger.error("PermissionAction.editPermission:",e);
//			pageResult.setMessage(EnumsPermission.ERROR_SERVER.getMessage());
//			pageResult.setCode(EnumsPermission.ERROR_SERVER.getCode());
//			modelAndView.addObject("result", pageResult);
//			modelAndView.setViewName("error");
//		}
//		return modelAndView;
//	}
//	
	@RequestMapping("/toAddRole")
	public String toAddRole(HttpServletRequest request, HttpServletResponse response) {
		return "role/addRole";
	}
	
	@RequestMapping("/toEditRole")
	public ModelAndView toEditRole(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, @RequestParam(value="id") Long id) {
		Role role = roleService.getRoleById(id);
		modelAndView.setViewName("role/editRole");
		modelAndView.addObject("role", role);
		return modelAndView;
	}

	/**  
	 * @Title: verification  
	 * @Description: 权限对象参数验证
	 * @param @param role
	 * @param @return    参数  
	 * @return EnumsRole    返回类型  
	 * @throws  
	 */
	private EnumsRole verification(Role role) {
		// 参数前置判断
		if (StringUtils.isBlank(role.getName())) {
			return EnumsRole.ERROR_NAME_NULL;
		}
		return EnumsRole.ADD_SUCCES;
	}

}

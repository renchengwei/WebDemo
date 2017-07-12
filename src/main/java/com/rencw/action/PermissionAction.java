package com.rencw.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rencw.common.enums.EnumsPermission;
import com.rencw.common.enums.EnumsPermissionType;
import com.rencw.dto.query.PermissionQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.dto.result.PageItem;
import com.rencw.dto.result.PageResult;
import com.rencw.pojo.Permission;
import com.rencw.service.PermissionService;

/**
 * @ClassName: PermissionAction
 * @Description: 权限视图控制器
 * @author renchengwei
 * @date 2017年6月17日
 * 
 */
@Controller
@RequestMapping("/permission")
public class PermissionAction {

	private static Logger logger = Logger.getLogger(PermissionAction.class);

	@Resource
	private PermissionService permissionService;

	@ResponseBody
	@RequestMapping("/queryPermissionsByPage.json")
	public DatatablesViewPage<Permission> findPermissionsByPage(HttpServletRequest request, HttpServletResponse response,
			PermissionQuery query) {
		DatatablesViewPage<Permission> viewPage = permissionService.queryPermissionsByPage(query);
		return viewPage;
	}
	
	@ResponseBody
	@RequestMapping("/deletePermission.json")
	public void deletePermission(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="id",required=true) Long id) {
		permissionService.deletePermission(id);
	}
	
	@ResponseBody
	@RequestMapping("/getPermissionById.json")
	public Permission getPermissionById(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="id") Long id) {
		return permissionService.getPermissionById(id);
	}
	
	@ResponseBody
	@RequestMapping("/queryPermissions.json")
	public List<Permission> queryPermissions(HttpServletRequest request, HttpServletResponse response,
			PermissionQuery query) {
		return permissionService.queryPermissions(query);
	}
	
	/**  
	 * @Title: addPermission  
	 * @Description: 新增权限
	 * @param @param request
	 * @param @param response
	 * @param @param modelAndView
	 * @param @param permission
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws  
	 */
	@RequestMapping("/addPermission.html")
	public ModelAndView addPermission(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, Permission permission) {
		EnumsPermission result = verification(permission);
		PageResult pageResult = new PageResult();
		if(result.getCode() != 0) {
			modelAndView.setViewName("error");
			pageResult.setMessage(result.getMessage());
			pageResult.setCode(result.getCode());
			modelAndView.addObject("result", pageResult);
			logger.warn("PermissionAction.addPermission:" + result.getMessage());
			return modelAndView;
		}
		
		try {
			permissionService.addPermission(permission);
			modelAndView.setViewName("success");
			pageResult.setMessage(EnumsPermission.ADD_SUCCES.getMessage());
			pageResult.setCode(EnumsPermission.ADD_SUCCES.getCode());
			pageResult.addPageItem(new PageItem("/jsp/authority/permissionList.jsp", "返回权限列表"));
			pageResult.addPageItem(new PageItem("/permission/toAddPermission.html", "继续新增权限"));
			modelAndView.addObject("result", pageResult);
		}catch (Exception e) {
			logger.error("PermissionAction.addPermission:",e);
			pageResult.setMessage(EnumsPermission.ERROR_SERVER.getMessage());
			pageResult.setCode(EnumsPermission.ERROR_SERVER.getCode());
			modelAndView.addObject("result", pageResult);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
	@RequestMapping("/editPermission.html")
	public ModelAndView editPermission(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, Permission permission) {
		EnumsPermission result = verification(permission);
		PageResult pageResult = new PageResult();
		if(result.getCode() != 0) {
			modelAndView.setViewName("error");
			pageResult.setMessage(result.getMessage());
			pageResult.setCode(result.getCode());
			modelAndView.addObject("result", pageResult);
			logger.error("PermissionAction.editPermission:" + pageResult.getMessage());
			return modelAndView;
		}
		
		if(permission.getId() == null) {
			modelAndView.setViewName("error");
			pageResult.setMessage(EnumsPermission.ERROR_ILLEGAL.getMessage());
			pageResult.setCode(EnumsPermission.ERROR_ILLEGAL.getCode());
			modelAndView.addObject("result", pageResult);
			logger.error("PermissionAction.editPermission:" + pageResult.getMessage());
			return modelAndView;
		}
		
		try {
			permissionService.editPermission(permission);
			modelAndView.setViewName("success");
			pageResult.setMessage(EnumsPermission.EDIT_SUCCES.getMessage());
			pageResult.setCode(EnumsPermission.EDIT_SUCCES.getCode());
			pageResult.addPageItem(new PageItem("/jsp/authority/permissionList.jsp", "返回权限列表"));
			modelAndView.addObject("result", pageResult);
		}catch (Exception e) {
			logger.error("PermissionAction.editPermission:",e);
			pageResult.setMessage(EnumsPermission.ERROR_SERVER.getMessage());
			pageResult.setCode(EnumsPermission.ERROR_SERVER.getCode());
			modelAndView.addObject("result", pageResult);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
	@RequestMapping("/toAddPermission.html")
	public ModelAndView toAddPermission(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, Permission permission) {
		int i = 3 / 0;
		modelAndView.setViewName("authority/addPermission");
		return modelAndView;
	}
	
	@RequestMapping("/toEditPermission.html")
	public ModelAndView toEditPermission(HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView, @RequestParam(value="id") Long id) {
		Permission permission = permissionService.getPermissionById(id);
		modelAndView.setViewName("authority/editPermission");
		modelAndView.addObject("permission", permission);
		return modelAndView;
	}

	/**  
	 * @Title: verification  
	 * @Description: 权限对象参数验证
	 * @param @param permission
	 * @param @return    参数  
	 * @return EnumsPermission    返回类型  
	 * @throws  
	 */
	private EnumsPermission verification(Permission permission) {
		// 参数前置判断
		if (StringUtils.isBlank(permission.getName())) {
			return EnumsPermission.ERROR_NAME_NULL;
		}

		if (permission.getType() == null) {
			return EnumsPermission.ERROR_TYPE_NULL;
		}

		if (StringUtils.isBlank(permission.getCode())) {
			return EnumsPermission.ERROR_CODE_NULL;
		}
		
		PermissionQuery query = new PermissionQuery();
		query.setCode(permission.getCode());
		Long count = permissionService.queryPermissionsCount(query);
		if(count > 0) {
			return EnumsPermission.ERROR_ORDERNO_NULL;
		}

		if (permission.getOrderNo() == null) {
			return EnumsPermission.ERROR_ORDERNO_NULL;
		}

		if (EnumsPermissionType.ENUM.getValue().equals(permission.getType()) && StringUtils.isBlank(permission.getMenuURL())) {
			return EnumsPermission.ERROR_URL_NULL;
		}

		if (EnumsPermissionType.ENUM.getValue().equals(permission.getType()) && permission.getParentId() == null) {
			return EnumsPermission.ERROR_PARENT_NULL;
		}
		return EnumsPermission.ADD_SUCCES;
	}

}

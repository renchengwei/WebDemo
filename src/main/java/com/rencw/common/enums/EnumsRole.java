package com.rencw.common.enums;

/**  
 * @ClassName: EnumsRole  
 * @Description: 角色枚举类
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
public enum EnumsRole {

	ADD_SUCCES("新增角色成功！",0),
	EDIT_SUCCES("编辑权限成功！",1),
	ERROR_NAME_NULL("角色名称不能为空！",-1),
	ERROR_ILLEGAL("非法操作！",-9998),
	ERROR_SERVER("服务器异常！",-9999);
	
	private String message;
	private Integer code;
	private EnumsRole(String message, Integer code) {
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}

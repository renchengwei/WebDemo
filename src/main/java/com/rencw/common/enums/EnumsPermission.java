package com.rencw.common.enums;

/**  
 * @ClassName: EnumsPermission  
 * @Description: 权限枚举类
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
public enum EnumsPermission {

	ADD_SUCCES("权限新增成功！",0),
	ERROR_NAME_NULL("权限名称不能为空！",-1),
	ERROR_URL_NULL("菜单URL不能为空！",-2),
	ERROR_ORDERNO_NULL("排序号不能为空！",-3),
	ERROR_CODE_NULL("授权标识不能为空！",-4),
	ERROR_SERVER("服务器异常！",-9999),
	ERROR_TYPE_NULL("权限类型不能为空！",-6);
	
	private String message;
	private Integer code;
	private EnumsPermission(String message, Integer code) {
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

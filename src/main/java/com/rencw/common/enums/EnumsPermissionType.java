package com.rencw.common.enums;

/**  
 * @ClassName: EnumsPermissionType  
 * @Description: 权限类型
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
public enum EnumsPermissionType {
	
	DIRECTORY ("0"),
	ENUM ("1"),
	OPERATION ("2");
	
	private String value;

	private EnumsPermissionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}

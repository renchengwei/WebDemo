package com.rencw.dto.result;

import com.rencw.pojo.BaseBean;

public class BaseResult extends BaseBean {

	/**  
	 * @Fields field:TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 1L;

	/**  
	 * @Fields field:返回结果描述
	 */
	private String message;
	/**  
	 * @Fields field:返回结果编码
	 */
	private Integer code;
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

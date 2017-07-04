package com.rencw.dto.result;

import com.rencw.pojo.BaseBean;

public class PageItem extends BaseBean {

	/**  
	 * @Fields field:TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 1L;
	
	public PageItem(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}
	private String url;
	private String message;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

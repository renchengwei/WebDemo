package com.rencw.dto.result;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: PageResult  
 * @Description: 页面结果返回对象，包含了页面再操作对象
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
public class PageResult extends BaseResult {

	/**  
	 * @Fields field:TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PageItem> pageItems = new ArrayList<PageItem>();

	public List<PageItem> getPageItems() {
		return pageItems;
	}

	public void addPageItem(PageItem item) {
		pageItems.add(item);
	}
}

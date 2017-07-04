package com.rencw.dto.result;

import java.util.List;

/**  
 * @ClassName: DatatablesViewPage  
 * @Description: 动态表格返回值，包含了分页信息
 * @author renchengwei  
 * @date 2017年7月4日  
 *  
 * @param <T>  
 */
public class DatatablesViewPage<T> extends BaseResult {

	/**  
	 * @Fields field:TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 1L;
	private Long recordsFiltered;
	private Long recordsTotal;
	private List<T> data;
	private Integer draw;
	public Long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public Long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
}

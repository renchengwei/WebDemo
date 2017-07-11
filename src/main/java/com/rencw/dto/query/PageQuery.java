package com.rencw.dto.query;

public class PageQuery {
	private Integer start = 0;
	private Integer length = 0;
	@SuppressWarnings("unused")
	private Integer end;
	private Integer draw;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getEnd() {
		return length;
	}
}

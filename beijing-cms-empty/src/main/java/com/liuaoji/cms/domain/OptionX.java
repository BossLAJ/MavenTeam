package com.liuaoji.cms.domain;

public class OptionX {
	private String option;
	private Long count;
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OptionX [option=" + option + ", count=" + count + "]";
	}
	public OptionX(String option, Long count) {
		super();
		this.option = option;
		this.count = count;
	}
	public OptionX() {
		super();
		this.option = option;
	}
	
}

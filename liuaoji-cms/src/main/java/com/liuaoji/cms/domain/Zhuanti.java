package com.liuaoji.cms.domain;

public class Zhuanti {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Zhuanti [id=" + id + ", name=" + name + "]";
	}
	public Zhuanti(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Zhuanti() {
		super();
	}
}

package com.liuaoji.bean;

public class Profession {
	private int pid;
	private String pname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Profession [pid=" + pid + ", pname=" + pname + "]";
	}
	public Profession(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	public Profession() {
		super();
	}
	
	
	
}

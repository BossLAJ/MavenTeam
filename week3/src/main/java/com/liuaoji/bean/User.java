package com.liuaoji.bean;

public class User {
	private int id;
	private String name;
	private String addr;
	private int pid;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addr=" + addr + ", pid=" + pid + "]";
	}
	public User(int id, String name, String addr, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.pid = pid;
	}
	public User() {
		super();
	}
	
	
}

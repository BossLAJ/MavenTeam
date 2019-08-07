package com.liuaoji.bean;

import java.sql.Date;

public class Movie {
	private int mid;
	private String mauthor;
	private String mname;
	private int mprice;
	private int mtime;
	private Date mdate;
	private String mtype;
	private int myear;
	private String mcountry;
	private int mstatus;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMauthor() {
		return mauthor;
	}
	public void setMauthor(String mauthor) {
		this.mauthor = mauthor;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public int getMtime() {
		return mtime;
	}
	public void setMtime(int mtime) {
		this.mtime = mtime;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public int getMyear() {
		return myear;
	}
	public void setMyear(int myear) {
		this.myear = myear;
	}
	public String getMcountry() {
		return mcountry;
	}
	public void setMcountry(String mcountry) {
		this.mcountry = mcountry;
	}
	public int getMstatus() {
		return mstatus;
	}
	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}
	public Movie(int mid, String mauthor, String mname, int mprice, int mtime, Date mdate, String mtype, int myear,
			String mcountry, int mstatus) {
		super();
		this.mid = mid;
		this.mauthor = mauthor;
		this.mname = mname;
		this.mprice = mprice;
		this.mtime = mtime;
		this.mdate = mdate;
		this.mtype = mtype;
		this.myear = myear;
		this.mcountry = mcountry;
		this.mstatus = mstatus;
	}
	public Movie(String mauthor, String mname, int mprice, int mtime, Date mdate, String mtype, int myear,
			String mcountry, int mstatus) {
		super();
		this.mauthor = mauthor;
		this.mname = mname;
		this.mprice = mprice;
		this.mtime = mtime;
		this.mdate = mdate;
		this.mtype = mtype;
		this.myear = myear;
		this.mcountry = mcountry;
		this.mstatus = mstatus;
	}
	public Movie() {
		super();
	}
	
	
}

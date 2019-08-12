package com.liuaoji.bean;

import java.util.Date;

public class Link {
	private int id;
	private String name;
	private String link;
	private Date create;
	private int score;
	private String substr;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSubstr() {
		return substr;
	}
	public void setSubstr(String substr) {
		this.substr = substr;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", link=" + link + ", create=" + create + ", score=" + score
				+ ", substr=" + substr + "]";
	}
	public Link(int id, String name, String link, Date create, int score, String substr) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.create = create;
		this.score = score;
		this.substr = substr;
	}
	public Link() {
		super();
	}
}

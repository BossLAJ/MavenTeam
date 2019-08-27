package com.liuaoji.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class Vote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;//编号
	private Article article;//投票文章
	private User user;//投票用户
	private String optResult;//用户投票选项
	private Date voteTime;//投票时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOptResult() {
		return optResult;
	}
	public void setOptResult(String optResult) {
		this.optResult = optResult;
	}
	public Date getVoteTime() {
		return voteTime;
	}
	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", article=" + article + ", user=" + user + ", optResult=" + optResult + ", voteTime="
				+ voteTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optResult == null) ? 0 : optResult.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((voteTime == null) ? 0 : voteTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optResult == null) {
			if (other.optResult != null)
				return false;
		} else if (!optResult.equals(other.optResult))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (voteTime == null) {
			if (other.voteTime != null)
				return false;
		} else if (!voteTime.equals(other.voteTime))
			return false;
		return true;
	}
	public Vote(Integer id, Article article, User user, String optResult, Date voteTime) {
		super();
		this.id = id;
		this.article = article;
		this.user = user;
		this.optResult = optResult;
		this.voteTime = voteTime;
	}
	public Vote() {
		super();
	}
}

package com.huzhiyi.housereadily.entity;

import java.io.Serializable;

public class TaskUserTrend implements Serializable {

	private Integer rownum;
	private Integer userId;
	private String userName;
	private Integer sumGrowing;

	public Integer getRownum() {
		return rownum;
	}

	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSumGrowing() {
		return sumGrowing;
	}

	public void setSumGrowing(Integer sumGrowing) {
		this.sumGrowing = sumGrowing;
	}
}

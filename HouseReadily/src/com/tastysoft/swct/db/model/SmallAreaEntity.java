package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class SmallAreaEntity implements Serializable {
	private Integer smallAreaCode;
	private String smallAreaName;
	private Integer bigAreaCode;
	
	
	public SmallAreaEntity() {
	}
	public SmallAreaEntity(Integer smallAreaCode, String smallAreaName,
			Integer bigAreaCode) {
		this.smallAreaCode = smallAreaCode;
		this.smallAreaName = smallAreaName;
		this.bigAreaCode = bigAreaCode;
	}
	public Integer getSmallAreaCode() {
		return smallAreaCode;
	}
	public void setSmallAreaCode(Integer smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
	}
	public String getSmallAreaName() {
		return smallAreaName;
	}
	public void setSmallAreaName(String smallAreaName) {
		this.smallAreaName = smallAreaName;
	}
	public Integer getBigAreaCode() {
		return bigAreaCode;
	}
	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}
	
	
}

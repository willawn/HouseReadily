package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class BigAreaEntity implements Serializable  {
	private Integer bigAreaCode;
	private String bigAreaName;
	private Integer cityCode;
	
	public BigAreaEntity() {
	}
	public BigAreaEntity(Integer bigAreaCode, String bigAreaName, Integer cityCode) {
		this.bigAreaCode = bigAreaCode;
		this.bigAreaName = bigAreaName;
		this.cityCode = cityCode;
	}
	public Integer getBigAreaCode() {
		return bigAreaCode;
	}
	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}
	public String getBigAreaName() {
		return bigAreaName;
	}
	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	
}

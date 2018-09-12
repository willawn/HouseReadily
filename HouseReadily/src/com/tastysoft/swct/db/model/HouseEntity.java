package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class HouseEntity implements Serializable {
   private Integer houseId;
   private String commName;
   private float price;
   private String areaNum;
   private Integer isDomnus;
   
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAreaNum() {
		return areaNum;
	}
	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}
	public Integer getIsDomnus() {
		return isDomnus;
	}
	public void setIsDomnus(Integer isDomnus) {
		this.isDomnus = isDomnus;
	}
   
   
}

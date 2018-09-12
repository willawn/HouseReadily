package com.tastysoft.swct.db.model;

import java.util.List;

public class HouseWebsiteEntity {

	private Integer houseId;
	private String proName;
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public List<WebListEntity> getWebsitesList() {
		return websitesList;
	}
	public void setWebsitesList(List<WebListEntity> websitesList) {
		this.websitesList = websitesList;
	}
	private List<WebListEntity> websitesList;

	
}

package com.tastysoft.swct.db.model;

import java.util.List;

import com.tastysoft.swct.db.model.WebSitesEntity;

public class HouseHistorysEntity {

	private Integer houseId;
	private String proName;
	private List<WebSitesEntity> webList;
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
	public List<WebSitesEntity> getWebList() {
		return webList;
	}
	public void setWebList(List<WebSitesEntity> webList) {
		this.webList = webList;
	}
	
	
}

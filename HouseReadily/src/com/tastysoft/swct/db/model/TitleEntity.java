package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class TitleEntity implements Serializable  {

	private String proName;  // 房源标题
	//private Integer userCount;
	
	public TitleEntity() {
	}
	public TitleEntity(String proName) {
		this.proName = proName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	
}

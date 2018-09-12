package com.tastysoft.swct.db.model;

import java.io.Serializable;
/**
 * 房源内容描述
 * @author Administrator
 *
 */
public class ContentEntity implements Serializable {

	private String detailText;
	//private Integer userCount;
	
	
	public ContentEntity() {
	}
	public ContentEntity(String detailText) {
		this.detailText = detailText;
		//this.userCount = userCount;
	}
	public String getDetailText() {
		return detailText;
	}
	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
}

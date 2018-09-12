package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;

public class FeileiUrl extends TastyEntity{
	
	private String urlClassName;
	private Integer urlLevel;
	private Integer urlTopClass; 
	private Integer urlClassId; 
	private Integer urlVerity; 
	private String urlMemo;
	
	
	public String getUrlClassName() {
		return urlClassName;
	}
	public void setUrlClassName(String urlClassName) {
		this.urlClassName = urlClassName;
	}
	public Integer getUrlLevel() {
		return urlLevel;
	}
	public void setUrlLevel(Integer urlLevel) {
		this.urlLevel = urlLevel;
	}
	public Integer getUrlTopClass() {
		return urlTopClass;
	}
	public void setUrlTopClass(Integer urlTopClass) {
		this.urlTopClass = urlTopClass;
	}
	public Integer getUrlVerity() {
		return urlVerity;
	}
	public void setUrlVerity(Integer urlVerity) {
		this.urlVerity = urlVerity;
	}
	public String getUrlMemo() {
		return urlMemo;
	}
	public void setUrlMemo(String urlMemo) {
		this.urlMemo = urlMemo;
	} 
	public Integer getUrlClassId() {
		return urlClassId;
	}
	public void setUrlClassId(Integer urlClassId) {
		this.urlClassId = urlClassId;
	}
	
}

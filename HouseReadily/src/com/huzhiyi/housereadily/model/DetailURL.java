package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;

public class DetailURL extends TastyEntity{
	private Integer urlId; 
	private Integer urlClassId; 
	private String urlTitle; 
	private String urlInfo; 
	private Integer urlVerity; 
	private String urlMemo; 
	private String urlEmail; 
	private Integer urlTopId; 
	private Integer urlTj;
	public Integer getUrlId() {
		return urlId;
	}
	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}
	public Integer getUrlClassId() {
		return urlClassId;
	}
	public void setUrlClassId(Integer urlClassId) {
		this.urlClassId = urlClassId;
	}
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	public String getUrlInfo() {
		return urlInfo;
	}
	public void setUrlInfo(String urlInfo) {
		this.urlInfo = urlInfo;
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
	public String getUrlEmail() {
		return urlEmail;
	}
	public void setUrlEmail(String urlEmail) {
		this.urlEmail = urlEmail;
	}
	public Integer getUrlTopId() {
		return urlTopId;
	}
	public void setUrlTopId(Integer urlTopId) {
		this.urlTopId = urlTopId;
	}
	public Integer getUrlTj() {
		return urlTj;
	}
	public void setUrlTj(Integer urlTj) {
		this.urlTj = urlTj;
	} 
	
	
	
}

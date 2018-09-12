package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class Websites implements Serializable {

	private Integer webId;
	private String webName;
	
	
	public Websites() {
	}
	public Websites(Integer webId, String webName) {
		this.webId = webId;
		this.webName = webName;
	}
	public Integer getWebId() {
		return webId;
	}
	public void setWebId(Integer webId) {
		this.webId = webId;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	
}

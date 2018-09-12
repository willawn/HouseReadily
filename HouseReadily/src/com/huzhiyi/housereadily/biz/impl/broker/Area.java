package com.huzhiyi.housereadily.biz.impl.broker;

import java.util.ArrayList;
import java.util.List;

public class Area {
	private String name;
	private String url;
	private List<SubArea> subAreas = new ArrayList<SubArea>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SubArea> getSubAreas() {
		return subAreas;
	}

	public void setSubAreas(List<SubArea> subAreas) {
		this.subAreas = subAreas;
	}
}

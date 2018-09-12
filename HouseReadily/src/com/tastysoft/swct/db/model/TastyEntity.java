package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class TastyEntity implements Serializable{
	
	public String jsonPropsFilter = null;

	public String filterType="yes"; 
	
	
	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public String getJsonPropsFilter() {
		return jsonPropsFilter;
	}

	public void setJsonPropsFilter(String jsonPropsFilter) {
		this.jsonPropsFilter = jsonPropsFilter;
	}
	
	
}

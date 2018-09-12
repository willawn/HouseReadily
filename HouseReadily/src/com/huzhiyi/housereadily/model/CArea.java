package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;


public class CArea extends TastyEntity{
	
	private int id;
	private String name;
	private int parentId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("id:"+id+",");
		sb.append("name:"+name+",");
		sb.append("parentId:"+parentId);
		return sb.toString();
	}

}

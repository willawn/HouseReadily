package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;

public class CHouseCfg extends TastyEntity {

	private int id;
	private Integer cid;
	private String name;
	private Integer ctype;
	private String range;
	//private Integer citycode;

	/*public Integer getCitycode() {
		return citycode;
	}

	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}*/

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

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + id + ",");
		sb.append("name:" + name + ",");
		return sb.toString();
	}

}

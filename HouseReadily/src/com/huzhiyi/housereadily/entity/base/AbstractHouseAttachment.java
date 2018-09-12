package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractHouseAttachment entity provides the base persistence definition of
 * the HouseAttachment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHouseAttachment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private Integer houseReadilyId;
	private String name;
	private String description;
	private String spath;
	private String mpath;
	private String path;
	private Integer size;
	private Integer isPicture;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractHouseAttachment() {
	}

	/** minimal constructor */
	public AbstractHouseAttachment(String type, Integer houseReadilyId) {
		this.type = type;
		this.houseReadilyId = houseReadilyId;
	}

	/** full constructor */
	public AbstractHouseAttachment(String type, Integer houseReadilyId, String name, String description, String spath, String mpath, String path, Integer size,
			Integer isPicture, Timestamp createTime) {
		this.type = type;
		this.houseReadilyId = houseReadilyId;
		this.name = name;
		this.description = description;
		this.spath = spath;
		this.mpath = mpath;
		this.path = path;
		this.size = size;
		this.isPicture = isPicture;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHouseReadilyId() {
		return this.houseReadilyId;
	}

	public void setHouseReadilyId(Integer houseReadilyId) {
		this.houseReadilyId = houseReadilyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpath() {
		return spath;
	}

	public void setSpath(String spath) {
		this.spath = spath;
	}

	public String getMpath() {
		return mpath;
	}

	public void setMpath(String mpath) {
		this.mpath = mpath;
	}
	
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getIsPicture() {
		return this.isPicture;
	}

	public void setIsPicture(Integer isPicture) {
		this.isPicture = isPicture;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
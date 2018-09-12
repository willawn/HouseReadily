package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractHouseAttachment;

/**
 * HouseAttachment entity. @author MyEclipse Persistence Tools
 */
public class HouseAttachment extends AbstractHouseAttachment implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public HouseAttachment() {
	}

	/** minimal constructor */
	public HouseAttachment(String type, Integer houseReadilyId) {
		super(type, houseReadilyId);
	}

	/** full constructor */
	public HouseAttachment(String type, Integer houseReadilyId, String name, String description, String spath, String mpath, String path,
			Integer size, Integer isPicture, Timestamp createTime) {
		super(type, houseReadilyId, name, description, spath, mpath, path, size, isPicture, createTime);
	}

}

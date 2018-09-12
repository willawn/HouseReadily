package com.huzhiyi.housereadily.response;

import com.tastysoft.swct.db.model.TastyEntity;

public class BaseResult extends Result{
	
	private TastyEntity entity;

	public TastyEntity getEntity() {
		return entity;
	}

	public void setEntity(TastyEntity entity) {
		this.entity = entity;
	}
	
}

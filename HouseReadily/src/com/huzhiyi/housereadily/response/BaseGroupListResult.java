package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class BaseGroupListResult extends Result {

	private int status;
	private JSONObject baseGroups;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JSONObject getBaseGroups() {
		return baseGroups;
	}

	public void setBaseGroups(JSONObject baseGroups) {
		this.baseGroups = baseGroups;
	}
}

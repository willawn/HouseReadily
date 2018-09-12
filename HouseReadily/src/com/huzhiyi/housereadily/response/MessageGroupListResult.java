package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class MessageGroupListResult extends Result {
	private int status;
	private JSONObject messageGroups;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public JSONObject getMessageGroups() {
		return messageGroups;
	}
	public void setMessageGroups(JSONObject messageGroups) {
		this.messageGroups = messageGroups;
	}
}

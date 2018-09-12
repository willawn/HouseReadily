package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class TaskListResult extends Result {

	private JSONObject tasks;

	public JSONObject getTasks() {
		return tasks;
	}

	public void setTasks(JSONObject tasks) {
		this.tasks = tasks;
	}
}

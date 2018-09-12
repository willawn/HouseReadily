package com.huzhiyi.housereadily.response;

import com.huzhiyi.housereadily.request.ICommand;

public class Result {
	private ICommand command;
	
	public String jsonPropsFilter = null;

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public String getJsonPropsFilter() {
		return jsonPropsFilter;
	}

	public void setJsonPropsFilter(String jsonPropsFilter) {
		this.jsonPropsFilter = jsonPropsFilter;
	}
	
	
}

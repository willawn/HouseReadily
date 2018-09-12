package com.huzhiyi.housereadily.request;

public class ListCommand extends BaseCommand implements IListCommand {
	private int limit;
	private int pageNo;

	public ListCommand() {
		super();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}

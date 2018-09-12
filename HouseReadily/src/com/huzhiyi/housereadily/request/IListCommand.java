package com.huzhiyi.housereadily.request;


public interface IListCommand extends ICommand{
	public int getLimit();
	public void setLimit(int limit);
	public int getPageNo();
	public void setPageNo(int pageNo);
}

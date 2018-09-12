package com.huzhiyi.housereadily.request;

import java.util.Date;

public interface ICommand {
	public String getAuth();
	public void setAuth(String auth);
	public String getFormat() ;
	public void setFormat(String format);
	public int getUserId();
	public void setUserId(int userId);
	public Date getTimestamp();
	public void setTimestamp(Date timestamp);
	public String getMethod();
	public void setMethod(String method);
	public String getAction();
	public void setAction(String action);
	public String getType();
	public void setType(String type);
	public String getOperate();
	public void setOperate(String operate);
	public String getIp();
	public void setIp(String ip);
}

package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;

public class CSuggestions extends TastyEntity{
	
	private Integer id;
	private int userId;
	private String userName;
	private Date insertTime;
	private String title;
	private String content;
	private int isRead;
	private int level;
	private int pid;
	private String lastContent;
	private Date lastInsertTime;
	private String lastName;
	private int isAdminRead;
	private Date lastViewTime;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	
	public String getContentS(int index){
		if(level==1){
			boolean ret = getIsLastContentReply();
			if(ret){
				if(this.lastContent!=null){
					return this.lastContent.split("@###@")[index];
				}
				return "";
			}else{
				return this.lastContent;
			}
		}else{
			boolean ret = getIsReply();
			if(ret){
				if(this.content!=null){
					String[] strSplit = this.content.split("@###@");
					if(strSplit.length==2)
						return this.content.split("@###@")[index];
					else
						return"";
				}
				return "";
			}else{
				return this.content;
			}
		}
	}
	
	public String getNeedContent(){
		return getContentS(0);
	}
	
	public String getNeedReply(){
		return getContentS(1);
	}
	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public String getLastContent() {
		return lastContent;
	}

	public void setLastContent(String lastContent) {
		this.lastContent = lastContent;
	}

	public Date getLastInsertTime() {
		return lastInsertTime;
	}

	public void setLastInsertTime(Date lastInsertTime) {
		this.lastInsertTime = lastInsertTime;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIsAdminRead() {
		return isAdminRead;
	}

	public void setIsAdminRead(int isAdminRead) {
		this.isAdminRead = isAdminRead;
	}
	
	
	public String getDateStr(){
		String dateStr="";
		if(level==1){
			dateStr = DateHelper.dateToString(lastInsertTime);
		}else{
			dateStr = DateHelper.dateToString(insertTime);
		}
		return dateStr;
	}
	
	public String getInsertTimeStr(){
		String dateStr="";
		dateStr = DateHelper.dateToString(insertTime);
		return dateStr;
	}
	
	public boolean getIsReply(){
		boolean ret = false;
		if(content!=null){
			if(content.indexOf("@###@")>-1){
				ret = true;
			}
		}
		return ret;
	}
	
	public boolean getIsLastContentReply(){
		boolean ret = false;
		if(lastContent!=null){
			if(lastContent.indexOf("@###@")>-1){
				ret = true;
			}
		}
		return ret;
	}
	
	public String getCurUserName(){
		String curUserName="";
		if(level==1){
			curUserName = this.lastName;
		}else{
			curUserName = this.userName;
		}
		return curUserName;
	}

	public Date getLastViewTime() {
		return lastViewTime;
	}

	public void setLastViewTime(Date lastViewTime) {
		this.lastViewTime = lastViewTime;
	}
	
	
}

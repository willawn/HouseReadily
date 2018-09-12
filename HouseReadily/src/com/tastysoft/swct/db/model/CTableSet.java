package com.tastysoft.swct.db.model;

import com.tastysoft.swct.db.table.TableSet;

public class CTableSet {

	private String lastSyncTime;
	private TableSet tableSet;
	public String getLastSyncTime() {
		return lastSyncTime;
	}
	public void setLastSyncTime(String lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	public TableSet getTableSet() {
		return tableSet;
	}
	public void setTableSet(TableSet tableSet) {
		this.tableSet = tableSet;
	}
	
}

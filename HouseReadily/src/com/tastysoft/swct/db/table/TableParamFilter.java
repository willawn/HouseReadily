package com.tastysoft.swct.db.table;

public class TableParamFilter {
	private String filterDataType;
	private String filterDataValue;
	private String filterField;
	private String filterFieldComparison;
	public String getFilterDataType() {
		return filterDataType;
	}
	public void setFilterDataType(String filterDataType) {
		this.filterDataType = filterDataType;
	}
	public String getFilterDataValue() {
		return filterDataValue;
	}
	public void setFilterDataValue(String filterDataValue) {
		this.filterDataValue = filterDataValue;
	}
	public String getFilterField() {
		return filterField;
	}
	public void setFilterField(String filterField) {
		this.filterField = filterField;
	}
	public String getFilterFieldComparison() {
		return filterFieldComparison;
	}
	public void setFilterFieldComparison(String filterFieldComparison) {
		this.filterFieldComparison = filterFieldComparison;
	}
}

package com.tastysoft.swct.db.table;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;


public class TableParam{
	
	private int start = 0;
	private int limit = 20;
	private String sort ="id";
	private String dir = "desc";
	private ArrayList<TableParamFilter> filters = new ArrayList();
	private String extendPageStr;
	private String fp;
	private String extendSql;
	
	public void process(HttpServletRequest request){
		if(request.getParameter("start")!=null){
			start = Integer.valueOf(request.getParameter("start"));
		}
		if(request.getParameter("limit")!=null){
			limit = Integer.valueOf(request.getParameter("limit"));
		}
		if(request.getParameter("dir")!=null){
			dir = request.getParameter("dir");
		}
		if(request.getParameter("sort")!=null){
			sort = request.getParameter("sort");
		}
		
		HashMap map = (HashMap)request.getParameterMap();
		HashSet hs = new HashSet();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next().toString();
			if(key.startsWith("filter")){
				key = key.substring(7,8);
				if(!hs.contains(key))
					hs.add(key);
			}
		}
		
		String index;
		TableParamFilter jsonParamFilter = null;
		it = hs.iterator();
		while(it.hasNext()){
			index = it.next().toString();
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(request.getParameter("filter["+index+"][data][type]"));
			jsonParamFilter.setFilterDataValue(decode(request,request.getParameter("filter["+index+"][data][value]")));
			jsonParamFilter.setFilterField(request.getParameter("filter["+index+"][field]"));
			jsonParamFilter.setFilterFieldComparison(request.getParameter("filter["+index+"][data][comparison]"));
			filters.add(jsonParamFilter);
		}
	}

	public void process(HttpServletRequest request,String[] paramNames){
		if(request.getParameter("start")!=null){
			start = Integer.valueOf(request.getParameter("start"));
		}
		if(request.getParameter("limit")!=null){
			limit = Integer.valueOf(request.getParameter("limit"));
		}
		if(request.getParameter("dir")!=null){
			dir = request.getParameter("dir");
		}
		if(request.getParameter("sort")!=null){
			sort = request.getParameter("sort");
		}
		
		HashMap map = (HashMap)request.getParameterMap();
		HashSet hs = new HashSet();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next().toString();
			if(key.startsWith("filter")){
				key = key.substring(7,8);
				if(!hs.contains(key))
					hs.add(key);
			}
		}
		
		String index;
		TableParamFilter jsonParamFilter = null;
		it = hs.iterator();
		while(it.hasNext()){
			index = it.next().toString();
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(request.getParameter("filter["+index+"][data][type]"));
			jsonParamFilter.setFilterDataValue(decode(request,request.getParameter("filter["+index+"][data][value]")));
			jsonParamFilter.setFilterField(request.getParameter("filter["+index+"][field]"));
			jsonParamFilter.setFilterFieldComparison(request.getParameter("filter["+index+"][data][comparison]"));
			filters.add(jsonParamFilter);
		}
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public ArrayList<TableParamFilter> getFilters() {
		return filters;
	}

	public void setFilters(ArrayList<TableParamFilter> filters) {
		this.filters = filters;
	}
	
	public void addJsonParamFilter(TableParamFilter JsonParamFilter){
		this.filters.add(JsonParamFilter);
	}
	
	public static String decode(HttpServletRequest request, String str) {
		if (str == null || str.length() == 0)
			return "";
		String encode = request.getCharacterEncoding();
		if (encode == null || encode.length() == 0)
			encode = "ISO-8859-1";

		try {
			return new String(str.getBytes(encode), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public String getExtendPageStr() {
		return extendPageStr;
	}

	public void setExtendPageStr(String extendPageStr) {
		this.extendPageStr = extendPageStr;
	}
	
	public void appendExtendPageStr(String extendPageStr) {
		this.extendPageStr = this.extendPageStr+extendPageStr;
	}

	public String getFp() {
		return fp;
	}

	public void setFp(String fp) {
		this.fp = fp;
	}

	public String getExtendSql() {
		return extendSql;
	}

	public void setExtendSql(String extendSql) {
		this.extendSql = extendSql;
	}
	
	
}

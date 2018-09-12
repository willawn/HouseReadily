/**   
 * @Title: BaseClient.java
 * @Package com.huzhiyi.housereadily.client
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-10-29
 */
package com.huzhiyi.housereadily.client;

import java.util.Date;

import org.restlet.data.Form;
import org.restlet.data.Parameter;

import com.tastysoft.swct.util.DateHelper;

import junit.framework.TestCase;

/**
 * @ClassName: BaseClient
 * @Description: 描述类
 *               <p>
 * @author willter
 * @date 2012-10-29
 */
public class BaseClient extends TestCase {

	public static String url = "http://localhost:8080/HouseReadily/rest/";
	//public static String url = "http://113.106.93.53:8380/HouseReadily/rest/";
	//public static String url = "http://readily.zushou365.com/rest/";

	public String buildQuery() {
		String auth = "ae5b5f5b0494a0a7eaffdc1658ed5159";
		int userId = 10461;
		String method = "";
		String format = "json";
		Date timestamp = new Date();
		String query = "?auth=" + auth + "&userId=" + userId + "&format=" + format + "&timestamp=" + DateHelper.dateToString(timestamp);
				//+ "&method=" + method;

		return query;
	}

	public Form buildForm() {
		Form form = new Form();
		form.add("auth", "ae5b5f5b0494a0a7eaffdc1658ed5159");
		form.add("userId", "10461");
		form.add("format", "json");
		form.add("timestamp", DateHelper.dateToString(new Date()));
		//form.add("method", "");

		return form;
	}

	public String getBaseUrl(String path) {
		return getBaseUrl(path, null, null);
	}
	
	public String getBaseUrl(String path, String action) {
		return getBaseUrl(path, action, null);
	}

	public String getBaseUrl(String path, Form queryForm) {
		return getBaseUrl(path, null, queryForm);
	}
	
	public String getBaseUrl(String path, String action, Form queryForm) {
		String url_ = url + path + buildQuery();
		if (null != action && action.trim().length() > 0) {
			url_ += "&action=" + action;
		}
		url_ += buildQeuryEx(queryForm);
		System.out.println(url_);
		return url_;
	}

	public String getListUrl(String path, Form queryForm) {
		String url_ = url + path + buildListQuery(1, 10) + buildQeuryEx(queryForm);
		System.out.println(url_);
		return url_;
	}

	public String getListUrl(String path, int pageNo, int limit, Form queryForm) {
		String url_ = url + path + buildListQuery(pageNo, limit) + buildQeuryEx(queryForm);
		System.out.println(url_);
		return url_;
	}

	public String buildListQuery(int pageNo, int limit) {
		String query = buildQuery() + "&limit=" + limit + "&pageNo=" + pageNo;
		return query;
	}

	public String buildQeuryEx(Form queryForm) {
		if (queryForm == null)
			return "";
		String str = "";
		for (Parameter parameter : queryForm) {
			str += "&" + parameter.getName() + "=" + parameter.getValue();
		}
		return str;
	}
}

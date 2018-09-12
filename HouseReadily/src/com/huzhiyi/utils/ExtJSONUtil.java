/**   
 * @Title: ExtJSONUtil.java
 * @Package com.zushou365.utils
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-9-7
 */
package com.huzhiyi.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.huzhiyi.model.PagingBean;

/**
 * @ClassName: ExtJSONUtil
 * @Description: Ext JSON工具类
 *               <p>
 * @author willter
 * @date 2012-9-7
 */
public class ExtJSONUtil {

	public static void retJson(HttpServletResponse response, JSONObject jsonObject) throws IOException {
		retJson(response, "(" + jsonObject.toString() + ")");
	}

	public static void retJson(HttpServletResponse response, String jsonString) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
	}
	
	/**
	 * @Title: getJSONByGridPanel
	 * @Description: 分页对象转换为Ext GridPanel JSON对象
	 * 		<p>
	 * @author willter
	 * @date 2013-3-26
	 * 		<p>
	 * @param pagingBean
	 * @param collection
	 * @param parseDataKey
	 * @param field
	 * @return
	 */
	public static JSONObject getJSONByGridPanel(PagingBean pagingBean, Collection collection, Map parseDataKey, String... field) {
		JSONObject jsonObject = new JSONObject();

		try {
			// 数据列表
			List dataList = new ArrayList();
			Map dataMap = null;
			String value = null;

			String[] parseCollKey = null;
			if (parseDataKey.containsKey(Constants.PARSECOLLKEY)) {
				parseCollKey = (String[]) parseDataKey.get(Constants.PARSECOLLKEY);
			}

			for (Object object : collection) {
				dataMap = new HashMap();
				for (String property : field) { // object是一个POJO
					value = BeanUtils.getProperty(object, property);
					dataMap.put(property, ResponseUtils.processParseData(property, value, parseDataKey));
				}
				dataList.add(dataMap);
			}
			jsonObject.put("rows", dataList);

			// 分页对象信息
			if (null != pagingBean) {
				jsonObject.put("total", pagingBean.getMaxRows()); // 总行数
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}

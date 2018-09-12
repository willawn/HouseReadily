package com.huzhiyi.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;

/**
 * HttpServletResponse帮助类
 * 
 * @author willter
 * 
 */
public final class ResponseUtils {
	public static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

	/**
	 * 发送文本。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}

	/**
	 * 发送json。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}

	/**
	 * 发送xml。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderXml(HttpServletResponse response, String text) {
		render(response, "text/xml;charset=UTF-8", text);
	}

	/**
	 * 发送内容。使用UTF-8编码。
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * @Title: getJSONByModel
	 * @Description: 对象转换为JSON对象
	 *               <p>
	 * @author willter
	 * @date 2012-9-25
	 *       <p>
	 * @param model
	 * @param object
	 * @param parseDataKey
	 * @param field
	 * @return
	 */
	public static JSONObject getJSONByModel(String jsonKey, Object object, Map parseDataKey, String... field) {
		JSONObject jsonObject = new JSONObject();

		try {
			String value = null;
			Map dataMap = null;

			String[] parseCollKey = null;
			if (parseDataKey.containsKey(Constants.PARSECOLLKEY)) {
				parseCollKey = (String[]) parseDataKey.get(Constants.PARSECOLLKEY);
			}

			if (null != object) {
				if (object instanceof Collection) {
					// Collection集合
					Collection collection = (Collection) object;
					List dataList = new ArrayList();
					Iterator it = collection.iterator();
					Object v = null;
					while (it.hasNext()) {
						dataMap = new HashMap();
						v = (Object) it.next();
						for (String property : field) {
							if (isExists(parseCollKey, property)) {
								processCollProperty(v, property, parseDataKey, dataMap);
							} else {
								value = BeanUtils.getProperty(v, property);
								dataMap.put(property, processParseData(property, value, parseDataKey));
							}
						}
						dataList.add(dataMap);
					}
					jsonObject.put(jsonKey, dataList);
				} else {
					// 数据对象
					dataMap = new HashMap();
					for (String property : field) {
						if (isExists(parseCollKey, property)) {
							processCollProperty(object, property, parseDataKey, dataMap);
						} else {
							value = BeanUtils.getProperty(object, property);
							dataMap.put(property, processParseData(property, value, parseDataKey));
						}
					}
					jsonObject.put(jsonKey, dataMap);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	/**
	 * @Title: getJSONByPagination
	 * @Description: 分页对象转换为JSON对象
	 *               <p>
	 * @author willter
	 * @date 2012-9-23
	 *       <p>
	 * @param pagingBean
	 * @param list
	 * @param parseDataKey
	 * @param field
	 * @return JSON对象
	 */
	public static JSONObject getJSONByPagingBean(PagingBean pagingBean, Collection collection, Map parseDataKey, String... field) {
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
				if (object instanceof Object[]) { // object的类型为Object[]
					Object[] objArray = (Object[]) object;
					for (int i = 0, len = objArray.length; i < len; i++) {
						dataMap.put(field[i], processParseData(field[i], objArray[i].toString(), parseDataKey));
					}
				} else {
					for (String property : field) { // object是一个POJO
						if (isExists(parseCollKey, property)) {
							processCollProperty(object, property, parseDataKey, dataMap);
						} else {
							value = BeanUtils.getProperty(object, property);
							dataMap.put(property, processParseData(property, value, parseDataKey));
						}
					}
				}
				dataList.add(dataMap);
			}
			jsonObject.put("list", dataList);

			// 分页对象信息
			if (null != pagingBean) {
				JSONObject pageJSON = new JSONObject();
				pageJSON.put("pageSize", pagingBean.getPageRows()); // 每页多少行
				pageJSON.put("pageNo", pagingBean.getCurrentPage()); // 页码
				pageJSON.put("totalCount", pagingBean.getMaxRows()); // 总行数
				pageJSON.put("totalPage", pagingBean.getMaxPages()); // 总页数
				jsonObject.put("pagingBean", pageJSON);
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

	public static boolean isExists(String[] strArray, String str) {
		if (null != strArray) {
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].equals(str)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @Title: processCollProperty
	 * @Description: 执行集合数据类型转换
	 *               <p>
	 * @author willter
	 * @date 2012-11-2
	 *       <p>
	 * @param object
	 * @param property
	 * @param parseDataKey
	 * @param dataMap
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ParseException
	 */
	public static void processCollProperty(Object object, String property, Map parseDataKey, Map dataMap) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, ParseException {
		Collection coll = (Collection) PropertyUtils.getProperty(object, property);

		if (null != coll) {
			int index = 0;
			String[] parseCollKey = (String[]) parseDataKey.get(Constants.PARSECOLLKEY);
			for (int i = 0; i < parseCollKey.length; i++) {
				if (parseCollKey[i].equals(property)) {
					index = i;
					break;
				}
			}
			String[][] collFields = (String[][]) parseDataKey.get(Constants.PARSECOLLFIELD);
			String[] collField = collFields[index];
			List collList = new ArrayList();
			Iterator it = coll.iterator();
			Object v = null;
			while (it.hasNext()) {
				Map setMap = new HashMap();
				v = (Object) it.next();
				for (String setProperty : collField) {
					String value = BeanUtils.getProperty(v, setProperty);
					setMap.put(setProperty, processParseData(setProperty, value, parseDataKey));
				}
				collList.add(setMap);
			}

			Map m = new HashMap();
			m.put("list", collList);
			dataMap.put(property, m);
		}
	}

	/**
	 * @Title: processParseData
	 * @Description: 执行数据类型转换
	 *               <p>
	 * @author willter
	 * @date 2012-9-25
	 *       <p>
	 * @param property
	 * @param value
	 * @param parseDataKey
	 * @return
	 * @throws ParseException
	 */
	public static String processParseData(String property, String value, Map parseDataKey) throws ParseException {
		String result = value;

		if (null == value || value.trim().length() == 0) {
			result = "";
		}

		if (null != parseDataKey) {
			// 日期类型转换
			if (parseDataKey.containsKey(Constants.PARSEDATEKEY)) {
				String[] parseDateKey = (String[]) parseDataKey.get(Constants.PARSEDATEKEY);
				if (null != parseDateKey && parseDateKey.length > 0) {
					for (int i = 0; i < parseDateKey.length; i++) {
						if (parseDateKey[i].equals(property)) {
							if (null == value || value.trim().length() == 0) {
								result = "";
							} else {
								result = DateUtils.format(value);
							}
							break;
						}
					}
				}
			}

			// 图片类型转换
			if (parseDataKey.containsKey(Constants.PARSEIMGKEY)) {
				String[] parseImgKey = (String[]) parseDataKey.get(Constants.PARSEIMGKEY);
				if (null != parseImgKey && parseImgKey.length > 0) {
					for (int i = 0; i < parseImgKey.length; i++) {
						if (parseImgKey[i].equals(property)) {
							if (null == value || value.trim().length() == 0) {
								result = "";
							} else {
								result = Configuration.WEB_SITE_PATH + value;
							}
							break;
						}
					}
				}
			}
		}

		return result;
	}
}

package com.huzhiyi.utils;

import static com.huzhiyi.utils.Constants.POST;
import static com.huzhiyi.utils.Constants.UTF8;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.restlet.data.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UrlPathHelper;

import com.tastysoft.swct.util.DateHelper;

/**
 * HttpServletRequest帮助类
 * 
 * @author willter
 * 
 */
public class RequestUtils {
	private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

	/**
	 * 获取QueryString的参数，并使用URLDecoder以UTF-8格式转码。如果请求是以post方法提交的，
	 * 那么将通过HttpServletRequest#getParameter获取。
	 * 
	 * @param request
	 *            web请求
	 * @param name
	 *            参数名称
	 * @return
	 */
	public static String getQueryParam(HttpServletRequest request, String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		if (request.getMethod().equalsIgnoreCase(POST)) {
			return request.getParameter(name);
		}
		String s = request.getQueryString();
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			s = URLDecoder.decode(s, UTF8);
		} catch (UnsupportedEncodingException e) {
			log.error("encoding " + UTF8 + " not support?", e);
		}
		String[] values = parseQueryString(s).get(name);
		if (values != null && values.length > 0) {
			return values[values.length - 1];
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getQueryParams(HttpServletRequest request) {
		Map<String, String[]> map;
		if (request.getMethod().equalsIgnoreCase(POST)) {
			map = request.getParameterMap();
		} else {
			String s = request.getQueryString();
			if (StringUtils.isBlank(s)) {
				return new HashMap<String, Object>();
			}
			try {
				s = URLDecoder.decode(s, UTF8);
			} catch (UnsupportedEncodingException e) {
				log.error("encoding " + UTF8 + " not support?", e);
			}
			map = parseQueryString(s);
		}

		Map<String, Object> params = new HashMap<String, Object>(map.size());
		int len;
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			len = entry.getValue().length;
			if (len == 1) {
				params.put(entry.getKey(), entry.getValue()[0]);
			} else if (len > 1) {
				params.put(entry.getKey(), entry.getValue());
			}
		}
		return params;
	}

	/**
	 * 
	 * Parses a query string passed from the client to the server and builds a
	 * <code>HashTable</code> object with key-value pairs. The query string
	 * should be in the form of a string packaged by the GET or POST method,
	 * that is, it should have key-value pairs in the form <i>key=value</i>,
	 * with each pair separated from the next by a &amp; character.
	 * 
	 * <p>
	 * A key can appear more than once in the query string with different
	 * values. However, the key appears only once in the hashtable, with its
	 * value being an array of strings containing the multiple values sent by
	 * the query string.
	 * 
	 * <p>
	 * The keys and values in the hashtable are stored in their decoded form, so
	 * any + characters are converted to spaces, and characters sent in
	 * hexadecimal notation (like <i>%xx</i>) are converted to ASCII characters.
	 * 
	 * @param s
	 *            a string containing the query to be parsed
	 * 
	 * @return a <code>HashTable</code> object built from the parsed key-value
	 *         pairs
	 * 
	 * @exception IllegalArgumentException
	 *                if the query string is invalid
	 * 
	 */
	public static Map<String, String[]> parseQueryString(String s) {
		String valArray[] = null;
		if (s == null) {
			throw new IllegalArgumentException();
		}
		Map<String, String[]> ht = new HashMap<String, String[]>();
		StringTokenizer st = new StringTokenizer(s, "&");
		while (st.hasMoreTokens()) {
			String pair = (String) st.nextToken();
			int pos = pair.indexOf('=');
			if (pos == -1) {
				continue;
			}
			String key = pair.substring(0, pos);
			String val = pair.substring(pos + 1, pair.length());
			if (ht.containsKey(key)) {
				String oldVals[] = (String[]) ht.get(key);
				valArray = new String[oldVals.length + 1];
				for (int i = 0; i < oldVals.length; i++) {
					valArray[i] = oldVals[i];
				}
				valArray[oldVals.length] = val;
			} else {
				valArray = new String[1];
				valArray[0] = val;
			}
			ht.put(key, valArray);
		}
		return ht;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getRequestMap(HttpServletRequest request, String prefix) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> names = request.getParameterNames();
		String name;
		while (names.hasMoreElements()) {
			name = names.nextElement();
			if (name.startsWith(prefix)) {
				request.getParameterValues(name);
				map.put(name.substring(prefix.length()), StringUtils.join(request.getParameterValues(name), ','));
			}
		}
		return map;
	}

	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request .getRemoteAddr()。
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		if (null == request) {
			return "";
		}
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * @Title: getIpAddress
	 * @Description: 获取IP对应的地址 示例：
	 * 				<?xml version="1.0" encoding="gbk"?>
	 *               <smartresult> 
	 *               <product type="ip"> 
	 *               <ip>115.199.143.118</ip>
	 *               <location>浙江省杭州市 电信</location> 
	 *               </product> 
	 *               </smartresult>
	 * @author willter
	 * @date 2013-4-1
	 *       <p>
	 * @param ip
	 * @return
	 */
	public static String getIpAddress(String ip) {
		if (com.huzhiyi.util.StringUtils.isEmpty(ip)) {
			return "";
		}
		String xml = HttpHelper.doGet(MessageFormat.format(Configuration.SELECT_IP_LOCATION, ip), null, "gbk", false);
		Document doc = null;
		String location = "";
		try {
			// 下面的是通过解析xml字符串的
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Element smartElement = rootElt.element("product");
			location = smartElement.elementTextTrim("location");
		} catch (DocumentException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	/**
	 * 获得当的访问路径
	 * 
	 * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
	 * 
	 * @param request
	 * @return
	 */
	public static String getLocation(HttpServletRequest request) {
		UrlPathHelper helper = new UrlPathHelper();
		StringBuffer buff = request.getRequestURL();
		String uri = request.getRequestURI();
		String origUri = helper.getOriginatingRequestUri(request);
		buff.replace(buff.length() - uri.length(), buff.length(), origUri);
		String queryString = helper.getOriginatingQueryString(request);
		if (queryString != null) {
			buff.append("?").append(queryString);
		}
		return buff.toString();
	}

	/*
	 * 从ruquest中返回指定参数
	 */
	public static String requestPropertyValue(Form form, String key) {
		return requestPropertyValue(form, key, "");
	}

	public static String requestPropertyValue(Form form, String key, String defaultValue) {
		/* ******** iOS 判断 ********* */
		try {
			String operate = form.getFirstValue("operate");
			if (null != operate && "ios".equalsIgnoreCase(operate)) {
				return new String(form.getFirstValue(key, defaultValue).getBytes("ISO-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return form.getFirstValue(key, defaultValue);
	}

	public static Integer requestPropertyIntValue(Form form, String property) {
		return requestPropertyIntValue(form, property, null);
	}

	public static Integer requestPropertyIntValue(Form form, String property, Integer defaultValue) {
		Integer propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Integer.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	public static Date requestPropertyDateValue(Form form, String property) {
		Date propertyValue = null;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = DateHelper.stringToDate(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	public static Float requestPropertyFloatValue(Form form, String property) {
		return requestPropertyFloatValue(form, property, null);
	}

	public static Float requestPropertyFloatValue(Form form, String property, Float defaultValue) {
		Float propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Float.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	/*
	 * 从ruquest中返回指定参数
	 */
	public static String requestPropertyValue(Form form, String property, boolean needDecode) {
		String propertyValue = "";
		if (property == null)
			return "";
		if (form.getFirstValue(property) != null) {
			propertyValue = form.getFirstValue(property).trim();
			if (needDecode) {
				if (propertyValue == null || propertyValue.length() == 0)
					propertyValue = "";
				String encode = null;// request.getCharacterEncoding();
				if (encode == null || encode.length() == 0)
					encode = "ISO-8859-1";
				try {
					propertyValue = new String(propertyValue.getBytes(encode), "utf-8");
				} catch (UnsupportedEncodingException e) {
					propertyValue = "";
				}
			}
		}
		return propertyValue;
	}

	public static Double requestPropertyDoubleValue(Form form, String property, Double defaultValue) {
		double propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Double.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	public static BigDecimal requestPropertyBigDecimalValue(Form form, String property, BigDecimal defaultValue) {
		BigDecimal propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = new BigDecimal(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}
}

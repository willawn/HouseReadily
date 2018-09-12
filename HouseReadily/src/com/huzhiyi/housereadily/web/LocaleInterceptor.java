/**   
 * @Title: ApiLocaleInterceptor.java
 * @Package com.huawei.api.web
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-9-17
 */
package com.huzhiyi.housereadily.web;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @ClassName: ApiLocaleInterceptor
 * @Description: 本地化拦截器
 *               <p>
 * @author willter
 * @date 2012-9-17
 */
public class LocaleInterceptor extends HandlerInterceptorAdapter {

	public static final String LOCALE = "locale";
}

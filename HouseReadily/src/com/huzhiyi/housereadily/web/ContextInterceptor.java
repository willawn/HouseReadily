/**   
 * @Title: ApiContextInterceptor.java
 * @Package com.huawei.api.web
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-9-17
 */
package com.huzhiyi.housereadily.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.RequestUtils;

/**
 * @ClassName: ApiContextInterceptor
 * @Description: 上下文拦截器
 *               <p>
 * @author willter
 * @date 2012-9-17
 */
public class ContextInterceptor extends HandlerInterceptorAdapter {
	private static String[][] unprotectedResources = { 
		{ "admin/index.shtml", }, { "admin/login.do", }, { "activity/growth.shtml", },
		{ "activity/growthmore.shtml", }, { "activity/gz.shtml", }, { "apply/bm.shtml", } ,
		{ "apply/wybm.shtml", }, { "apply/bmxz.shtml", } , { "apply/hdlc.shtml", }
	};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = RequestUtils.getLocation(request);
		if (isUnProtectedResource(path)) {
			return true;
		}
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(Constants.CURRENTUSER) == null) {
			PrintWriter out = response.getWriter();
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			// builder.append("alert(\"页面过期，请重新登录\");");
			builder.append("window.top.location.href=\"");
			builder.append(Configuration.WEB_SITE_PATH);
			builder.append("/admin/index.shtml\";</script>");
			out.print(builder.toString());
			out.close();
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	private boolean isUnProtectedResource(String path) {
		boolean result = false;
		for (int i = 0; i < unprotectedResources.length; i++) {
			result = false;
			for (int j = 0; j < unprotectedResources[i].length; j++) {
				result = path.indexOf(unprotectedResources[i][j]) != -1;
			}
			if (result) {
				return true;
			}
		}
		return false;
	}
}

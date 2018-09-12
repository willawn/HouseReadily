package com.huzhiyi.housereadily.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;

/**
 * @ClassName: BaseController
 * @Description: 基础控制类
 *               <p>
 * @author willter
 * @date 2013-3-26
 */
@Controller
@RequestMapping("/admin")
public class BaseController {

	@RequestMapping("/index.shtml")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void login(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, HttpServletRequest request,
			HttpServletResponse response, Model model) throws JSONException, IOException {
		JSONObject jsonObject = new JSONObject();
		
		if (userName.equals("admin") && password.equals("q123456")) {
			HttpSession session = request.getSession();
			session.setAttribute(Constants.CURRENTUSER, session.getId());
			jsonObject.put("status", 1);
		} else {
			jsonObject.put("status", 0);
		}

		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/manager.shtml")
	public String manager(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/manager";
	}
}

package com.huzhiyi.housereadily.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.UserTrend;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;
import com.huzhiyi.utils.ResponseUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/toUserList.do")
	public String toUserList(Model model) {
		return "user/userList";
	}

	@RequestMapping("/userList.do")
	public void userList(@RequestParam("start") int start, @RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "regSource", required = false) Integer regSource,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "cityCode", required = false) Integer cityCode,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, 
			HttpServletResponse response, Model model) throws IOException {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List<CUser> userList = userService.findPaging(id, userName, regSource, cityCode, mobile, email, beginDate, endDate, sort, dir, pagingBean, true);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "regDate" });
		String[] field = { "id", "name", "cityName", "email", "mobile", "regDate", "regSource", "houseReadilyCount", "customerCount", "level", "growing", "integration" };

		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, userList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/export.do")
	public String export(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "regSource", required = false) Integer regSource,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "cityCode", required = false) Integer cityCode,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, 
			HttpServletResponse response, Model model) {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(1000000);
		pagingBean.setBeginRow(0);
		List<Object> mobileList = userService.export(id, userName, regSource, cityCode, mobile, email, beginDate, endDate, sort, dir);
		model.addAttribute("mobileList", mobileList);
		return "user/export";
	}
	
	@RequestMapping("/toUserImgList.do")
	public String toUserImgList(Model model) {
		return "user/userImgList";
	}
	
	@RequestMapping("/userImgList.do")
	public void userImgList(HttpServletResponse response, Model model) throws Exception {
		Date createTime = DateUtils.parse(DateUtils.format(new Date(), Constants.SHORT_DATEFORMAT) + " 00:00:00", Constants.DATEFORMAT);
		List<UserTrend> userTrendList = userService.findByUserTrend(createTime);
		
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		String[] field = { "createTime", "activeCount", "loginCount", "registerCount", "houseReadilyCount", "customerCount", "houseFollowCount" };
		
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(null, userTrendList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/userEdit.do")
	public String userEdit(@RequestParam("id") Integer id, Model model) {
		CUser cuser = userService.findById(id);
		List houseFollows = userService.findCreater(id); 
		cuser.setHouseFollows(houseFollows);
		List houseReadilys = userService.findReadilyCreater(id);
		cuser.setHouseReadilys(houseReadilys);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "regDate" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] {"houseFollows","houseReadilys" });
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] {
			{"id", "name", "mobile" },
			{"id", "projectName"}
		});
		JSONObject customers = ResponseUtils.getJSONByPagingBean(null, houseFollows, parseDataKey, "id", "name", "mobile");
		JSONObject jsonObject = ResponseUtils.getJSONByModel("cuser", cuser, parseDataKey, "id", "name", "cityName", "email", "mobile", "regDate", "regSource", "houseReadilyCount", "customerCount", "level", "growing", "integration","houseFollows","houseReadilys");
		model.addAttribute("jsonObject", jsonObject);

		return "user/userEdit";
	}
	
	@RequestMapping("/password.do")
	public String password(@RequestParam("id") Integer id, Model model) {
		return "user/password";
	}
	
	@RequestMapping("/changeSelfPassword.do")
	public void changeSelfPassword(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "secondPassword", required = false) String secondPassword,
			HttpServletResponse response, Model model) throws IOException {
		CUser user = userService.findById(id);
		userService.updatePassword(user.getName(), password);
		
		ExtJSONUtil.retJson(response, "");
	}
}

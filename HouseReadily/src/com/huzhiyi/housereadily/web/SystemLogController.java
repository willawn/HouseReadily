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

import com.huzhiyi.housereadily.biz.ISystemLogService;
import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;

@Controller
@RequestMapping("/systemLog")
public class SystemLogController {

	@Autowired
	private ISystemLogService systemLogService;

	@RequestMapping("/toSystemLogList.do")
	public String toSystemLogList(Model model) {
		return "systemLog/systemLogList";
	}

	@RequestMapping("/systemLogList.do")
	public void systemLogList(@RequestParam("start") int start, @RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "regSource", required = false) Integer regSource,
			@RequestParam(value = "terminal", required = false) String terminal,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "isRequestIpAddress", required = false) Boolean isRequestIpAddress,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, HttpServletResponse response, Model model) throws IOException {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List<SystemLog> systemLogList = systemLogService.findPaging(id, userName, regSource, terminal, type, beginDate, endDate, sort, dir, pagingBean, isRequestIpAddress);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		String[] field = { "id", "userId", "userName", "ip", "ipAddress", "regSource", "terminal", "type", "description", "createTime" };

		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, systemLogList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/export.do")
	public String export(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "regSource", required = false) Integer regSource,
			@RequestParam(value = "terminal", required = false) String terminal,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, HttpServletResponse response, Model model) {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(1000000);
		pagingBean.setBeginRow(0);
		List<SystemLog> systemLogList = systemLogService.findPaging(id, userName, regSource, terminal, type, beginDate, endDate, sort, dir, pagingBean, false);
		model.addAttribute("systemLogList", systemLogList);
		return "systemLog/export";
	}
}

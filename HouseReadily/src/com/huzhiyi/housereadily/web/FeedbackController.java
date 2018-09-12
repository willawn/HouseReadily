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

import com.huzhiyi.housereadily.biz.IFeedbackService;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping("/toFeedbackList.do")
	public String toFeedbackList(Model model) {
		return "feedback/feedbackList";
	}

	@RequestMapping("/feedbackList.do")
	public void feedbackList(@RequestParam("start") int start, @RequestParam("limit") int limit,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate, 
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, HttpServletResponse response, Model model) throws IOException {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List feedbackList = feedbackService.findPaging(beginDate, endDate, sort, dir, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, feedbackList, parseDataKey, "id", "userName", "email",
				"description", "creater", "createTime");

		ExtJSONUtil.retJson(response, jsonObject);
	}
}

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

import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.ITaskService;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.housereadily.entity.TaskTrend;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;
import com.huzhiyi.utils.ResponseUtils;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private ITaskLogService taskLogService;
	
	@RequestMapping("/toTaskLogList.do")
	public String toTaskLogList(Model model) {
		return "task/taskLogList";
	}

	@RequestMapping("/taskLogList.do")
	public void taskLogList(@RequestParam("start") int start, @RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "taskId", required = false) Integer taskId,
			@RequestParam(value = "shareType", required = false) Integer shareType,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, HttpServletResponse response, Model model) throws IOException {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List<TaskLog> taskLogList = taskLogService.findPaging(id, userName, type, taskId, shareType, beginDate, endDate, sort, dir, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		String[] field = { "id", "userId", "userName", "type", "taskId", "taskName", "shareType", "growing", "integration", "createTime" };

		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, taskLogList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/taskList.do")
	public void taskList(@RequestParam(value = "type", required = false) Integer type, HttpServletResponse response, Model model) {
		List<Task> taskList = null;
		if (null != type && type > 0) {
			taskList = taskService.findByType(type);
		} else {
			taskList = taskService.findAll();
		}
		
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "img" });
		String[] field = { "id", "title", "description", "explanation", "growing", "integration", "total", "img", "type", "isDisplay" };
		
		JSONObject jsonObject = ResponseUtils.getJSONByModel("taskList", taskList, parseDataKey, field);
		ResponseUtils.renderJson(response, jsonObject.toString());
	}
	
	@RequestMapping("/toTaskImgList.do")
	public String toTaskImgList(Model model) {
		return "task/taskImgList";
	}
	
	@RequestMapping("/taskImgList.do")
	public void taskImgList(HttpServletResponse response, Model model) throws Exception {
		Date createTime = DateUtils.parse(DateUtils.format(new Date(), Constants.SHORT_DATEFORMAT) + " 00:00:00", Constants.DATEFORMAT);
		List<TaskTrend> taskTrendList = taskService.findByTaskTrend(createTime);
		
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		String[] field = { "createTime", "loginTask", "houseReadilyTask", "customerTask", "shareSinaTask", "shareTencentTask", "shareWeiXinTask", "shareQzoneTask" };
		
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(null, taskTrendList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
	
	@RequestMapping("/toTaskUserList.do")
	public String toTaskUserList(Model model) {
		return "task/taskUserList";
	}
	
	@RequestMapping("/taskUserList.do")
	public void taskUserList(@RequestParam("start") int start, @RequestParam("limit") int limit,
			@RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, HttpServletResponse response, Model model) throws Exception {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List<TaskUserTrend> taskUserTrendList = taskService.findPagingByTaskUserTrend(userId, userName, beginDate, endDate, sort, dir, pagingBean);
		
		Map parseDataKey = new HashMap();
		//parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		String[] field = { "rownum", "userId", "userName", "sumGrowing" };
		
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, taskUserTrendList, parseDataKey, field);
		ExtJSONUtil.retJson(response, jsonObject);
	}
}

package com.huzhiyi.housereadily.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huzhiyi.housereadily.biz.ITaskService;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Constants;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ITaskService taskService;

	@RequestMapping("/growth.shtml")
	public String growth(@RequestParam(value = "start", required = false) Integer start,
			@RequestParam(value = "limit", required = false) Integer limit, Model model) throws Exception {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows((limit == null || limit < 0) ? 20 : limit);
		pagingBean.setBeginRow((start == null || start < 0) ? 0 : start);

//		Date createTime = new Date();
//		Date beginDate = DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -6);
//		Date endDate = createTime;
		Date beginDate = DateUtils.parse("2013-08-12 00:00:00", Constants.DATEFORMAT);
		Date endDate = DateUtils.parse("2013-08-18 00:00:00", Constants.DATEFORMAT);

		List<TaskUserTrend> taskUserTrendList = taskService.findPagingByTaskUserTrend(null, null, beginDate, endDate, null, null,
				pagingBean);
		model.addAttribute("taskUserTrendList", taskUserTrendList);
		return "activity/growth";
	}
	
	@RequestMapping("/growthmore.shtml")
	public String growthmore(Model model) {
		return "forward:growth.shtml?limit=100";
	}
	
	@RequestMapping("/gz.shtml")
	public String gz(Model model) {
		return "activity/gz";
	}

}

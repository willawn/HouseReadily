package com.huzhiyi.housereadily.biz.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.ITaskService;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.housereadily.entity.TaskTrend;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;

public class TaskServiceImpl extends AbstractTaskServiceImpl implements ITaskService {

	@Override
	public List<Task> findAll(Integer userId, Integer isDisplay) throws Exception {
		List<Task> taskList = getTaskDAO().findAll(isDisplay);
		List<TaskLog> taskLogList = null;
		for (Task task : taskList) {
			taskLogList = taskLogService.findAll(userId, task.getId());
			Integer growed = 0;
			for (TaskLog taskLog : taskLogList) {
				growed += taskLog.getGrowing();
			}
			
			task.setCount(taskLogList.size());
			task.setGrowed(growed);
			task.setIsComplete(task.getTotal().intValue() == task.getCount().intValue() ? 1 : 0);
			task.setExplanation(MessageFormat.format(task.getExplanation(), task.getTotal(), task.getCount()));
			String[] img = task.getImg().split(";");
			task.setImg(task.getIsComplete() == 1 ? img[1] : img[0]);
		}
		return taskList;
	}
	
	@Override
	public List<Task> findByType(Integer type) {
		return findByProperty("type", type).getList();
	}
	
	@Override
	public List<TaskTrend> findByTaskTrend(Date createTime) throws Exception {
		return getTaskDAO().findByTaskTrend(createTime);
	}
	
	@Override
	public List<TaskUserTrend> findPagingByTaskUserTrend(Integer userId, String userName, Date beginDate, Date endDate, String sort,
			String dir, PagingBean pagingBean) throws Exception {
		return getTaskDAO().findPagingByTaskUserTrend(userId, userName, beginDate, endDate, sort, dir, pagingBean);
	}
	
	private ITaskLogService taskLogService;

	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}
}
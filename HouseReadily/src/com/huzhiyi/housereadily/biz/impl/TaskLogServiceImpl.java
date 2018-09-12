package com.huzhiyi.housereadily.biz.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.dao.ITaskDAO;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.housereadily.entity.UserExt;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.MathUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.RequestUtils;

public class TaskLogServiceImpl extends AbstractTaskLogServiceImpl implements ITaskLogService {

	public QueryResult<TaskLog> findByProperty(String[] propertyNames, Object[] values, String order, String dir) {
		return getTaskLogDAO().findByProperty(propertyNames, values, order, dir);
	}

	@Override
	public List<TaskLog> findAll(Integer userId, Integer taskId, Date beginDate, Date endDate) {
		return getTaskLogDAO().findAll(userId, taskId, beginDate, endDate);
	}
	
	@Override
	public List<TaskLog> findAll(Integer userId, Integer taskId) throws Exception {
		Task task = taskDAO.findById(taskId);
		Date createTime = new Date();
		Date beginDate = null;
		Date endDate = null;
		if (task.getType() == 1) { // 一次性任务
			beginDate = null;
			endDate = null;
		} else if (task.getType() == 2) { // 每日任务
			String beginDateString = DateUtils.format(createTime, Constants.SHORT_DATEFORMAT);
			beginDate = DateUtils.parse(beginDateString, Constants.SHORT_DATEFORMAT);
			endDate = DateUtils.addDate(DateUtils.parse(beginDateString, Constants.SHORT_DATEFORMAT), Calendar.DAY_OF_MONTH, 1);
		}
		List<TaskLog> taskLogList = findAll(userId, taskId, beginDate, endDate);
		return taskLogList;
	}

	@Override
	public Integer add(Integer userId, Integer taskId, Integer shareType) throws Exception {
		CUser user = userDAO.findById(userId);
		Integer growing = 0;
		Integer integration = 0;
		Task task = taskDAO.findById(taskId);
		Date createTime = new Date();
		Date beginDate = null;
		Date endDate = null;
		if (task.getType() == 1) { // 一次性任务
			beginDate = null;
			endDate = null;
		} else if (task.getType() == 2) { // 每日任务
			String beginDateString = DateUtils.format(createTime, Constants.SHORT_DATEFORMAT);
			beginDate = DateUtils.parse(beginDateString, Constants.SHORT_DATEFORMAT);
			endDate = DateUtils.addDate(DateUtils.parse(beginDateString, Constants.SHORT_DATEFORMAT), Calendar.DAY_OF_MONTH, 1);
		}
		List<TaskLog> taskLogList = findAll(userId, taskId, beginDate, endDate);
		if (taskLogList.size() < task.getTotal()) { // 积分记录次数小于积分规则的次数
			if (Integer.parseInt(Configuration.TASK_LOGIN_ID.toString()) == task.getId()) { // 如果是登录，则积分取随机数
				Integer randomNumber = 0;
				
				// 07-31号屏蔽刷分用户，08-05号解封刷分用户
//				String userName = user.getName();
//				if ("524245434".equals(userName) || "test331".equals(userName)) {
//					randomNumber = 2;
//				} else if ("aaj777".equals(userName) || "jim2012".equals(userName) 
//						|| "zhoumingsyb".equals(userName) || "kmzyc1".equals(userName)) {
//					randomNumber = 15;
//				} else {
//					randomNumber = MathUtils.getRandomNumber(8, 15);
//				}
				
				// 正常随机产生经验值
				randomNumber = MathUtils.getRandomNumber(8, 15);
				growing = randomNumber;
				integration = randomNumber;
			} else {
				growing = task.getGrowing() / task.getTotal();
				integration = task.getIntegration() / task.getTotal();
			}
			
			// 新增积分日志
			TaskLog taskLog = new TaskLog();
			taskLog.setUserId(userId);
			taskLog.setTaskId(taskId);
			taskLog.setShareType(shareType);
			taskLog.setGrowing(growing);
			taskLog.setIntegration(integration);
			taskLog.setCreater(userId);
			taskLog.setCreateTime(new Timestamp(createTime.getTime()));
			super.add(taskLog);
			
			// 更新用户经验值和积分
			UserExt userExt = userExtService.findByUserId(userId);
			userExt.setGrowing(userExt.getGrowing() + growing);
			userExt.setIntegration(userExt.getIntegration() + integration);
		}
		return growing;
	}
	
	@Override
	public TaskLog findById(Integer id) {
		TaskLog taskLog = super.findById(id);
		initTaskLogForeignValue(taskLog);
		return taskLog;
	}
	
	private void initTaskLogForeignValue(TaskLog taskLog) {
		if (null != taskLog) {
			CUser user = userDAO.findById(taskLog.getUserId());
			taskLog.setUserName(user.getName());
			Task task = taskDAO.findById(taskLog.getTaskId());
			taskLog.setType(task.getType());
			taskLog.setTaskName(task.getTitle());
		}
	}
	
	@Override
	public List<TaskLog> findPaging(Integer id, String userName, Integer type, Integer taskId, Integer shareType, Date beginDate, Date endDate,
			String sort, String dir, PagingBean pagingBean) {
		List<TaskLog> taskLogs = getTaskLogDAO().findPaging(id, userName, type, taskId, shareType, beginDate, endDate, sort, dir, pagingBean);
		for (TaskLog taskLog : taskLogs) {
			initTaskLogForeignValue(taskLog);
		}
		return taskLogs;
	}

	private ITaskDAO taskDAO;
	private IUserExtService userExtService;
	private IUserDAO userDAO;

	public ITaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	public IUserExtService getUserExtService() {
		return userExtService;
	}

	public void setUserExtService(IUserExtService userExtService) {
		this.userExtService = userExtService;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
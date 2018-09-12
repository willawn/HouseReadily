﻿package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

@com.huzhiyi.annotation.RDEBiz
public interface ITaskLogService extends IAbstracttaskLogService {

	public QueryResult<TaskLog> findByProperty(String[] propertyNames, Object[] values, String order, String dir);

	public List<TaskLog> findAll(Integer userId, Integer taskId) throws Exception;

	public List<TaskLog> findAll(Integer userId, Integer taskId, Date beginDate, Date endDate);

	public Integer add(Integer userId, Integer taskId, Integer shareType) throws Exception;

	public List<TaskLog> findPaging(Integer id, String userName, Integer type, Integer taskId, Integer shareType, Date beginDate, Date endDate,
			String sort, String dir, PagingBean pagingBean);
}
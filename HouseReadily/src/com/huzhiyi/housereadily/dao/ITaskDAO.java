package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskTrend;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;

public interface ITaskDAO extends IAbstracttaskDAO {
	
	public List<Task> findAll(Integer isDisplay);
	
	public List<TaskTrend> findByTaskTrend(Date createTime) throws Exception;
	
	public List<TaskUserTrend> findPagingByTaskUserTrend(Integer userId, String userName, Date beginDate, Date endDate, String sort,
			String dir, PagingBean pagingBean) throws Exception;
}
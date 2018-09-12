package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskTrend;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface ITaskService extends IAbstracttaskService {

	public List<Task> findAll(Integer userId, Integer isDisplay) throws Exception;

	public List<Task> findByType(Integer type);

	public List<TaskTrend> findByTaskTrend(Date createTime) throws Exception;

	public List<TaskUserTrend> findPagingByTaskUserTrend(Integer userId, String userName, Date beginDate, Date endDate, String sort,
			String dir, PagingBean pagingBean) throws Exception;
}
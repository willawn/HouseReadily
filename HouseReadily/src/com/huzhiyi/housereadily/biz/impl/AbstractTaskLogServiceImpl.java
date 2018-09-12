package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstracttaskLogService;
import com.huzhiyi.housereadily.dao.ITaskLogDAO;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 TaskLog Biz Implement Class
 */
public abstract class AbstractTaskLogServiceImpl implements IAbstracttaskLogService {
	/**
	 *DAO对象注入
	 */
	private ITaskLogDAO taskLogDAO;

	public ITaskLogDAO getTaskLogDAO() {
		return this.taskLogDAO;
	}

	public void setTaskLogDAO(ITaskLogDAO taskLogDAO) {
		this.taskLogDAO = taskLogDAO;
	}

	/**
	 *查询所有
	 */
	public List<TaskLog> findAll() {
		return taskLogDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<TaskLog> findByExample(TaskLog example) {
		return taskLogDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<TaskLog> findByProperty(String propertyName, Object value) {
		return taskLogDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public TaskLog findById(Integer id) {
		return taskLogDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(TaskLog example) {
		taskLogDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(TaskLog example) {
		taskLogDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(TaskLog example) {
		taskLogDAO.delete(example);
	}
}
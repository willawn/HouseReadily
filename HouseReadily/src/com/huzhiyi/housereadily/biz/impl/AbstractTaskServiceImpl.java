package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstracttaskService;
import com.huzhiyi.housereadily.dao.ITaskDAO;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Task Biz Implement Class
 */
public abstract class AbstractTaskServiceImpl implements IAbstracttaskService {
	/**
	 *DAO对象注入
	 */
	private ITaskDAO taskDAO;

	public ITaskDAO getTaskDAO() {
		return this.taskDAO;
	}

	public void setTaskDAO(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	/**
	 *查询所有
	 */
	public List<Task> findAll() {
		return taskDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Task> findByExample(Task example) {
		return taskDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Task> findByProperty(String propertyName, Object value) {
		return taskDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Task findById(Integer id) {
		return taskDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Task example) {
		taskDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(Task example) {
		taskDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Task example) {
		taskDAO.delete(example);
	}
}
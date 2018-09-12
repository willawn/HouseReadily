package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracttaskLogDAO;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 TaskLog DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractTaskLogDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracttaskLogDAO {
	/**
	 *查询所有
	 */
	public List<TaskLog> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<TaskLog> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<TaskLog> findByExample(TaskLog example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<TaskLog> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public TaskLog findById(Integer id) {
		return (TaskLog) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(TaskLog example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(TaskLog example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(TaskLog example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return TaskLog.class;
	}
}
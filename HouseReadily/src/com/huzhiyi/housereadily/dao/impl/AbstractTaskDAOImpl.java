package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracttaskDAO;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Task DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractTaskDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracttaskDAO {
	/**
	 *查询所有
	 */
	public List<Task> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<Task> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Task> findByExample(Task example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Task> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Task findById(Integer id) {
		return (Task) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Task example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(Task example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Task example) {
		super.delete(example);
	}
	
	@Override
	protected Class getEntityClass() {
		return Task.class;
	}
}
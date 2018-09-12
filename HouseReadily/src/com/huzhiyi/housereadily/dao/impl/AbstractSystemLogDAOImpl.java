package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractsystemLogDAO;
import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 SystemLog DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSystemLogDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractsystemLogDAO {
	/**
	 *查询所有
	 */
	public List<SystemLog> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<SystemLog> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<SystemLog> findByExample(SystemLog example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<SystemLog> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public SystemLog findById(Integer id) {
		return (SystemLog) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(SystemLog example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(SystemLog example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(SystemLog example) {
		super.delete(example);
	}
	
	@Override
	protected Class getEntityClass() {
		return SystemLog.class;
	}
}
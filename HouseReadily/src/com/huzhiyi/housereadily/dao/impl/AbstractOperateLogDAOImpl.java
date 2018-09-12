package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractoperateLogDAO;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 OperateLog DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractOperateLogDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractoperateLogDAO {
	/**
	 *查询所有
	 */
	public List<OperateLog> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<OperateLog> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<OperateLog> findByExample(OperateLog example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<OperateLog> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public OperateLog findById(Integer id) {
		return (OperateLog) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(OperateLog example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(OperateLog example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(OperateLog example) {
		super.delete(example);
	}
	
	@Override
	protected Class getEntityClass() {
		return OperateLog.class;
	}
}
package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractprojectDAO;
import com.huzhiyi.housereadily.model.CProject;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 CProject DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractProjectDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractprojectDAO {
	/**
	 *查询所有
	 */
	public List<CProject> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<CProject> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<CProject> findByExample(CProject example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<CProject> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public CProject findById(Integer id) {
		return (CProject) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(CProject example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(CProject example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(CProject example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return CProject.class;
	}
}
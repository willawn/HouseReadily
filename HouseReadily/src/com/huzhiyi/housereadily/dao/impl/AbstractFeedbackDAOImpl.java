package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractfeedbackDAO;
import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Feedback DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractFeedbackDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractfeedbackDAO {
	/**
	 *查询所有
	 */
	public List<Feedback> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<Feedback> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Feedback> findByExample(Feedback example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Feedback> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Feedback findById(Integer id) {
		return (Feedback) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Feedback example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(Feedback example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Feedback example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return Feedback.class;
	}
}
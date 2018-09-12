package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractbaseGroupDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 BaseGroup DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractBaseGroupDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractbaseGroupDAO {
	/**
	 *查询所有
	 */
	public List<BaseGroup> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<BaseGroup> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<BaseGroup> findByExample(BaseGroup example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<BaseGroup> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public BaseGroup findById(Integer id) {
		return (BaseGroup) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(BaseGroup example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(BaseGroup example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(BaseGroup example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return BaseGroup.class;
	}
}
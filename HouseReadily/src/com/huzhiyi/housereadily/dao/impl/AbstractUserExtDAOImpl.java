package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractuserExtDAO;
import com.huzhiyi.housereadily.entity.UserExt;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 UserExt DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractUserExtDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractuserExtDAO {
	/**
	 *查询所有
	 */
	public List<UserExt> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<UserExt> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<UserExt> findByExample(UserExt example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<UserExt> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public UserExt findById(Integer id) {
		return (UserExt) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(UserExt example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(UserExt example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(UserExt example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return UserExt.class;
	}
}
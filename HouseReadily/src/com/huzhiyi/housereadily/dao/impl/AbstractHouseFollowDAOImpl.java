package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracthouseFollowDAO;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseFollow DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHouseFollowDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracthouseFollowDAO {
	/**
	 *查询所有
	 */
	public List<HouseFollow> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<HouseFollow> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseFollow> findByExample(HouseFollow example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseFollow findById(Integer id) {
		return (HouseFollow) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseFollow example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseFollow example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseFollow example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return HouseFollow.class;
	}
}
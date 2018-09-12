package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracthouseReadilyDAO;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseReadily DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHouseReadilyDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracthouseReadilyDAO {
	/**
	 *查询所有
	 */
	public List<HouseReadily> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<HouseReadily> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseReadily> findByExample(HouseReadily example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseReadily> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseReadily findById(Integer id) {
		return (HouseReadily) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseReadily example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseReadily example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseReadily example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return HouseReadily.class;
	}
}
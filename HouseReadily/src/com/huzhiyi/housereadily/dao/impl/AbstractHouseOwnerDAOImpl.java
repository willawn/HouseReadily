package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracthouseOwnerDAO;
import com.huzhiyi.housereadily.entity.HouseOwner;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseOwner DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHouseOwnerDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracthouseOwnerDAO {
	/**
	 *查询所有
	 */
	public List<HouseOwner> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<HouseOwner> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseOwner> findByExample(HouseOwner example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseOwner> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseOwner findById(Integer id) {
		return (HouseOwner) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseOwner example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseOwner example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseOwner example) {
		super.delete(example);
	}

	/**
	 *根据customerI;查询this,排序:createTime asc
	 */
	public QueryResult<HouseOwner> findHouseOwnerByCustomerId(Integer customerId) {
		String hql = "select o from com.huzhiyi.housereadily.entity.HouseOwner o where o.customerId=? order by o.createTime asc";
		return super.findByHQL(hql, new Object[] { customerId });
	}

	/**
	 *根据houseReadilyI;查询this,排序:createTime asc
	 */
	public QueryResult<HouseOwner> findHouseOwnerByHouseReadilyId(Integer houseReadilyId) {
		String hql = "select o from com.huzhiyi.housereadily.entity.HouseOwner o where o.houseReadilyId=? order by o.createTime asc";
		return super.findByHQL(hql, new Object[] { houseReadilyId });
	}

	@Override
	protected Class getEntityClass() {
		return HouseOwner.class;
	}
}
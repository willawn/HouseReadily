package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstracthouseAttachmentDAO;
import com.huzhiyi.housereadily.entity.HouseAttachment;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseAttachment DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHouseAttachmentDAOImpl extends HibernateBaseDAO<Integer> implements IAbstracthouseAttachmentDAO {
	/**
	 *查询所有
	 */
	public List<HouseAttachment> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<HouseAttachment> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseAttachment> findByExample(HouseAttachment example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseAttachment> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseAttachment findById(Integer id) {
		return (HouseAttachment) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseAttachment example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseAttachment example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseAttachment example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return HouseAttachment.class;
	}
}
package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractmessageGroupDAO;
import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MessageGroup DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMessageGroupDaoImpl extends HibernateBaseDAO<Integer> implements IAbstractmessageGroupDAO {
	/**
	 *查询所有
	 */
	public List<MessageGroup> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<MessageGroup> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MessageGroup> findByExample(MessageGroup example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MessageGroup> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MessageGroup findById(Integer id) {
		return (MessageGroup) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MessageGroup example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(MessageGroup example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MessageGroup example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return MessageGroup.class;
	}
}

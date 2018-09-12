package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractmessageGroupService;
import com.huzhiyi.housereadily.dao.IMessageGroupDAO;
import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MessageGroup Biz Implement Class
 */
public abstract class AbstractMessageGroupServiceImpl implements IAbstractmessageGroupService {
	/**
	 *DAO对象注入
	 */
	private IMessageGroupDAO messageGroupDAO;

	public IMessageGroupDAO getMessageGroupDAO() {
		return this.messageGroupDAO;
	}

	public void setMessageGroupDAO(IMessageGroupDAO messageGroupDAO) {
		this.messageGroupDAO = messageGroupDAO;
	}
	
	/**
	 *查询所有
	 */
	public List<MessageGroup> findAll() {
		return messageGroupDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MessageGroup> findByExample(MessageGroup example) {
		return messageGroupDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MessageGroup> findByProperty(String propertyName, Object value) {
		return messageGroupDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MessageGroup findById(Integer id) {
		return messageGroupDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MessageGroup example) {
		messageGroupDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(MessageGroup example) {
		messageGroupDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MessageGroup example) {
		messageGroupDAO.delete(example);
	}
}

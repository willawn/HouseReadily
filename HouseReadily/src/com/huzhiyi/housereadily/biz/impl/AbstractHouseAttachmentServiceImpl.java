package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstracthouseAttachmentService;
import com.huzhiyi.housereadily.dao.IHouseAttachmentDAO;
import com.huzhiyi.housereadily.entity.HouseAttachment;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseAttachment Biz Implement Class
 */
public abstract class AbstractHouseAttachmentServiceImpl implements IAbstracthouseAttachmentService {
	/**
	 *DAO对象注入
	 */
	private IHouseAttachmentDAO houseAttachmentDAO;

	public IHouseAttachmentDAO getHouseAttachmentDAO() {
		return this.houseAttachmentDAO;
	}

	public void setHouseAttachmentDAO(IHouseAttachmentDAO houseAttachmentDAO) {
		this.houseAttachmentDAO = houseAttachmentDAO;
	}

	/**
	 *查询所有
	 */
	public List<HouseAttachment> findAll() {
		return houseAttachmentDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseAttachment> findByExample(HouseAttachment example) {
		return houseAttachmentDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseAttachment> findByProperty(String propertyName, Object value) {
		return houseAttachmentDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseAttachment findById(Integer id) {
		return houseAttachmentDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseAttachment example) {
		houseAttachmentDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseAttachment example) {
		houseAttachmentDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseAttachment example) {
		houseAttachmentDAO.delete(example);
	}
}
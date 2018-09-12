package com.huzhiyi.housereadily.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractauditMemberGroupService;
import com.huzhiyi.housereadily.dao.IAuditMemberGroupDAO;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 AuditMemberGroup Biz Implement Class
 */
public abstract class AbstractAuditMemberGroupServiceImpl implements IAbstractauditMemberGroupService {
	/**
	 *DAO对象注入
	 */
	private IAuditMemberGroupDAO auditMemberGroupDAO;

	public IAuditMemberGroupDAO getAuditMemberGroupDAO() {
		return this.auditMemberGroupDAO;
	}

	public void setAuditMemberGroupDAO(IAuditMemberGroupDAO auditMemberGroupDAO) {
		this.auditMemberGroupDAO = auditMemberGroupDAO;
	}

	/**
	 *查询所有
	 */
	public List<AuditMemberGroup> findAll() {
		return auditMemberGroupDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<AuditMemberGroup> findByExample(AuditMemberGroup example) {
		return auditMemberGroupDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<AuditMemberGroup> findByProperty(String propertyName, Object value) {
		return auditMemberGroupDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public AuditMemberGroup findById(Integer id) {
		return auditMemberGroupDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(AuditMemberGroup example) {
		auditMemberGroupDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(AuditMemberGroup example) {
		auditMemberGroupDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(AuditMemberGroup example) {
		auditMemberGroupDAO.delete(example);
	}
}
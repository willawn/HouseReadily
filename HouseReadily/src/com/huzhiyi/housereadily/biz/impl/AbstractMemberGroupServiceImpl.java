package com.huzhiyi.housereadily.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractmemberGroupService;
import com.huzhiyi.housereadily.dao.IMemberGroupDAO;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroup Biz Implement Class
 */
public abstract class AbstractMemberGroupServiceImpl implements IAbstractmemberGroupService {
	/**
	 *DAO对象注入
	 */
	private IMemberGroupDAO memberGroupDAO;

	public IMemberGroupDAO getMemberGroupDAO() {
		return this.memberGroupDAO;
	}

	public void setMemberGroupDAO(IMemberGroupDAO memberGroupDAO) {
		this.memberGroupDAO = memberGroupDAO;
	}

	/**
	 *查询所有
	 */
	public List<MemberGroup> findAll() {
		return memberGroupDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MemberGroup> findByExample(MemberGroup example) {
		return memberGroupDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MemberGroup> findByProperty(String propertyName, Object value) {
		return memberGroupDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MemberGroup findById(Integer id) {
		return memberGroupDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MemberGroup example) {
		memberGroupDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(MemberGroup example) {
		memberGroupDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MemberGroup example) {
		memberGroupDAO.delete(example);
	}
}
package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.housereadily.dao.ICodeDAO;
import com.huzhiyi.housereadily.entity.Code;

public class CodeDAOImpl extends AbstractCodeDAOImpl implements ICodeDAO {

	public List<Code> findCodeByUserNameAndMobile(String userName, String mobile) {
		String hql = "select o from com.huzhiyi.housereadily.entity.Code o where o.userName = ? and o.mobile = ? order by o.createTime desc";
		return findByHQL(hql, userName, mobile).getList();
	}
	
	@Override
	public List<Code> findCodeByCodeAndMobile(String code, String mobile) {
		String hql = "select o from com.huzhiyi.housereadily.entity.Code o where o.code = ? and o.mobile = ? order by o.createTime desc";
		return findByHQL(hql, code, mobile).getList();
	}
}
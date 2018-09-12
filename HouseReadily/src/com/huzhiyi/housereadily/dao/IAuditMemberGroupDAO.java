package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.PagingBean;

public interface IAuditMemberGroupDAO extends IAbstractauditMemberGroupDAO {

	public List<AuditMemberGroup> findPaging(Integer baseGroupId, Integer userId, Integer isRead, String sort, String dir, PagingBean pagingBean)
			throws Exception;
}
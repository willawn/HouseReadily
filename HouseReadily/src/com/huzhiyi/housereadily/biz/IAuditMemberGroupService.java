package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IAuditMemberGroupService extends IAbstractauditMemberGroupService {
	
	public AuditMemberGroup add(ICommand command) throws Exception;

	public String updateAudit(ICommand command);
	
	public List<AuditMemberGroup> findPaging(Integer baseGroupId, Integer userId, Integer isRead, String sort, String dir, PagingBean pagingBean) throws Exception;
}
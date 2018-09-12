package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IMemberGroupService extends IAbstractmemberGroupService {

	public List<MemberGroup> findByBaseGroupId(Integer baseGroupId);
	
	public List<MemberGroup> findPaging(Integer baseGroupId, String sort, String dir, PagingBean pagingBean);
	
	public boolean exitsMemberGroup(Integer baseGroupId, Integer userId);
	
	public void delete(ICommand command);
	
	public void deleteQuitGroup(ICommand command);
}
package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IBaseGroupService extends IAbstractbaseGroupService {
	
	public BaseGroup add(ICommand command) throws Exception;
	
	public BaseGroup findByIdNull(Integer id);
	
	public List<BaseGroup> findPaging(Integer userId, String sort, String dir, PagingBean pagingBean) throws Exception;
	
	public Integer findCountByUserId(Integer userId);
	
	public BaseGroup findByGroupNum(String groupNum);
	
	public BaseGroup updateAcement(ICommand command);
	
	public void delete(ICommand command);
	
	public List<BaseGroup> findPaging(Integer id, Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir, PagingBean pagingBean );
}
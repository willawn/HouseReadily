package com.huzhiyi.housereadily.biz;

import com.huzhiyi.housereadily.entity.UserExt;

@com.huzhiyi.annotation.RDEBiz
public interface IUserExtService extends IAbstractuserExtService {
	
	public UserExt findByUserId(Integer userId);
	
	public void add(Integer userId, Integer isUpdate);

	public boolean userExtExist(Integer userId);
	
	public void updateHouseReadilyCount(Integer userId);
	
	public void updateCustomerCount(Integer userId);
	
	public void updateIsUpdate(Integer userId, Integer isUpdate);
}
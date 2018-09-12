package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseOwner;

@com.huzhiyi.annotation.RDEBiz
public interface IHouseOwnerService extends IAbstracthouseOwnerService {
	
	List<HouseOwner> findHouseOwnerByCustomerId(Integer customerId);

	List<HouseOwner> findHouseOwnerByHouseReadilyId(Integer houseReadilyId);
	
	boolean exists(Integer houseReadilyId, Integer customerId);
	
	void delete(String ids);
}

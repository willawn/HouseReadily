package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IHouseOwnerService;
import com.huzhiyi.housereadily.entity.HouseOwner;

public class HouseOwnerServiceImpl extends AbstractHouseOwnerServiceImpl implements IHouseOwnerService {

	@Override
	public List<HouseOwner> findHouseOwnerByCustomerId(Integer customerId) {
		return getHouseOwnerDAO().findHouseOwnerByCustomerId(customerId).getList();
	}

	@Override
	public List<HouseOwner> findHouseOwnerByHouseReadilyId(Integer houseReadilyId) {
		return getHouseOwnerDAO().findHouseOwnerByHouseReadilyId(houseReadilyId).getList();
	}
	
	@Override
	public boolean exists(Integer houseReadilyId, Integer customerId) {
		return getHouseOwnerDAO().countHouseOwner(houseReadilyId, customerId) > 0;
	}
	
	@Override
	public void delete(String ids) {
		String[] idArray = ids.split(",");
		for (int i = 0; i < idArray.length; i++) {
			delete(findById(Integer.parseInt(idArray[i])));
		}
	}
}
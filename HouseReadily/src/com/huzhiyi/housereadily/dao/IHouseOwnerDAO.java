package com.huzhiyi.housereadily.dao;

public interface IHouseOwnerDAO extends IAbstracthouseOwnerDAO {
	
	Integer countHouseOwner(Integer houseReadilyId, Integer customerId);
}
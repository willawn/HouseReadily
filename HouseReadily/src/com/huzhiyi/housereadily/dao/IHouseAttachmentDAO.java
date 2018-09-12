package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseAttachment;

public interface IHouseAttachmentDAO extends IAbstracthouseAttachmentDAO {

	public List<HouseAttachment> findAttachment(Integer houseReadilyId, String type);
}
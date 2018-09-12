package com.huzhiyi.housereadily.dao.impl;
import java.util.List;

import com.huzhiyi.housereadily.dao.IHouseAttachmentDAO;
import com.huzhiyi.housereadily.entity.HouseAttachment;
public class HouseAttachmentDAOImpl extends AbstractHouseAttachmentDAOImpl implements IHouseAttachmentDAO{
	
	@Override
	public List<HouseAttachment> findAttachment(Integer houseReadilyId, String type) {
		String hql = "select o from com.huzhiyi.housereadily.entity.HouseAttachment o where o.houseReadilyId = ? and o.type = ?";
		return super.findByHQL(hql, houseReadilyId, type).getList();
	}
}
package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseAttachment;

@com.huzhiyi.annotation.RDEBiz
public interface IHouseAttachmentService extends IAbstracthouseAttachmentService {

	public void add(Integer houseReadilyId, String type, String attachment);

	public void add(Integer houseReadilyId, String type, String name, String path, String spath, String mpath, Integer size);
	
	public List<HouseAttachment> findAttachment(Integer houseReadilyId, String type);
	
	void delete(String ids);
}
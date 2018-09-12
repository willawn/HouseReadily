package com.huzhiyi.housereadily.biz.impl;

import java.sql.Timestamp;
import java.util.List;

import com.huzhiyi.housereadily.biz.IHouseAttachmentService;
import com.huzhiyi.housereadily.entity.HouseAttachment;

public class HouseAttachmentServiceImpl extends AbstractHouseAttachmentServiceImpl implements IHouseAttachmentService {

	@Override
	public void add(Integer houseReadilyId, String type, String attachment) {
		String[] attachArray = attachment.split(";");
		for (int i = 0; i < attachArray.length; i++) {
			String[] attachArray$ = attachArray[i].split(",");
			add(houseReadilyId, type, attachArray$[0], attachArray$[1], attachArray$[2], attachArray$[3], Integer.parseInt(attachArray$[4]));
		}
	}

	@Override
	public void add(Integer houseReadilyId, String type, String name, String path, String spath, String mpath, Integer size) {
		long now = System.currentTimeMillis();
		Timestamp createTime = new Timestamp(now);
		
		HouseAttachment houseAttachment = new HouseAttachment();
		houseAttachment.setHouseReadilyId(houseReadilyId);
		houseAttachment.setType(type);
		houseAttachment.setName(name);
		houseAttachment.setPath(path);
		houseAttachment.setSpath(spath);
		houseAttachment.setMpath(mpath);
		houseAttachment.setSize(size);
		houseAttachment.setIsPicture(isPicture(name));
		houseAttachment.setCreateTime(createTime);

		super.add(houseAttachment);
	}
	
	private Integer isPicture(String name) {
		final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "png", "bmp" };
		for (int allowFlag = 0, allowedExtCount = allowedExt.length; allowFlag < allowedExtCount; allowFlag++) {
			if (name.indexOf(allowedExt[allowFlag]) > -1)
				return 1;
		}
		return 0;
	}
	
	@Override
	public List<HouseAttachment> findAttachment(Integer houseReadilyId, String type) {
		return getHouseAttachmentDAO().findAttachment(houseReadilyId, type);
	}
	
	@Override
	public void delete(String ids) {
		String[] idArray = ids.split(",");
		for (int i = 0; i < idArray.length; i++) {
			delete(findById(Integer.parseInt(idArray[i])));
		}
	}
}
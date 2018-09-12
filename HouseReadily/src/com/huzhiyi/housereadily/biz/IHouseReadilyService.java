package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IHouseReadilyService extends IAbstracthouseReadilyService {

	public HouseReadily add(ICommand command) throws Exception;

	public List<HouseReadily> findByIds(String ids);

	public List<HouseReadily> findPaging(ICommand command, PagingBean pagingBean);

	public List<HouseReadily> findPaging(Integer id, Integer stype, Integer buildType, String projectName, String title, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir,
			PagingBean pagingBean);

	public List<HouseReadily> findIdAndVersion(Integer userId);

	public HouseReadily update(ICommand command) throws Exception;
	
	public HouseReadily updateStatus(ICommand command);
	
	public void updateIosBug(Integer userId);

	void delete(ICommand command);
}
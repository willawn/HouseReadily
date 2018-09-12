package com.huzhiyi.housereadily.biz;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface ICustomerService extends IAbstractcustomerService {

	public Customer add(ICommand command) throws Exception;

	public List<Customer> findByIds(String ids);

	public List<Customer> findPaging(ICommand command, PagingBean pagingBean);

	public List<Customer> findPaging(Integer id, Integer ctype, Integer buildType, String name, Integer gender, String mobile, Integer beginRoomNum, Integer endRoomNum,
			BigDecimal beginArea, BigDecimal endArea, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir,
			PagingBean pagingBean);

	public List<Customer> findIdAndVersion(Integer userId);

	public Customer update(ICommand command) throws Exception;
	
	public Customer updateStatus(ICommand command);

	public void delete(ICommand command);

	public Customer existsCustomer(Integer userId, Integer ctype, String name, String mobile);
}
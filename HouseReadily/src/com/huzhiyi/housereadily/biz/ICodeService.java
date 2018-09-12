package com.huzhiyi.housereadily.biz;

import com.huzhiyi.housereadily.entity.Code;

@com.huzhiyi.annotation.RDEBiz
public interface ICodeService extends IAbstractcodeService {
	
	public String getCode(String mobile);

	public String getCode(String mobile, Integer length);
	
	public Code findCodeByUserNameAndMobile(String userName, String mobile);
	
	public Code findCodeByCodeAndMobile(String code, String mobile);
}
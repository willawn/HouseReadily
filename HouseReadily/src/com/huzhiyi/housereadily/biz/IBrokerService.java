package com.huzhiyi.housereadily.biz;

@com.huzhiyi.annotation.RDEBiz
public interface IBrokerService extends IAbstractbrokerService {
	
	public boolean executeSouFun();
	
	public boolean existsBrokerByNameAndMobile(String name, String moblie);
}
package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEQueryMethod;
import com.huzhiyi.housereadily.entity.Code;

public interface ICodeDAO extends IAbstractcodeDAO {

	@RDEQueryMethod(queryName = "com.huzhiyi.housereadily.entity.Code:this", findType = "find", paramters = "java.lang.String:userName,java.lang.String:mobile", order = "createTime desc")
	List<Code> findCodeByUserNameAndMobile(String userName, String mobile);

	@RDEQueryMethod(queryName = "com.huzhiyi.housereadily.entity.Code:this", findType = "find", paramters = "java.lang.String:code,java.lang.String:mobile", order = "createTime desc")
	List<Code> findCodeByCodeAndMobile(String code, String mobile);
}
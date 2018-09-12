package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.ICodeService;
import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.utils.CodeMobileUtils;

public class CodeServiceImpl extends AbstractCodeServiceImpl implements ICodeService {

	@Override
	public String getCode(String mobile) {
		return getCode(mobile, 6);
	}

	@Override
	public String getCode(String mobile, Integer length) {
		String code = CodeMobileUtils.getCode(length);
		List<Code> codeList = getCodeDAO().findCodeByCodeAndMobile(code, mobile);
		if (!codeList.isEmpty()) {
			code = getCode(mobile, length);
		}
		return code;
	}

	@Override
	public Code findCodeByUserNameAndMobile(String userName, String mobile) {
		List<Code> codeList = getCodeDAO().findCodeByUserNameAndMobile(userName, mobile);
		if (!codeList.isEmpty()) {
			return codeList.get(0);
		}
		return null;
	}

	@Override
	public Code findCodeByCodeAndMobile(String code, String mobile) {
		List<Code> codeList = getCodeDAO().findCodeByCodeAndMobile(code, mobile);
		if (!codeList.isEmpty()) {
			return codeList.get(0);
		}
		return null;
	}
}
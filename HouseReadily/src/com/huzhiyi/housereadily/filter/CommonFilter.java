package com.huzhiyi.housereadily.filter;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.routing.Filter;

import com.huzhiyi.utils.AuthHelper;

public class CommonFilter extends Filter {
	private static String[][] unprotectedResources = { 
		{ "usercheck", },
		{ "feedback", },
		{ "project", }
	};

	@Override
	protected int beforeHandle(Request request, Response response) {
		String path = request.getResourceRef().getIdentifier();//.getPath();
		if (isUnProtectedResource(path)) {
			return CONTINUE;
		}
		try {
			String auth = request.getResourceRef().getQueryAsForm().getFirstValue("auth", "");
			Integer userId = Integer.valueOf(request.getResourceRef().getQueryAsForm().getFirstValue("userId", "0"));

			if (AuthHelper.checkMd5(auth, userId)) {
				return CONTINUE;
			} else {
				return STOP;
			}
		} catch (Exception ex) {
			return STOP;
		}
	}

	private boolean isUnProtectedResource(String path) {
		boolean result = false;
		for (int i = 0; i < unprotectedResources.length; i++) {
			result = false;
			for (int j = 0; j < unprotectedResources[i].length; j++) {
				result = path.indexOf(unprotectedResources[i][j]) != -1;
			}
			if (result) {
				return true;
			}
		}
		return false;
	}
}

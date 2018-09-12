/**   
 * @Title: ApsBindingInitializer.java
 * @Package com.zushou365.manage.comm.web
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-9-5
 */
package com.huzhiyi.housereadily.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @ClassName: ApsBindingInitializer
 * @Description: 描述类
 *               <p>
 * @author willter
 * @date 2012-9-5
 */
public class ApsBindingInitializer implements WebBindingInitializer {

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: initBinder
	 * @Description: TODO(覆盖父类方法)
	 *               <p>
	 * @author willter
	 * @date 2012-9-5
	 *       <p>
	 * @param binder
	 * @param request
	 * @see org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.springframework.web.bind.WebDataBinder,
	 *      org.springframework.web.context.request.WebRequest)
	 */
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}

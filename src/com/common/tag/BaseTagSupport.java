package com.common.tag;

import javax.servlet.jsp.tagext.TagSupport;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.hibernate.dao.idao.IBaseSpringDAO;

@SuppressWarnings("serial")
public class BaseTagSupport extends TagSupport {

	public static IBaseSpringDAO baseSpringDAO;
	public static WebApplicationContext context = null;
	
    public BaseTagSupport (){	
    	context = WebApplicationContextUtils.getWebApplicationContext(pageContext.getSession().getServletContext());
    	baseSpringDAO = (IBaseSpringDAO)context.getBean("baseSpringDAO");
	}
}

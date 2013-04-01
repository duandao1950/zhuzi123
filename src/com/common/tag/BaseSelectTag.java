package com.common.tag;

import java.util.LinkedHashMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.hibernate.dao.idao.IBaseSpringDAO;

@SuppressWarnings("serial")
public class BaseSelectTag extends TagSupport {
	private String bgcolor;
	private String height;
	private String target;
	private String name;
	private String tableName;
	private String property;
	private String defaultValue;
	private String disabled;
	
	public BaseSelectTag() {
		bgcolor = "#FFFFFF";
		height = "25";
		target = "_self";
		name = null;
		defaultValue = "";
		disabled = "false";
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeight() {
		return height;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int doStartTag() throws JspException {
		JspWriter outcontent = pageContext.getOut();
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(
				pageContext.getSession().getServletContext());
		IBaseSpringDAO baseSpringDAO = (IBaseSpringDAO)context.getBean("baseSpringDAO");
		
		LinkedHashMap<String,String> map = null;
		try {
			map = baseSpringDAO.getDicContenByDicName(tableName);
			StringBuffer str = new StringBuffer();
			str.append("<select name='").append(property).append("'");
			if ("true".equalsIgnoreCase(disabled)){
				str.append(" disabled");
			}
			str.append(">\r");
			str.append("<option>").append("").append("</option>\r");
			for (String strKey : map.keySet()){
				if (strKey.equalsIgnoreCase(defaultValue.trim())){
					str.append("&nbsp;");
					str.append("<option value='").append(strKey).append("' selected='true'>");
					str.append(map.get(strKey));
					str.append("</option>\r");
				}else{
					str.append("&nbsp;");
					str.append("<option value='").append(strKey).append("'>");
					str.append(map.get(strKey));
					str.append("</option>\r");
				}
			}
			str.append("</select>\r");
			outcontent.write(str.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return SKIP_BODY;
	}

	/*public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(CommonContexts.DAOLOADSPRINGFILE);
		IBaseSpringDAO baseSpringDAO = (IBaseSpringDAO)ctx.getBean("baseSpringDAO");
		
		LinkedHashMap<String,String> map = null;
		try {
			map = baseSpringDAO.getDicContenByDicName("DIC_IS_VALID");
			StringBuffer str = new StringBuffer();
			str.append("<select name='").append("GJ").append("'>\r");
			str.append("<option>").append("").append("</option>\r");
			for (String strKey : map.keySet()){
				str.append("&nbsp;");
				str.append("<option value='").append(strKey).append("'>");
				str.append(map.get(strKey));
				str.append("</option>\r");
			}
			str.append("</select>\r");
			System.out.println(str.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}*/

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
}

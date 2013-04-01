package com.common.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.hibernate.dao.ConfigDAO;
import com.hibernate.beans.Config;

public class TextTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String inf_name;
	
	private String language;
	
    private String id;
    private boolean flag = true;
    
   /* @SuppressWarnings("unchecked")
	private HashMap<String, HashMap> tableMap = new HashMap<String, HashMap>();
    
    private HashMap<String, String> remarkMap = new HashMap<String, String>();
    
    */
    
    
    /*private ConfigBo configBo;*/


	public String getInf_name() {
		return inf_name;
	}


	public void setInf_name(String inf_name) {
		this.inf_name = inf_name;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}

	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException 
	{
 		JspWriter outcontent = pageContext.getOut();
 		ArrayList configList = (ArrayList) pageContext.getSession().getAttribute("config");
		String result = "";
		
		if (configList != null && configList.size()>0){
			for(int i = 0; i < configList.size(); i++)
			{
				Config config = (Config)configList.get(i);
				if(this.getInf_name()!= null && this.getInf_name().equals(config.getInfName())
						&& this.getId() != null && this.getId().equals(config.getId()))
				{
					result = config.getRemark();
				}
			}
		}
		try 
		{
			outcontent.write(result);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	/*public ConfigBo getConfigBo() {
		return configBo;
	}


	public void setConfigBo(ConfigBo configBo) {
		this.configBo = configBo;
	}*/

}

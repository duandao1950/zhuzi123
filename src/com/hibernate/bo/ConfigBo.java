package com.hibernate.bo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Config;
import com.hibernate.bo.ibo.IConfigBo;
import com.hibernate.dao.ConfigDAO;

public class ConfigBo extends BaseHibernateBo implements IConfigBo
{
    private ConfigDAO configDAO;

	public ConfigDAO getConfigDAO() 
	{
	    return configDAO;
    }

	public void setConfigDAO(ConfigDAO configDAO) 
	{
		this.configDAO = configDAO;
	}

	public List<T> findAllByCondition(Class<Config> class1, Config config)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<T> findAllByCondition(Class<Config> class1,
			Config config) throws Exception 
	{
		return configDAO.findAllByCondition(class1, config);
	}*/


}

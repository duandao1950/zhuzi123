package com.hibernate.bo;

import com.hibernate.bo.ibo.IRealProjectBo;
import com.hibernate.dao.RealProjectDAO;

public class RealProjectBo extends BaseHibernateBo implements IRealProjectBo
{
	private RealProjectDAO realProjectDAO;

	public RealProjectDAO getRealProjectDAO() 
	{
		return realProjectDAO;
	}

	public void setRealProjectDAO(RealProjectDAO realProjectDAO) 
	{
		this.realProjectDAO = realProjectDAO;
	}

}

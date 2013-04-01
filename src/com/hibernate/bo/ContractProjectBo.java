package com.hibernate.bo;

import com.hibernate.bo.ibo.IContractProjectBo;
import com.hibernate.dao.ContractProjectDAO;

public class ContractProjectBo extends BaseHibernateBo implements IContractProjectBo
{
	private ContractProjectDAO contractProjectDAO;

	public ContractProjectDAO getContractProjectDAO() 
	{
		return contractProjectDAO;
	}

	public void setContractProjectDAO(ContractProjectDAO contractProjectDAO) 
	{
		this.contractProjectDAO = contractProjectDAO;
	}
	

}

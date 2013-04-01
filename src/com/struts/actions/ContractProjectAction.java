package com.struts.actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.struts.util.Constants;

import com.common.util.DateUtil;
import com.hibernate.beans.ContractProject;
import com.hibernate.bo.ContractProjectBo;

public class ContractProjectAction extends BaseAction
{
	protected Integer id = null;
	
	protected String contractNo = null;
	
	protected String projectNo = null;
	
	protected String projectName = null;
	
	protected String assignDate = null;
	
	protected String openDate = null;
	
	protected String planStartDate = null;
	
	protected String planEndDate = null;
	
	protected String realStartDate = null;
	
	protected String realEndDate = null;
	
	protected String ourIntfPerson = null;
	
	protected String otherIntfPerson = null;
	
	protected Integer contractCountPerson = null;
	
	protected ContractProject contractProject_obj = null;
	
	protected ContractProjectBo contractProjectBo = null;
	
	public ContractProjectBo getContractProjectBo() 
	{
		return contractProjectBo;
	}

	public void setContractProjectBo(ContractProjectBo contractProjectBo) 
	{
		this.contractProjectBo = contractProjectBo;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getContractNo() 
	{
		return contractNo;
	}

	public void setContractNo(String contractNo) 
	{
		this.contractNo = contractNo;
	}

	public String getProjectNo() 
	{
		return projectNo;
	}

	public void setProjectNo(String projectNo) 
	{
		this.projectNo = projectNo;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}

	public String getAssignDate() 
	{
		return assignDate;
	}

	public void setAssignDate(String assignDate) 
	{
		this.assignDate = assignDate;
	}

	public String getOpenDate() 
	{
		return openDate;
	}

	public void setOpenDate(String openDate) 
	{
		this.openDate = openDate;
	}

	public String getPlanStartDate() 
	{
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) 
	{
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() 
	{
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) 
	{
		this.planEndDate = planEndDate;
	}

	public String getRealStartDate() 
	{
		return realStartDate;
	}

	public void setRealStartDate(String realStartDate) 
	{
		this.realStartDate = realStartDate;
	}

	public String getRealEndDate() 
	{
		return realEndDate;
	}

	public void setRealEndDate(String realEndDate) 
	{
		this.realEndDate = realEndDate;
	}

	public String getOurIntfPerson() 
	{
		return ourIntfPerson;
	}

	public void setOurIntfPerson(String ourIntfPerson) 
	{
		this.ourIntfPerson = ourIntfPerson;
	}

	public String getOtherIntfPerson() 
	{
		return otherIntfPerson;
	}

	public void setOtherIntfPerson(String otherIntfPerson)
	{
		this.otherIntfPerson = otherIntfPerson;
	}

	public Integer getContractCountPerson() 
	{
		return contractCountPerson;
	}

	public void setContractCountPerson(Integer contractCountPerson) 
	{
		this.contractCountPerson = contractCountPerson;
	}

	public ContractProject getContractProject_obj() 
	{
		return contractProject_obj;
	}

	public void setContractProject_obj(ContractProject contractProject_obj) 
	{
		this.contractProject_obj = contractProject_obj;
	}
	
	@Override
	public String add() throws Exception 
	{
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delete() throws Exception 
	{
		Integer id = (Integer)request.getAttribute("id");
		baseHibernateBo.delete(ContractProject.class, id);

		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		Integer id = (Integer) request.getAttribute("id");
		ContractProject project = (ContractProject)baseHibernateBo.findById(ContractProject.class, id);
		this.contractProject_obj = project;
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findBeanList() throws Exception 
	{
		return baseHibernateBo.findAll(ContractProject.class);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String insert() throws Exception 
	
	{
		ContractProject project = new ContractProject();
		project.setContractNo(this.contractNo);
		project.setProjectNo(this.projectNo);
		project.setProjectName(this.projectName);
		project.setAssignDate(DateUtil.getSqlDate(this.assignDate,Constants.DATE_FORMAT));
		project.setOpenDate(DateUtil.getSqlDate(this.openDate,Constants.DATE_FORMAT));
		project.setPlanStartDate(DateUtil.getSqlDate(this.planStartDate, Constants.DATE_FORMAT));
		project.setPlanEndDate(DateUtil.getSqlDate(this.planEndDate, Constants.DATE_FORMAT));
		project.setRealStartDate(DateUtil.getSqlDate(this.realStartDate, Constants.DATE_FORMAT));
		project.setRealEndDate(DateUtil.getSqlDate(this.realEndDate, Constants.DATE_FORMAT));
		project.setContractCountPerson(this.contractCountPerson);
		project.setOtherIntfPerson(this.otherIntfPerson);
		project.setOurIntfPerson(this.ourIntfPerson);
		baseHibernateBo.save(project);
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception 
	{
		ContractProject project = new ContractProject();
		project.setId(this.id);
		project.setContractNo(this.contractNo);
		project.setProjectNo(this.projectNo);
		project.setProjectName(this.projectName);
		project.setAssignDate(DateUtil.getSqlDate(this.assignDate,Constants.DATE_FORMAT));
		project.setOpenDate(DateUtil.getSqlDate(this.openDate,Constants.DATE_FORMAT));
		project.setPlanStartDate(DateUtil.getSqlDate(this.planStartDate, Constants.DATE_FORMAT));
		project.setPlanEndDate(DateUtil.getSqlDate(this.planEndDate, Constants.DATE_FORMAT));
		project.setRealStartDate(DateUtil.getSqlDate(this.realStartDate, Constants.DATE_FORMAT));
		project.setRealEndDate(DateUtil.getSqlDate(this.realEndDate, Constants.DATE_FORMAT));
		project.setContractCountPerson(this.contractCountPerson);
		project.setOtherIntfPerson(this.otherIntfPerson);
		project.setOurIntfPerson(this.ourIntfPerson);
		baseHibernateBo.saveOrUpdate(project);
		
		return Constants.LIST_KEY;
	}
}

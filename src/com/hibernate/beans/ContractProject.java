package com.hibernate.beans;

import java.util.Date;

public class ContractProject {
	private Integer id = null;
	
	private String contractNo = null;
	
	private String projectNo = null;
	
	private String projectName = null;
	
	private Date assignDate = null;
	
	private Date openDate = null;
	
	private Date planStartDate = null;
	
	private Date planEndDate = null;
	
	private Date realStartDate = null;
	
	private Date realEndDate = null;
	
	private String ourIntfPerson = null;
	
	private String otherIntfPerson = null;
	
	private Integer contractCountPerson = null;
	
	public ContractProject()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Date getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
	}

	public Date getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}

	public String getOurIntfPerson() {
		return ourIntfPerson;
	}

	public void setOurIntfPerson(String ourIntfPerson) {
		this.ourIntfPerson = ourIntfPerson;
	}

	public String getOtherIntfPerson() {
		return otherIntfPerson;
	}

	public void setOtherIntfPerson(String otherIntfPerson) {
		this.otherIntfPerson = otherIntfPerson;
	}

	public Integer getContractCountPerson() {
		return contractCountPerson;
	}

	public void setContractCountPerson(Integer contractCountPerson) {
		this.contractCountPerson = contractCountPerson;
	}
}

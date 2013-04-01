package com.hibernate.beans;

import java.sql.Date;

public class RealProject extends AbstractCommonBean
{
	private Integer id = null;
	
	private String projectNo = null;
	
	private String projectVersion = null;
	
	private String projectName = null;
	
	private String projectVersionName = null;
	
	private Date startDate = null;
	
	private Date endDate = null;
	
	private Integer persons = null;
	
	private String remark = null;
	
	public RealProject()
	{
		
	}
	
	public RealProject(Integer id)
	{
		this.id = id;
	}
	
	public RealProject(Integer id,String projectNo,String projectVersion,String projectName,String projectVersionName,
			Date startDate,Date endDate,Integer persons,String remark)
	{
		this.id = id;
		this.projectNo = projectNo;
		this.projectVersion = projectVersion;
		this.projectName = projectName;
		this.projectVersionName = projectVersionName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.persons = persons;
		this.remark = remark;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectVersionName() {
		return projectVersionName;
	}

	public void setProjectVersionName(String projectVersionName) {
		this.projectVersionName = projectVersionName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPersons() {
		return persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}

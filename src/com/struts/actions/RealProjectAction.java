package com.struts.actions;

import java.sql.Timestamp;
import java.util.List;

import com.hibernate.beans.RealProject;
import com.hibernate.bo.RealProjectBo;
import com.struts.util.Constants;
import com.common.util.DateUtil;


public class RealProjectAction extends BaseAction
{
	protected Integer id = null;
	
    protected String projectNo = null;
	
	protected String projectVersion = null;
	
	protected String projectName = null;
	
	protected String projectVersionName = null;
	
	protected String startDate = null;
	
	protected String endDate = null;
	
	protected Integer persons = null;
	
	protected String remark = null;
	
	protected RealProject realProject_obj = null;
	
	protected RealProjectBo realProjectBo = null;
	
	public RealProjectBo getRealProjectBo() 
	{
		return realProjectBo;
	}

	public void setRealProjectBo(RealProjectBo realProjectBo) 
	{
		this.realProjectBo = realProjectBo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public RealProject getRealProject_obj() {
		return realProject_obj;
	}

	public void setRealProject_obj(RealProject realProject_obj) {
		this.realProject_obj = realProject_obj;
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delete() throws Exception 
	{
		Integer id = (Integer)request.getAttribute("id");
		baseHibernateBo.delete(RealProject.class, id);
		
		return Constants.LIST_KEY;
		       
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		Integer id = (Integer)request.getAttribute("id");
		RealProject project = (RealProject)baseHibernateBo.findById(RealProject.class, id);
		this.realProject_obj = project;
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// TODO Auto-generated method stub
		return baseHibernateBo.findAll(RealProject.class);
	}

	@SuppressWarnings("unchecked")
	public String insert() throws Exception 
	{
		RealProject project = new RealProject();
		project.setProjectNo(this.projectNo);
		project.setProjectName(this.projectName);
		project.setProjectVersion(this.projectVersion);
		project.setProjectVersionName(this.projectVersionName);
		project.setStartDate(DateUtil.getSqlDate(this.startDate, Constants.DATE_FORMAT));
		project.setEndDate(DateUtil.getSqlDate(this.endDate, Constants.DATE_FORMAT));
		project.setPersons(this.persons);
		project.setRemark(this.remark);
		baseHibernateBo.save(project);
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception 
	{
		RealProject project = new RealProject();
		project.setId(this.id);
		project.setProjectNo(this.projectNo);
		project.setProjectName(this.projectName);
		project.setProjectVersion(this.projectVersion);
		project.setProjectVersionName(this.projectVersionName);
		project.setStartDate(DateUtil.getSqlDate(this.startDate, Constants.DATE_FORMAT));
		project.setEndDate(DateUtil.getSqlDate(this.endDate, Constants.DATE_FORMAT));
		project.setPersons(this.persons);
		project.setRemark(this.remark);
		baseHibernateBo.saveOrUpdate(project);
		return Constants.LIST_KEY;
	}

}

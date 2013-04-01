package com.struts.actions;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.PerformanceOpt;
import com.hibernate.bo.ibo.IPerformanceOptBo;
import com.struts.util.Constants;

public class PerformanceOptAction extends BaseAction {

	private IPerformanceOptBo pfBo;
	private String staffId;//员工id
	private String staffName;//员工姓名
	private Integer workAttendence;//考勤所获分数
	private Integer layPBC;//PBC计划所获分
	private Integer writeLog;//填写日志所获分
	private Integer regularMeeting;//日常会议所获分
	private Integer site;//负责局点所获分
	private Integer siteBak;//局点备份所获分
	private Integer problemCounts;//录入问题的分数
	private Integer problemSolve;//解决问题的分数
	private Integer coding;//开发的分数
	private Integer praiseLetter;//获得表扬信的分数
	private Integer custComplain;//客户投诉分数
	private Integer siteComplain;//一线投诉分数
	private Integer custAppraise;//客户评价分数
	private Integer training;//培训的分数
	private String  month;//所属月份
	private Integer other;//其他分数
	
	public IPerformanceOptBo getPfBo() {
		return pfBo;
	}

	public void setPfBo(IPerformanceOptBo pfBo) {
		this.pfBo = pfBo;
	}

	public String query() throws Exception {
		
		return Constants.INIT_KEY;
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

	@Override
	public String delete() throws Exception {
		String staffid = request.getParameter("staffId");
		String month = request.getParameter("month");
		if(null == staffid || "".equals(staffid) || null == month || "".equals(month))
		{
			this.addActionError(this.getText("the staffid or month is null."));
			return Constants.LIST_KEY;
		}
		PerformanceOpt pfopt = pfBo.findPerformanceOptById(staffId,month);
		pfBo.delPerformanceOpt(pfopt);
		
		return Constants.LIST_KEY;
	}

	@Override
	public String edit() throws Exception {
		String staffId = request.getParameter("staffId");
		String month = request.getParameter("month");
		if(null == staffId || "".equals(staffId))
		{
			this.addActionError(this.getText("The staff ID is not exist."));
			return Constants.LIST_KEY;
		}
		if(null == month || "".equals(month))
		{
			this.addActionError(this.getText("The month is not exist."));
			return Constants.LIST_KEY;
		}
		
		PerformanceOpt pfopt = pfBo.findPerformanceOptById(staffId,month);
		if(null == pfopt)
		{
			this.addActionError(this.getText("Can not find any info by staffId:"+staffId+" ,month="+month));
			return Constants.LIST_KEY;
		}
		this.staffId = pfopt.getStaffId();
		this.staffName = pfopt.getStaffName();
		this.workAttendence = pfopt.getWorkAttendence();
		this.writeLog = pfopt.getWriteLog();
		this.layPBC = pfopt.getLayPBC();
		this.regularMeeting = pfopt.getRegularMeeting();
		this.site = pfopt.getSite();
		this.siteBak = pfopt.getSiteBak();
		this.problemCounts = pfopt.getProblemCounts();
		this.problemSolve = pfopt.getProblemSolve();
		this.praiseLetter = pfopt.getPraiseLetter();
		this.coding = pfopt.getCoding();
		this.custAppraise = pfopt.getCustAppraise();
		this.custComplain = pfopt.getCustComplain();
		this.siteComplain = pfopt.getSiteComplain();
		this.training = pfopt.getTraining();
		this.other = pfopt.getOther();
		this.month = pfopt.getMonth();
		
		return Constants.EDIT_KEY;
	}

	@Override
	public List findBeanList() throws Exception {
		
		ArrayList pfoptList = null;
		try {
			if(null != this.staffId && !"".equals(this.staffId))
			{
				pfoptList = pfBo.findPerformanceOptById(this.staffId);
			}
			else if(null != this.staffName && !"".equals(this.staffName))
			{
				pfoptList = pfBo.findPerformanceOptByName(this.staffName);
			}
			else
			{
				pfoptList = pfBo.findAllPerformanceOpt();
			}
		} catch (Exception e) {
			this.addActionError(this.getText("query.err"));
		}
		return pfoptList;
	}

	@Override
	public String insert() throws Exception {
		PerformanceOpt pfopt = null;
		
		pfopt = pfBo.findPerformanceOptById(staffId, month);
		if(null != pfopt)
		{
			this.addActionError(this.getText("This record has been exist."));
			return Constants.ADD_KEY;
		}
		
		pfopt = new PerformanceOpt();
		pfopt.setStaffId(staffId);
		pfopt.setStaffName(staffName);
		pfopt.setWorkAttendence(workAttendence);
		pfopt.setLayPBC(layPBC);
		pfopt.setWriteLog(writeLog);
		pfopt.setRegularMeeting(regularMeeting);
		pfopt.setSite(site);
		pfopt.setSiteBak(siteBak);
		pfopt.setProblemCounts(problemCounts);
		pfopt.setProblemSolve(problemSolve);
		pfopt.setPraiseLetter(praiseLetter);
		pfopt.setCoding(coding);
		pfopt.setCustAppraise(custAppraise);
		pfopt.setCustComplain(custComplain);
		pfopt.setTraining(training);
		pfopt.setOther(other);
		pfopt.setMonth(month);
		pfopt.setSiteComplain(siteComplain);
		
		pfBo.addPerformanceOpt(pfopt);
		this.addActionError(this.getText("Add performance success."));
		return Constants.LIST_KEY;
	}

	@Override
	public String update() throws Exception {
		PerformanceOpt pfopt = new PerformanceOpt();
		pfopt.setStaffId(staffId);
		pfopt.setStaffName(staffName);
		pfopt.setWorkAttendence(workAttendence);
		pfopt.setLayPBC(layPBC);
		pfopt.setWriteLog(writeLog);
		pfopt.setRegularMeeting(regularMeeting);
		pfopt.setSite(site);
		pfopt.setSiteBak(siteBak);
		pfopt.setProblemCounts(problemCounts);
		pfopt.setProblemSolve(problemSolve);
		pfopt.setPraiseLetter(praiseLetter);
		pfopt.setCoding(coding);
		pfopt.setCustAppraise(custAppraise);
		pfopt.setCustComplain(custComplain);
		pfopt.setTraining(training);
		pfopt.setOther(other);
		pfopt.setMonth(month);
		pfopt.setSiteComplain(siteComplain);
		
		pfBo.updatePerformanceOpt(pfopt);
		return Constants.LIST_KEY;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getWorkAttendence() {
		return workAttendence;
	}

	public void setWorkAttendence(Integer workAttendence) {
		this.workAttendence = workAttendence;
	}

	public Integer getLayPBC() {
		return layPBC;
	}

	public void setLayPBC(Integer layPBC) {
		this.layPBC = layPBC;
	}

	public Integer getWriteLog() {
		return writeLog;
	}

	public void setWriteLog(Integer writeLog) {
		this.writeLog = writeLog;
	}

	public Integer getRegularMeeting() {
		return regularMeeting;
	}

	public void setRegularMeeting(Integer regularMeeting) {
		this.regularMeeting = regularMeeting;
	}

	public Integer getSite() {
		return site;
	}

	public void setSite(Integer site) {
		this.site = site;
	}

	public Integer getSiteBak() {
		return siteBak;
	}

	public void setSiteBak(Integer siteBak) {
		this.siteBak = siteBak;
	}

	public Integer getProblemCounts() {
		return problemCounts;
	}

	public void setProblemCounts(Integer problemCounts) {
		this.problemCounts = problemCounts;
	}

	public Integer getProblemSolve() {
		return problemSolve;
	}

	public void setProblemSolve(Integer problemSolve) {
		this.problemSolve = problemSolve;
	}

	public Integer getCoding() {
		return coding;
	}

	public void setCoding(Integer coding) {
		this.coding = coding;
	}

	public Integer getPraiseLetter() {
		return praiseLetter;
	}

	public void setPraiseLetter(Integer praiseLetter) {
		this.praiseLetter = praiseLetter;
	}

	public Integer getCustComplain() {
		return custComplain;
	}

	public void setCustComplain(Integer custComplain) {
		this.custComplain = custComplain;
	}

	public Integer getSiteComplain() {
		return siteComplain;
	}

	public void setSiteComplain(Integer siteComplain) {
		this.siteComplain = siteComplain;
	}

	public Integer getCustAppraise() {
		return custAppraise;
	}

	public void setCustAppraise(Integer custAppraise) {
		this.custAppraise = custAppraise;
	}

	public Integer getTraining() {
		return training;
	}

	public void setTraining(Integer training) {
		this.training = training;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getOther() {
		return other;
	}

	public void setOther(Integer other) {
		this.other = other;
	}

}

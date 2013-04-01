/*
 * 记录某月某员工的绩效分数的值对象，以分数形式存储
 */
package com.hibernate.beans;

public class PerformanceOpt extends AbstractCommonBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -893468714384186841L;
	public String staffId;//员工id
	public String staffName;//员工姓名
	public Integer workAttendence;//考勤所获分数
	public Integer layPBC;//PBC计划所获分
	public Integer writeLog;//填写日志所获分
	public Integer regularMeeting;//日常会议所获分
	public Integer site;//负责局点所获分
	public Integer siteBak;//局点备份所获分
	public Integer problemCounts;//录入问题的分数
	public Integer problemSolve;//解决问题的分数
	public Integer coding;//开发的分数
	public Integer praiseLetter;//获得表扬信的分数
	public Integer custComplain;//客户投诉分数
	public Integer siteComplain;//一线投诉分数
	public Integer custAppraise;//客户评价分数
	public Integer training;//培训的分数
	public String  month;//所属月份
	public Integer other;//其他分数
	
	public PerformanceOpt(){}

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

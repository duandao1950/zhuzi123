/*
 * ��¼ĳ��ĳԱ���ļ�Ч������ֵ�����Է�����ʽ�洢
 */
package com.hibernate.beans;

public class PerformanceOpt extends AbstractCommonBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -893468714384186841L;
	public String staffId;//Ա��id
	public String staffName;//Ա������
	public Integer workAttendence;//�����������
	public Integer layPBC;//PBC�ƻ������
	public Integer writeLog;//��д��־�����
	public Integer regularMeeting;//�ճ����������
	public Integer site;//����ֵ������
	public Integer siteBak;//�ֵ㱸�������
	public Integer problemCounts;//¼������ķ���
	public Integer problemSolve;//�������ķ���
	public Integer coding;//�����ķ���
	public Integer praiseLetter;//��ñ����ŵķ���
	public Integer custComplain;//�ͻ�Ͷ�߷���
	public Integer siteComplain;//һ��Ͷ�߷���
	public Integer custAppraise;//�ͻ����۷���
	public Integer training;//��ѵ�ķ���
	public String  month;//�����·�
	public Integer other;//��������
	
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

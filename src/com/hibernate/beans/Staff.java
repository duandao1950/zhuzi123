package com.hibernate.beans;

import java.sql.Date;

public class Staff extends AbstractCommonBean
{

	private String staffId = null;//Ա����
	
	private String staffName = null;//Ա������
	
	private String skill = null;//���ܷ���
	
	private Integer statusId = null;//Ա����ǰ״̬ 
	
	private String tel1 = null;//��һ��ϵ��ʽ
	
	private String tel2 = null;//�ڶ���ϵ��ʽ
	
	private String email1 = null;//��һ����
	
	private String email2 = null;//�ڶ�����
	
	private Date enterComDate = null;//��ְʱ��
	
	private Date exitComDate = null;//��ְʱ��
	
	private String groupName = null;//������
	
	private Integer workYears = null;//���빫˾ǰ��������
	
	private String remark = null;//��ע
	
	public Staff()
	{
		
	}
	
	public Staff(String staffId)
	{
		this.staffId = staffId;
	}
	
	public Staff(String staffId, String staffName, String skill, Integer statusId, String tel1, String tel2, String email1,
			String email2, Date enterComDate,Date exitComDate, String groupName, Integer workYears, String remark)
	{
		this.staffId = staffId;
		this.staffName = staffName;
		this.skill = skill;
		this.statusId = statusId;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email1 = email1;
		this.email2 = email2;
		this.enterComDate = enterComDate;
		this.exitComDate = exitComDate;
		this.groupName = groupName;
		this.workYears = workYears;
		this.remark = remark;
		
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public Date getEnterComDate() {
		return enterComDate;
	}

	public void setEnterComDate(Date enterComDate) {
		this.enterComDate = enterComDate;
	}

	public Date getExitComDate() {
		return exitComDate;
	}

	public void setExitComDate(Date exitComDate) {
		this.exitComDate = exitComDate;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getWorkYears() {
		return workYears;
	}

	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}

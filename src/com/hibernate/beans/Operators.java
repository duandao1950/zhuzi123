package com.hibernate.beans;

import java.util.Date;

public class Operators {
	private Integer operCode;
	private String operId;
	private String operName;
	private String isValid;
	private String password;
	private String prePassword;
	private String belongTeam;
	private String mobilePhone;
	private String firstEmail;
	private String secondEmail;
	private String notesId;
	private Date registerTime;
	private Date loginTime;
	private Date cancelTime;
	
	public Operators() {

	}

	public Operators(String operId) {
		this.operId = operId;
	}

	public Operators(Integer operCode,String operId, String operName, String isValid,
			String password, Date registerTime, Date loginTime,Date cancelTime) {
		this.operCode = operCode;
		this.operId = operId;
		this.operName = operName;
		this.isValid = isValid;
		this.password = password;
		this.registerTime = registerTime;
		this.loginTime = loginTime;
		this.cancelTime = cancelTime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getOperCode() {
		return operCode;
	}

	public void setOperCode(Integer operCode) {
		this.operCode = operCode;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getPrePassword() {
		return prePassword;
	}

	public void setPrePassword(String prePassword) {
		this.prePassword = prePassword;
	}

	public String getBelongTeam() {
		return belongTeam;
	}

	public void setBelongTeam(String belongTeam) {
		this.belongTeam = belongTeam;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getFirstEmail() {
		return firstEmail;
	}

	public void setFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}

	public String getNotesId() {
		return notesId;
	}

	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
}

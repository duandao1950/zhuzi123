package com.common.util.assistant;

public class Loginfo {
	@ExcelAnnotation(exportName = "�û�IP��ַ")
	private String userip;
	@ExcelAnnotation(exportName = "�û�����")
	private String username;
	@ExcelAnnotation(exportName = "������Ϣ")
	private String logInfo;

	/**
	 * @return the userip
	 */
	public String getUserip() {
		return userip;
	}
	/**
	 * @param userip the userip to set
	 */
	public void setUserip(String userip) {
		this.userip = userip;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the logInfo
	 */
	public String getLogInfo() {
		return logInfo;
	}
	/**
	 * @param logInfo the logInfo to set
	 */
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
	
}

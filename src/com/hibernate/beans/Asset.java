package com.hibernate.beans;

public class Asset extends AbstractCommonBean
{
	private Integer id = null;
	
	private String staffId = null;
	
	private String deviceNo = null;
	
	private String comDisplayNo = null;
	
	private String comHostNo = null;
	
	private String ipAddress = null;
	
	private String deviceAddress = null;
	
	private String status = null;
	
	private String remark = null;
	
	public Asset()
	{
		
	}
	
	public Asset(Integer id)
	{
		this.id = id;
	}
	

	public Asset(Integer id,String staffId, String deviceNo, String comDisplayNo, String ipAddress, 
			String deviceAddress, String status, String remark)
	{
		this.id = id;
		this.staffId = staffId;
		this.deviceNo = deviceNo;
		this.comDisplayNo = comDisplayNo;
		this.ipAddress = ipAddress;
		this.deviceAddress = deviceAddress;
		this.status = status;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	public String getDeviceNo() 
	{
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) 
	{
		this.deviceNo = deviceNo;
	}

	public String getComDisplayNo() 
	{
		return comDisplayNo;
	}

	public void setComDisplayNo(String comDisplayNo) 
	{
		this.comDisplayNo = comDisplayNo;
	}



	public String getDeviceAddress() 
	{
		return deviceAddress;
	}

	public void setDeviceAddress(String deviceAddress) 
	{
		this.deviceAddress = deviceAddress;
	}

	public String getComHostNo() {
		return comHostNo;
	}

	public void setComHostNo(String comHostNo) {
		this.comHostNo = comHostNo;
	}
	
	

}

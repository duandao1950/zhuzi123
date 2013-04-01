package com.hibernate.beans;

import java.util.Date;
import java.io.Serializable;

public class AbstractWorkRecord implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String staffId = null;
	
	private String progTeam = null;
	
	private String startTime = null;

	private String endTime = null;
	
	private String workType = null;
	
	private String approveFlag = null;
	
	private String workReason = null;
	
	private String remark = null;
	
	private String approveStaffId = null;

	public AbstractWorkRecord()
    {
    }

    /**
     * Constructor of AbstractAddress instances given a simple primary key.
     * @param id
     */
    public AbstractWorkRecord(Integer  id)
    {
        this.setId(id);
    }

    public AbstractWorkRecord(Integer id, String staffId, String progTeam, String startTime, String endTime,
    		String workType, String approveFlag, String workReason, String remark, String approveStaffId) 
    {
    	this.setId(id);
		this.setStaffId(staffId);
		this.setProgTeam(progTeam);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.setWorkType(workType);
		this.setApproveFlag(approveFlag);
		this.setWorkReason(workReason);
		this.setRemark(remark);
		this.setApproveStaffId(approveStaffId);
	}
    
    public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getProgTeam() {
		return progTeam;
	}

	public void setProgTeam(String progTeam) {
		this.progTeam = progTeam;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	public String getWorkReason() {
		return workReason;
	}

	public void setWorkReason(String workReason) {
		this.workReason = workReason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApproveStaffId() {
		return approveStaffId;
	}

	public void setApproveStaffId(String approveStaffId) {
		this.approveStaffId = approveStaffId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}

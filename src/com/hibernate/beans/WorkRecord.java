package com.hibernate.beans;

import java.sql.Timestamp;

public class WorkRecord extends AbstractCommonBean
{

	private Integer id;
	
	private String staffId = null;
	
	private String progTeam = null;
	
	private Timestamp startTime = null;

	private Timestamp endTime = null;
	
	private Integer workType = null;
	
	private Integer approveFlag = null;
	
	private String workReason = null;
	
	private String remark = null;
	
	private String approveStaffId = null;
	
	public WorkRecord()
    {
    }

    /**
     * Constructor of AbstractAddress instances given a simple primary key.
     * @param id
     */
    public WorkRecord(Integer  id)
    {
        this.setId(id);
    }

    public WorkRecord(Integer id, String staffId, String progTeam, Timestamp startTime, Timestamp endTime,
    		Integer workType, Integer approveFlag, String workReason, String remark, String approveStaffId) 
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getWorkType() {
		return workType;
	}

	public void setWorkType(Integer workType) {
		this.workType = workType;
	}

	public Integer getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(Integer approveFlag) {
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
}

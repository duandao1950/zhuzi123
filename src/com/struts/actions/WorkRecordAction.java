package com.struts.actions;

import java.util.List;

import com.common.util.DateUtil;
import com.hibernate.beans.WorkRecord;
import com.hibernate.bo.WorkRecordBo;
import com.struts.util.Constants;

public class WorkRecordAction extends BaseAction
{

	/**
	 * 考勤信息action
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	
	protected String staffId = null;//员工号
	
	protected String progTeam = null;//所在项目组
	
	protected String startTime = null;//上班开始时间

	protected String endTime = null;//下班时间
	
	protected Integer workType = null;//是否是加班 0正常上班 1加班 2调休 3请假 4年休
	
	protected Integer approveFlag = null;//审批状态 0未审批 1通过 2未通过
	
	protected String workReason = null;//加班原因
	
	protected String remark = null;//备注
	
	protected String approveStaffId = null;
	
	private WorkRecord workrecord_obj = null;
	
	protected WorkRecordBo workRecordBo;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WorkRecord getWorkrecord_obj() {
		return workrecord_obj;
	}

	public void setWorkrecord_obj(WorkRecord workrecord_obj) {
		this.workrecord_obj = workrecord_obj;
	}


	public WorkRecordBo getWorkRecordBo() {
		return workRecordBo;
	}

	public void setWorkRecordBo(WorkRecordBo workRecordBo) 
	{
		this.workRecordBo = workRecordBo;
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
	
	/*
	 * 根据员工号或是审批员工号查询所有的考勤信息
	 * @see com.struts.actions.BaseAction#findBeanList()
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception 
	{
		WorkRecord workRecord = new WorkRecord();
		workRecord.setStaffId(this.staffId);
		workRecord.setApproveStaffId(approveStaffId);
		return workRecordBo.findAllByCondition(WorkRecord.class, workRecord);
	}
	
	
	public String query() throws Exception 
	{
		return Constants.QUERY_KEY;
	}	
	
	
	

	@Override
	public String add() throws Exception 
	{
		return Constants.ADD_KEY;
		

	}

	@Override
	public String back() throws Exception 
	{
		return null;
	}

	/*
	 * 删除单条考勤记录
	 * @see com.struts.actions.BaseAction#delete()
	 */
	@SuppressWarnings("unchecked")
	public String delete() throws Exception 
	{
		String id = request.getParameter("id");
		if(null == id && "".equals(id))
		{
			this.addActionMessage(this.getText("workrecord.message.edit.notexist"));
		}
		baseHibernateBo.delete(WorkRecord.class, Integer.valueOf(id));
		return Constants.LIST_KEY;
	}

	/*
	 * 根据ID查询出详细的考勤信息，跳转至编辑页面
	 * @see com.struts.actions.BaseAction#edit()
	 */
	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		String id = request.getParameter("id");
		if(null == id && "".equals(id))
		{
			this.addActionError(this.getText("workrecord.message.edit.notexist"));
			return Constants.LIST_KEY;
		}
		
		WorkRecord workRecord = (WorkRecord)baseHibernateBo.findById(WorkRecord.class, new Integer(id));
		
		if(null == workRecord)
		{
			this.addActionError(this.getText("workrecord.message.edit.notexist"));
			return Constants.LIST_KEY;
		}
		
		this.workrecord_obj = workRecord;
		
		if((new Integer(0)).equals(workRecord.getWorkType()))
		{
			request.setAttribute("approve", "none");
		}
		if(!(new Integer(1)).equals(workRecord.getWorkType()))
		{
			request.setAttribute("reason", "none");
		}
		return Constants.EDIT_KEY;
	}

    /*
     * 添加考勤信息
     * @see com.struts.actions.BaseAction#insert()
     */
	@SuppressWarnings("unchecked")
	public String insert() throws Exception 
	{
		WorkRecord workRecord = new WorkRecord();
		workRecord.setStaffId(this.staffId);
		workRecord.setApproveStaffId(this.getApproveStaffId());
		workRecord.setApproveFlag(this.approveFlag);
		workRecord.setProgTeam(this.progTeam);
		//格式化时间
		workRecord.setStartTime(DateUtil.getTimestamp(this.startTime, Constants.LONG_DATE_FORMAT));
		workRecord.setEndTime(DateUtil.getTimestamp(this.endTime, Constants.LONG_DATE_FORMAT));
		workRecord.setWorkReason(this.workReason);
		workRecord.setWorkType(this.workType);
		workRecord.setRemark(this.remark);
		
		// update object
		baseHibernateBo.save(workRecord);
		this.addActionMessage(this.getText("message.add.success"));
		return Constants.LIST_KEY;
		
	}

	/*
	 * 更新考勤信息
	 * @see com.struts.actions.BaseAction#update()
	 */
	@SuppressWarnings("unchecked")
	public String update() throws Exception {
		WorkRecord workRecord = new WorkRecord();
		workRecord.setId(this.getId());
		workRecord.setStaffId(this.staffId);
		workRecord.setApproveStaffId(this.getApproveStaffId());
		workRecord.setApproveFlag(this.approveFlag);
		workRecord.setProgTeam(this.progTeam);
		workRecord.setStartTime(DateUtil.getTimestamp(this.startTime, Constants.LONG_DATE_FORMAT));
		workRecord.setEndTime(DateUtil.getTimestamp(this.endTime, Constants.LONG_DATE_FORMAT));
		workRecord.setWorkReason(this.workReason);
		workRecord.setWorkType(this.workType);
		workRecord.setRemark(this.remark);
		
		// update object
		baseHibernateBo.saveOrUpdate(workRecord);
		
		// save messages
		this.addActionMessage(this.getText("message.edit.success"));
		return Constants.LIST_KEY;
	}

}

package com.struts.actions;

import java.util.List;

import com.common.util.DateUtil;
import com.hibernate.beans.WorkRecord;
import com.hibernate.bo.WorkRecordBo;
import com.struts.util.Constants;

public class WorkRecordAction extends BaseAction
{

	/**
	 * ������Ϣaction
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	
	protected String staffId = null;//Ա����
	
	protected String progTeam = null;//������Ŀ��
	
	protected String startTime = null;//�ϰ࿪ʼʱ��

	protected String endTime = null;//�°�ʱ��
	
	protected Integer workType = null;//�Ƿ��ǼӰ� 0�����ϰ� 1�Ӱ� 2���� 3��� 4����
	
	protected Integer approveFlag = null;//����״̬ 0δ���� 1ͨ�� 2δͨ��
	
	protected String workReason = null;//�Ӱ�ԭ��
	
	protected String remark = null;//��ע
	
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
	 * ����Ա���Ż�������Ա���Ų�ѯ���еĿ�����Ϣ
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
	 * ɾ���������ڼ�¼
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
	 * ����ID��ѯ����ϸ�Ŀ�����Ϣ����ת���༭ҳ��
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
     * ��ӿ�����Ϣ
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
		//��ʽ��ʱ��
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
	 * ���¿�����Ϣ
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

package com.struts.actions;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.common.page.Page;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hibernate.beans.Address;
import com.hibernate.beans.Staff;
import com.hibernate.bo.StaffBo;
import com.struts.util.Constants;
import com.common.util.DateUtil;

public class StaffAction extends BaseAction 
{
	/**
	 * Ա����Ϣaction
	 */
	private static final long serialVersionUID = 1L;
    protected String staffId = null;//Ա����
	
	protected String staffName = null;//Ա������
	
	protected String skill = null;//���ܷ���
	
	protected Integer statusId = null;//Ա����ǰ״̬ 
	
	protected String tel1 = null;//��һ��ϵ��ʽ
	
	protected String tel2 = null;//�ڶ���ϵ��ʽ
	
	protected String email1 = null;//��һ����
	
	protected String email2 = null;//�ڶ�����
	
	protected String enterComDate = null;//��ְʱ��
	
	protected String exitComDate = null;//��ְʱ��
	
	protected String groupName = null;//������
	
	protected Integer workYears = null;//���빫˾ǰ��������
	
	protected String remark = null;//��ע
	
	protected Staff staff_obj = null;
	
	private StaffBo staffBo = null;
	
	protected String show = null;

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
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

	public String getEnterComDate() {
		return enterComDate;
	}

	public void setEnterComDate(String enterComDate) {
		this.enterComDate = enterComDate;
	}

	public String getExitComDate() {
		return exitComDate;
	}

	public void setExitComDate(String exitComDate) {
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

	public Staff getStaff_obj() {
		return staff_obj;
	}

	public void setStaff_obj(Staff staff_obj) {
		this.staff_obj = staff_obj;
	}

	public StaffBo getStaffBo() {
		return staffBo;
	}

	public void setStaffBo(StaffBo staffBo) {
		this.staffBo = staffBo;
	}
	

	@Override
	public String add() throws Exception 
	{
		return Constants.ADD_KEY;
	}
	
	public String toQry() throws Exception 
	{
		return Constants.TO_QRY_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ����Ա����ɾ��Ա����Ϣ
	 * (non-Javadoc)
	 * @see com.struts.actions.BaseAction#delete()
	 */
	@SuppressWarnings("unchecked")
	public String delete() throws Exception 
	{
		String staffId = (String)request.getAttribute("staffId");
		baseHibernateBo.delete(Staff.class, staffId);
		
		return Constants.LIST_KEY;
	}
	
	public String query() throws Exception 
	{
		return Constants.QUERY_KEY;
	}	

	/*
	 * ����Ա���Ų�ѯԱ����Ϣ����ת���༭ҳ��
	 * @see com.struts.actions.BaseAction#edit()
	 */
	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		String staffId = (String)request.getAttribute("staffId");
		
		//����Ա���Ų�ѯԱ����Ϣ
		Staff staff = (Staff)baseHibernateBo.findById(Staff.class, staffId);
		
		this.staff_obj = staff;
		return Constants.EDIT_KEY;
	}

	/*
	 * ��ѯ����Ա����Ϣ���û�ѡ��
	 * (non-Javadoc)
	 * @see com.struts.actions.BaseAction#toShow()
	 */
	@SuppressWarnings("unchecked")
	public String toShow() throws Exception 
	{
		if (isTimeout()) 
		{
			return Constants.INDEX_KEY;
		}

		String startStr = request.getParameter("start");
		String pageRowStr = request.getParameter("pageRows");

		startStr = (startStr == null || "".equals(startStr)) ? "0" : startStr;
		int start = startStr.equals("0") ? 0 : Integer.parseInt(startStr);
		// ÿҳ��ʾ����
		pageRowStr = (pageRowStr == null || "".equals(pageRowStr)) ? "9"
				: pageRowStr;
		int count = Integer.parseInt(pageRowStr);

		List list = this.findBeanListByCondition();

		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, start, count);
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}
		// set addressList
		request.setAttribute("page", page);
	    request.setAttribute("show", Constants.STR_1);
	    request.setAttribute("defStaff", ((Staff)beanList.get(0)).getStaffId());
	    this.setShow(Constants.STR_1);
	    return Constants.TO_SHOW_KEY;
	}
	
	public void toShowAjax() throws Exception 
	{
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out = response.getWriter();
		List list = this.findBeanListByCondition();
		JsonObject obj = new JsonObject();
		JsonArray lineitemArray = new JsonArray();
		Staff staff = new Staff();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			staff = (Staff) it.next();
			JsonObject objlineitem = new JsonObject();			
			objlineitem.addProperty("id",staff.getStaffId());
			objlineitem.addProperty("name",staff.getStaffName());
			objlineitem.addProperty("skill",staff.getSkill());
			objlineitem.addProperty("status",staff.getStatusId());
			objlineitem.addProperty("groupname",staff.getGroupName());
			lineitemArray.add(objlineitem);
		}
		obj.add("rows", lineitemArray);
		out.print(lineitemArray);			
	}
	
	public List<T> findBeanListByCondition() throws Exception 
	{
		Staff staff = new Staff();
		staff.setStaffId(this.staffId);
		staff.setStaffName(this.staffName);
		/*staff.setSkill(this.skill);
		staff.setTel1(this.tel1);
		staff.setTel2(this.tel2);
		staff.setEmail1(this.email1);
		staff.setEmail2(this.email2);
		staff.setEnterComDate(DateUtil.getSqlDate(this.enterComDate, Constants.DATE_FORMAT));
		staff.setExitComDate(DateUtil.getSqlDate(this.exitComDate, Constants.DATE_FORMAT));
		staff.setGroupName(this.groupName);
		staff.setWorkYears(this.workYears);*/
		return staffBo.findBeanListByCondition(Staff.class,staff);
	}
	
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception 
	{
		Staff staff = new Staff();
		staff.setStaffId(this.staffId);
		staff.setStaffName(this.staffName);
		staff.setSkill(this.skill);
		staff.setTel1(this.tel1);
		staff.setTel2(this.tel2);
		staff.setEmail1(this.email1);
		staff.setEmail2(this.email2);
		if(null != this.enterComDate && !"".equals(this.enterComDate))
		{
			staff.setEnterComDate(DateUtil.getSqlDate(this.enterComDate, Constants.DATE_FORMAT));
		}
		if(null != this.exitComDate && !"".equals(this.exitComDate))
		{
			staff.setExitComDate(DateUtil.getSqlDate(this.exitComDate, Constants.DATE_FORMAT));
		}
		staff.setGroupName(this.groupName);
		staff.setStatusId(this.statusId);
		staff.setWorkYears(this.workYears);
		return staffBo.findBeanList(Staff.class,staff);
	}

	/*
	 * ����µ�Ա����Ϣ
	 * (non-Javadoc)
	 * @see com.struts.actions.BaseAction#insert()
	 */
	@SuppressWarnings("unchecked")
	public String insert() throws Exception 
	{
		Staff staff = new Staff();
		staff.setStaffId(this.staffId);
		staff.setStaffName(this.staffName);
		staff.setSkill(this.skill);
		staff.setTel1(this.tel1);
		staff.setTel2(this.tel2);
		staff.setEmail1(this.email1);
		staff.setEmail2(this.email2);
		//��ʽ��ʱ��
		if(null != this.enterComDate && !"".equals(this.enterComDate))
		{
			staff.setEnterComDate(DateUtil.getSqlDate(this.enterComDate, Constants.DATE_FORMAT));
		}
		if(null != this.exitComDate && !"".equals(this.exitComDate))
		{
			staff.setExitComDate(DateUtil.getSqlDate(this.exitComDate, Constants.DATE_FORMAT));
		}
		staff.setStatusId(this.statusId);
		staff.setGroupName(this.groupName);
		staff.setWorkYears(this.workYears);
		staff.setRemark(this.remark);
		baseHibernateBo.save(staff);
		
		return Constants.LIST_KEY;
	}
 
	/*
	 * ����Ա����Ϣ
	 * (non-Javadoc)
	 * @see com.struts.actions.BaseAction#update()
	 */
	@SuppressWarnings("unchecked")
	public String update() throws Exception 
	{
		Staff staff = new Staff();
		staff.setStaffId(this.staffId);
		staff.setStaffName(this.staffName);
		staff.setSkill(this.skill);
		staff.setTel1(this.tel1);
		staff.setTel2(this.tel2);
		staff.setEmail1(this.email1);
		staff.setEmail2(this.email2);
		if(null != this.enterComDate && !"".equals(this.enterComDate))
		{
			staff.setEnterComDate(DateUtil.getSqlDate(this.enterComDate, Constants.DATE_FORMAT));
		}
		if(null != this.exitComDate && !"".equals(this.exitComDate))
		{
			staff.setExitComDate(DateUtil.getSqlDate(this.exitComDate, Constants.DATE_FORMAT));
		}
		staff.setGroupName(this.groupName);
		staff.setWorkYears(this.workYears);
		staff.setRemark(this.remark);
		staff.setStatusId(this.statusId);
		baseHibernateBo.saveOrUpdate(staff);
		
		return Constants.LIST_KEY;
	}
	
	public List findBeanListAjax() throws Exception 
	{
		Staff staff = new Staff();
		staff.setStaffId(this.staffId);
		staff.setStaffName(this.staffName);
		staff.setSkill(this.skill);
		staff.setTel1(this.tel1);
		staff.setTel2(this.tel2);
		staff.setEmail1(this.email1);
		staff.setEmail2(this.email2);
		if(null != this.enterComDate && !"".equals(this.enterComDate))
		{
			staff.setEnterComDate(DateUtil.getSqlDate(this.enterComDate, Constants.DATE_FORMAT));
		}
		if(null != this.exitComDate && !"".equals(this.exitComDate))
		{
			staff.setExitComDate(DateUtil.getSqlDate(this.exitComDate, Constants.DATE_FORMAT));
		}
		staff.setGroupName(this.groupName);
		staff.setStatusId(this.statusId);
		staff.setWorkYears(this.workYears);
		return staffBo.findBeanList(Staff.class,staff);
	}
}

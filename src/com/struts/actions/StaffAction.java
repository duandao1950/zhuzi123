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
	 * 员工信息action
	 */
	private static final long serialVersionUID = 1L;
    protected String staffId = null;//员工号
	
	protected String staffName = null;//员工姓名
	
	protected String skill = null;//技能方向
	
	protected Integer statusId = null;//员工当前状态 
	
	protected String tel1 = null;//第一联系方式
	
	protected String tel2 = null;//第二联系方式
	
	protected String email1 = null;//第一邮箱
	
	protected String email2 = null;//第二邮箱
	
	protected String enterComDate = null;//入职时间
	
	protected String exitComDate = null;//离职时间
	
	protected String groupName = null;//所属组
	
	protected Integer workYears = null;//进入公司前工作年限
	
	protected String remark = null;//备注
	
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
	 * 根据员工号删除员工信息
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
	 * 根据员工号查询员工信息，并转到编辑页面
	 * @see com.struts.actions.BaseAction#edit()
	 */
	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		String staffId = (String)request.getAttribute("staffId");
		
		//根据员工号查询员工信息
		Staff staff = (Staff)baseHibernateBo.findById(Staff.class, staffId);
		
		this.staff_obj = staff;
		return Constants.EDIT_KEY;
	}

	/*
	 * 查询所有员工信息供用户选择
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
		// 每页显示行数
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
	 * 添加新的员工信息
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
		//格式化时间
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
	 * 更新员工信息
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

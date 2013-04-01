package com.struts.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.common.util.DateUtil;
import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
import com.hibernate.bo.ibo.IOperatorBo;
import com.hibernate.bo.ibo.IRoleBo;
import com.struts.util.Constants;

public class RoleAction extends BaseAction {

	private Logger log = Logger.getLogger(this.getClass());
	
	private IRoleBo roleBo;
	private IOperatorBo operBo;
	
	private String roleId;//role id
	private String roleName;//role's name
	private String description;//role's description
	private Timestamp createTime;//role create time
	private String createOperId;//who create this role
	private ArrayList allMenus;//all menus	

	public ArrayList getAllMenus() {
		return allMenus;
	}

	public void setAllMenus(ArrayList allMenus) {
		this.allMenus = allMenus;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateOperId() {
		return createOperId;
	}

	public void setCreateOperId(String createOperId) {
		this.createOperId = createOperId;
	}

	public IRoleBo getRoleBo() {
		return roleBo;
	}

	public void setRoleBo(IRoleBo roleBo) {
		this.roleBo = roleBo;
	}
	
	public String init() throws Exception {
		
		return Constants.INIT_KEY;
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return Constants.LIST_KEY;
	}

	@Override
	public String delete() throws Exception {
		String roleId = request.getParameter("roleId");
		log.debug("******roleId="+roleId);
		
		//1.先把属于该角色操作员的角色id置空
		ArrayList opers = operBo.findOpersByRoleId(roleId);
		if(null != opers && opers.size() > 0)
		{
			for (int i = 0; i < opers.size(); i++)
			{
				Operator oper = null;
				oper = (Operator) opers.get(i);
				oper.setRole(null);
				
				operBo.updateOperator(oper);
			}

		}
		//2.然后再删除该角色
		roleBo.delRole(roleId);
		return Constants.LIST_KEY;
	}

	@Override
	public String edit() throws Exception {
	
		Role role = null;
		role = roleBo.getRole(this.roleId);
		this.roleName = role.getRoleName();
		this.description = role.getDescription();
		this.createTime = role.getCreateTime();
//		this.createOperId = role.getCreateOperId();
//		//all menus
//		this.allMenus = operBo.getAllMenus();
//		
//		//find owned menus
//		Iterator selectedM = role.getPrivleges().iterator();
//		
//		ArrayList available = this.allMenus;
//		ArrayList ownedM = new ArrayList();
//		while(selectedM.hasNext())
//		{
//			Menu m = (Menu)selectedM.next();
//			ownedM.add(m);
//			available.remove(m);
//		}
//
//		log.debug("******available menus:"+available.size());
//		log.debug("******ownedM menus:"+ownedM.size());
//		request.setAttribute("available", available);
//		request.setAttribute("selectedM", ownedM);
		return "";
	}

	@Override
	public List findBeanList() throws Exception {
		
		List roleList = null;
		if ("".equals(this.roleName) || null == this.roleName)
		{
			roleList = roleBo.getRoles(0L);
		}
		else
		{
			roleList = new ArrayList();
			Role r = roleBo.getRoleByName(this.roleName);
			if(null != r)
			{
				roleList.add(r);
			}
		}
		return roleList;
	}

	@Override
	public String insert() throws Exception {
		
		HttpSession session = request.getSession(false);
		this.createOperId = (String) session.getAttribute(Constants.USERNAME_KEY);
		
//		Role role = new Role();
//		role.setRoleName(this.roleName);
//		role.setDescription(this.description);
//		role.setCreateTime(DateUtil.getCurrentTime());
//		role.setCreateOperId(this.createOperId);
//		try{
//			roleBo.addRole(role);
//		}catch(Exception e)
//		{
//			this.addActionError(this.getText("Error occured when add a Role."));
//			return Constants.ADD_KEY;
//		}
//		
//		this.addActionMessage(this.getText("change.message.addoredit.success"));		
		return Constants.LIST_KEY;
	}

	@Override
	public String update() throws Exception {
		Role role = null;		
//		role = roleBo.getRole(this.roleId);
//		role.setRoleName(this.roleName);
//		role.setDescription(this.description);
//		role.setCreateTime(this.createTime);
//		role.setCreateOperId(this.createOperId);
//		
//		Set menuSet = role.getPrivleges();
//		menuSet.clear();
//		
//		String menuIds = request.getParameter("menuIds");
//		if (!"".equals(menuIds))
//		{
//			String[] menus = menuIds.split(",");
//			for (int i = 0; i < menus.length; i++)
//			{
//				Menu m = operBo.getMenu(menus[i]);
//				menuSet.add(m);
//			}
//		}
//		//角色和权限关联
//		role.setPrivleges(menuSet);
//		
//		try{
//			roleBo.updateRole(role);
//		}catch(Exception e)
//		{
//			this.addActionError(this.getText("Error occured when edit a Role."));
//			return Constants.EDIT_KEY;
//		}
		return Constants.LIST_KEY;
	}

	public IOperatorBo getOperBo() {
		return operBo;
	}

	public void setOperBo(IOperatorBo operBo) {
		this.operBo = operBo;
	}
}

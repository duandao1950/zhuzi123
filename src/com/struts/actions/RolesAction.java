package com.struts.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import com.hibernate.beans.Privilege;
import com.hibernate.beans.RolePrivileges;
import com.hibernate.beans.Roles;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class RolesAction extends BaseAction {
	Logger log = Logger.getLogger(this.getClass());

	protected Integer roleId = null;
	protected String roleName = null;
	protected String description = null;
	protected Date createTime = null;
	protected String isValid = null;
	protected Roles roles = null;
	protected Privilege operPrivilege = null;
	protected List privilegeList = null;
	protected List parentPrivilegeList = null;

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
		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			this.addActionMessage(this.getText("roles.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// delete object
			baseHibernateBo.delete(Roles.class, new Integer(id));

			// save messages
			this.addActionMessage(this.getText("roles.message.delete.success"));
		}
		return Constants.OPERATOR_RESULT_KEY;
	}

	@Override
	public String edit() throws Exception {
		String id = request.getParameter("id");

		if (id == null || "".equals(id)) {
			// id not exist, save messages
			this.addActionError(this.getText("address.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// get object
			Roles roles = (Roles) baseHibernateBo.findById(Roles.class,
					new Integer(id));

			if (roles == null) {
				this.addActionError(this
						.getText("address.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.roles = roles;
		}
		return Constants.EDIT_KEY;
	}

	@Override
	public List findBeanList() throws Exception {
		// TODO Auto-generated method stub
		return baseHibernateBo.findAllOrderbyProperty(Roles.class,
				"orderNumber");
	}

	@Override
	public String insert() throws Exception {
		// insert object
		Roles roles = new Roles();
		roles.setOperId(super.operId);
		roles.setRoleName(roleName);
		roles.setIsValid(isValid);
		roles.setDescription(description);
		roles.setCreateTime(new Date());

		// save object
		baseHibernateBo.save(roles);
		// save messages
		this.addActionMessage(this.getText("change.message.addoredit.success"));
		return Constants.OPERATOR_RESULT_KEY;
	}

	@Override
	public String update() throws Exception {
		Roles roles = new Roles();
		roles.setRoleId(roleId);
		roles.setOperId(super.operId);
		roles.setRoleName(roleName);
		roles.setIsValid(isValid);
		roles.setDescription(description);
		roles.setCreateTime(new Date());

		// update object
		baseHibernateBo.saveOrUpdate(roles);

		// save messages
		this.addActionMessage(this.getText("roles.message.edit.success"));

		return Constants.OPERATOR_RESULT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String rolesPrivilegeRelationEdit() throws Exception {
		String id = request.getParameter("id");

		if (id == null || "".equals(id)) {
			// id not exist, save messages
			this.addActionError(this.getText("address.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// get object
			Roles roles = (Roles) baseHibernateBo.findById(Roles.class,
					new Integer(id));

			if (roles == null) {
				this.addActionError(this
						.getText("address.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.roles = roles;
		}

		//获得所有父类菜单
		List<Privilege> parentPrivilegeList = baseHibernateBo
				.findPartOrderByProperty(Privilege.class, "privilegeLevel",
						"orderNumber", "0");
		//根据父类菜单获得所有子类菜单
		ArrayList<List<Privilege>> privilegeLevelList = new ArrayList<List<Privilege>>();
		for (Privilege parentPrivilege : parentPrivilegeList) {
			List<Privilege> childrenPrivilegeList = baseSpringBo
					.getPartPrivilegesByParentId(parentPrivilege.getPorder());
			privilegeLevelList.add(childrenPrivilegeList);
		}

		request.setAttribute("privilegeLevelList", privilegeLevelList);
		
		List rolePrivilegeList = baseSpringBo
				.getPrivilegesByRoleId(new Integer(id));
		List<Privilege> allPrivilegeList = baseHibernateBo
				.findAllOrderbyProperty(Privilege.class, "orderNumber");
		request.setAttribute("rolePrivilegeList", rolePrivilegeList);
		request.setAttribute("allPrivilegeList", allPrivilegeList);
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String rolesPrivilegeRelationUpdate() throws Exception {
		// 获得用户已有角色
		List rolePrivilegeList = baseSpringBo
				.getPrivilegesByRoleId(this.roleId);
		// 新增角色和已有角色对比,得到用户此次操作失去的角色和新增的角色,建立操作员与角色的关系
		if (privilegeList != null && privilegeList.size() > 0) {
			//首先添加父类的菜单
			privilegeList.addAll(parentPrivilegeList);
			List operRolesRelation = (List) CollectionUtils.intersection(
					rolePrivilegeList, privilegeList);
			privilegeList.removeAll(operRolesRelation);
			rolePrivilegeList.removeAll(operRolesRelation);
			for (int i = 0; i < privilegeList.size(); i++) {
				RolePrivileges rolePrivileges = new RolePrivileges();
				rolePrivileges.setRoleId(this.roleId);
				rolePrivileges.setPrivilegeId(privilegeList.get(i).toString());
				baseHibernateBo.save(rolePrivileges);
			}
		}

		for (int i = 0; i < rolePrivilegeList.size(); i++) {
			baseSpringBo.deleteRolePrivilegesRelation(this.roleId,
					rolePrivilegeList.get(i).toString());
		}
		return Constants.LIST_KEY;
	}

	public Object getModel() {
		roles = new Roles();
		return roles;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Privilege getOperPrivilege() {
		return operPrivilege;
	}

	public void setOperPrivilege(Privilege operPrivilege) {
		this.operPrivilege = operPrivilege;
	}

	public List getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List privilegeList) {
		this.privilegeList = privilegeList;
	}

	public List getParentPrivilegeList() {
		return parentPrivilegeList;
	}

	public void setParentPrivilegeList(List parentPrivilegeList) {
		this.parentPrivilegeList = parentPrivilegeList;
	}
}

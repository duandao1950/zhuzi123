package com.struts.actions;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.hibernate.beans.Privilege;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class PrivilegeAction extends BaseAction {
	Logger log = Logger.getLogger(this.getClass());

	private String privilegeId = null;
	
	private String privilegeName = null;
	
	private String description = null;
	
	private String porder = null;
	
	private String parentPorder = null;
	
	private String url = null;
	
	private String privilegeLevel = null;
	
	private Integer orderNumber = null;
	
	private Privilege privilege = null;

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
			this.addActionMessage(this.getText("privilege.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// delete object
			baseHibernateBo.delete(Privilege.class, id);

			// save messages
			this.addActionMessage(this.getText("privilege.message.delete.success"));
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
			Privilege privilege = (Privilege) baseHibernateBo.findById(Privilege.class,id);

			if (privilege == null) {
				this.addActionError(this
						.getText("address.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.privilege = privilege;
		}
		return Constants.EDIT_KEY;
	}

	@Override
	public List findBeanList() throws Exception {
		// TODO Auto-generated method stub
		return baseHibernateBo.findAllOrderbyProperty(Privilege.class,
				"orderNumber");
	}

	@Override
	public String insert() throws Exception {
		// insert object
		Privilege privilege = new Privilege();
		privilege.setPrivilegeId(privilegeId);
		privilege.setPrivilegeName(privilegeName);
		privilege.setUrl(url);
		privilege.setPorder(porder);
		privilege.setParentPorder(parentPorder);
		privilege.setPrivilegeLevel(privilegeLevel);
		privilege.setOrderNumber(orderNumber);
		privilege.setDescription(description);

		// save object
		baseHibernateBo.save(privilege);
		// save messages
		this.addActionMessage(this.getText("change.message.addoredit.success"));
		return Constants.OPERATOR_RESULT_KEY;
	}

	@Override
	public String update() throws Exception {
		Privilege privilege = new Privilege();
		privilege.setPrivilegeId(privilegeId);
		privilege.setPrivilegeName(privilegeName);
		privilege.setUrl(url);
		privilege.setPorder(porder);
		privilege.setParentPorder(parentPorder);
		privilege.setPrivilegeLevel(privilegeLevel);
		privilege.setOrderNumber(orderNumber);
		privilege.setDescription(description);

		// update object
		baseHibernateBo.saveOrUpdate(privilege);

		// save messages
		this.addActionMessage(this.getText("privilege.message.edit.success"));

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
			Privilege privilege = (Privilege) baseHibernateBo.findById(Privilege.class,
					new Integer(id));

			if (privilege == null) {
				this.addActionError(this
						.getText("address.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.privilege = privilege;
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

	public Object getModel() {
		privilege = new Privilege();
		return privilege;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public String getParentPorder() {
		return parentPorder;
	}

	public void setParentPorder(String parentPorder) {
		this.parentPorder = parentPorder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrivilegeLevel() {
		return privilegeLevel;
	}

	public void setPrivilegeLevel(String privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
}

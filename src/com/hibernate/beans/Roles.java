package com.hibernate.beans;

import java.util.Date;
import java.util.Set;

public class Roles {
	private Integer roleId;
	private String roleName;
	private String description;
	private Date createTime;
	private String isValid;
	private String operId;
	private Integer orderNumber;
	private Privilege operPrivilege;
	private Set<Privilege> operPrivilegeSet;
	private Set<Operators> operatorsSet;
	
	public Roles() {

	}

	public Roles(Integer roleId) {
		this.roleId = roleId;
	}

	public Roles(Integer roleId, String roleName, String description,
			Date createTime,String isValid, String operId) {
		this.roleId = roleId;
		this.description = description;
		this.createTime = createTime;
		this.isValid = isValid;
		this.operId = operId;
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

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Privilege getOperPrivilege() {
		return operPrivilege;
	}

	public void setOperPrivilege(Privilege operPrivilege) {
		this.operPrivilege = operPrivilege;
	}

	public Set<Privilege> getOperPrivilegeSet() {
		return operPrivilegeSet;
	}

	public void setOperPrivilegeSet(Set<Privilege> operPrivilegeSet) {
		this.operPrivilegeSet = operPrivilegeSet;
	}

	public Set<Operators> getOperatorsSet() {
		return operatorsSet;
	}

	public void setOperatorsSet(Set<Operators> operatorsSet) {
		this.operatorsSet = operatorsSet;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
}

package com.hibernate.beans;

import java.util.Set;

public class OperatorRoles {
	private Integer operRoleId;
	private String operId;
	private Integer roleId;
	private Set<Roles> roleSet;
	
	public Integer getOperRoleId() {
		return operRoleId;
	}
	public void setOperRoleId(Integer operRoleId) {
		this.operRoleId = operRoleId;
	}

	public Set<Roles> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Roles> roleSet) {
		this.roleSet = roleSet;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}

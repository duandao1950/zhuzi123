package com.hibernate.beans;

import java.util.Set;

public class RolePrivileges {
	private Integer operPrivsId;
	private Integer roleId;
	private String privilegeId;
	private Set<Roles> rolesSet;
	private Set<Privilege> operPrivilegeSet;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getOperPrivsId() {
		return operPrivsId;
	}
	public void setOperPrivsId(Integer operPrivsId) {
		this.operPrivsId = operPrivsId;
	}
	public Set<Roles> getRolesSet() {
		return rolesSet;
	}
	public void setRolesSet(Set<Roles> rolesSet) {
		this.rolesSet = rolesSet;
	}
	public Set<Privilege> getOperPrivilegeSet() {
		return operPrivilegeSet;
	}
	public void setOperPrivilegeSet(Set<Privilege> operPrivilegeSet) {
		this.operPrivilegeSet = operPrivilegeSet;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
}

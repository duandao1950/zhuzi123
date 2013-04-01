package com.hibernate.beans;

import java.io.Serializable;
import java.util.Set;

public class Menu extends AbstractCommonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2007529918267045632L;

	public Menu(){}
	
	private String privilegeId;
	private String privilegeName;
	private String description;
	private String privilegeOrder;
	private String parentPOrder;
	private String Url;
	private Set roles;
	
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
	public String getParentPOrder() {
		return parentPOrder;
	}
	public void setParentPOrder(String parentPOrder) {
		this.parentPOrder = parentPOrder;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getPrivilegeOrder() {
		return privilegeOrder;
	}
	public void setPrivilegeOrder(String privilegeOrder) {
		this.privilegeOrder = privilegeOrder;
	}
	public Set getRoles() {
		return roles;
	}
	public void setRoles(Set roles) {
		this.roles = roles;
	}		
}

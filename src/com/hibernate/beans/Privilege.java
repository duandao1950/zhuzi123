/*
 * Created Thu Aug 23 15:30:25 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.util.Set;

/**
 * A class that represents a row in the 'OPER_PRIVILEGE' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Privilege
{
	private static final long serialVersionUID = -884436909205017326L;

	private String privilegeId;
	
	private String privilegeName;
	
	private String description;
	
	private String porder;
	
	private String parentPorder;
	
	private String url;
	
	private String privilegeLevel;
	
	private Integer orderNumber;
	
	private Set<Roles> rolesSet;
    
	/**
     * Simple constructor of Address instances.
     */
    public Privilege()
    {
    	
    }
    
    /**
     * Constructor of AbstractAddress instances given a simple primary key.
     * @param id
     */
    public Privilege(java.lang.String privilegeId)
    {
        this.setPrivilegeId(privilegeId);
    }

    public Privilege(String privilegeId, String privilegeName, String description,
			String porder, String parentPorder, String url) {
		this.setPrivilegeId(privilegeId);
		this.setPrivilegeName(privilegeName);
		this.setDescription(description);
		this.setPorder(porder);
		this.setParentPorder(parentPorder);
		this.setUrl(url);
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

	public Set<Roles> getRolesSet() {
		return rolesSet;
	}

	public void setRolesSet(Set<Roles> rolesSet) {
		this.rolesSet = rolesSet;
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

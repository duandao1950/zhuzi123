package com.hibernate.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class Role extends AbstractCommonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7407785405498667694L;
	private Integer id;
	private String roleId;
	private String roleName;
	private String description;
	private Timestamp createTime;
	private Set<String> permissions;
	
	public Role(){
		
	}
	
	public Role(Integer id) {
		this.id = id;
	}
	
	public Role(Integer id,String roleId,String roleName,String description,Timestamp createTime) {
		this.id = id;
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
		
}

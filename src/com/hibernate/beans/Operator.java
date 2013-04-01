package com.hibernate.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Operator extends AbstractCommonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3269456981506118736L;

	public Operator() {	}

	private String operId;
	private String operName;
	private String valid;
	private String password;
	private Timestamp loginTime;
	private Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operId == null) ? 0 : operId.hashCode());
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
		final Operator other = (Operator) obj;
		if (operId == null) {
			if (other.operId != null)
				return false;
		} else if (!operId.equals(other.operId))
			return false;
		return true;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}

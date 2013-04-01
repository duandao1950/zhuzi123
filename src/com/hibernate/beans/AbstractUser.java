/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Tue Aug 14 18:57:22 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the user table. 
 * You can customize the behavior of this class by editing the class, {@link User()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractUser extends AbstractCommonBean implements Serializable {
	/** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
	private int hashValue = 0;

	/** The composite primary key value. */
	private java.lang.Integer id;
	
	/** The value of the simple name property. */
	private java.lang.String name;
	
	/** The value of the simple username property. */
	private java.lang.String userName;

	/** The value of the simple password property. */
	private java.lang.String password;

	/** The value of the simple email property. */
	private java.lang.String email;
	
	/** The value of the simple otheruser property. */
	private java.lang.String otherUser;

	/** The value of the simple registerTime property. */
    private java.util.Date registerTime;

    /** The value of the simple cancelDate property. */
    private java.util.Date cancelTime;
    
    private boolean isValid;
    
	/**
	 * Simple constructor of AbstractUser instances.
	 */
	public AbstractUser() {
	}

	/**
	 * Constructor of AbstractUser instances given a simple primary key.
	 * @param id
	 */
	public AbstractUser(java.lang.Integer id) {
		this.setId(id);
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	/**
	 * Return the simple primary key value that identifies this object.
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the simple primary key value that identifies this object.
	 * @param id
	 */
	public void setId(java.lang.Integer id) {
		this.hashValue = 0;
		this.id = id;
	}

	/**
	 * Return the value of the username column.
	 * @return java.lang.String
	 */
	public java.lang.String getUserName() {
		return this.userName;
	}

	/**
	 * Set the value of the username column.
	 * @param username
	 */
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	/**
	 * Return the value of the password column.
	 * @return java.lang.String
	 */
	public java.lang.String getPassword() {
		return this.password;
	}

	/**
	 * Set the value of the password column.
	 * @param password
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	/**
	 * Return the value of the email column.
	 * @return java.lang.String
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * Set the value of the email column.
	 * @param email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	public java.lang.String getOtherUser() {
		return otherUser;
	}

	public void setOtherUser(java.lang.String otherUser) {
		this.otherUser = otherUser;
	}

	public java.util.Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}

	public java.util.Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(java.util.Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/**
	 * Implementation of the equals comparison on the basis of equality of the primary key values.
	 * @param rhs
	 * @return boolean
	 */
	public boolean equals(Object rhs) {
		if (rhs == null)
			return false;
		if (!(rhs instanceof User))
			return false;
		User that = (User) rhs;
		if (this.getId() == null || that.getId() == null)
			return false;
		return (this.getId().equals(that.getId()));
	}

	/**
	 * Implementation of the hashCode method conforming to the Bloch pattern with
	 * the exception of array properties (these are very unlikely primary key types).
	 * @return int
	 */
	public int hashCode() {
		if (this.hashValue == 0) {
			int result = 17;
			int idValue = this.getId() == null ? 0 : this.getId().hashCode();
			result = result * 37 + idValue;
			this.hashValue = result;
		}
		return this.hashValue;
	}
}

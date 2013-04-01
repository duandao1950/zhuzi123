package com.hibernate.beans;
// default package

import java.sql.Timestamp;


/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userId;
     private String roleId;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public UserRole() {
    }

	/** minimal constructor */
    public UserRole(Integer id, String userId, String roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }
    
    /** full constructor */
    public UserRole(Integer id, String userId, String roleId, Timestamp createTime) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
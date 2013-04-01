package com.hibernate.beans;
// default package



/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String roleId;
     private String permissionId;
     private String rolePermissionNote;


    // Constructors

    /** default constructor */
    public RolePermission() {
    }

	/** minimal constructor */
    public RolePermission(Integer id, String roleId, String permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
    
    /** full constructor */
    public RolePermission(Integer id, String roleId, String permissionId, String rolePermissionNote) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.rolePermissionNote = rolePermissionNote;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRolePermissionNote() {
        return this.rolePermissionNote;
    }
    
    public void setRolePermissionNote(String rolePermissionNote) {
        this.rolePermissionNote = rolePermissionNote;
    }
   








}
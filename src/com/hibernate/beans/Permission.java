package com.hibernate.beans;
// default package



/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String permissionId;
     private String permissionName;
     private String permissionNote;


    // Constructors

    /** default constructor */
    public Permission() {
    }

	/** minimal constructor */
    public Permission(Integer id, String permissionId) {
        this.id = id;
        this.permissionId = permissionId;
    }
    
    /** full constructor */
    public Permission(Integer id, String permissionId, String permissionName, String permissionNote) {
        this.id = id;
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionNote = permissionNote;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return this.permissionName;
    }
    
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionNote() {
        return this.permissionNote;
    }
    
    public void setPermissionNote(String permissionNote) {
        this.permissionNote = permissionNote;
    }
   








}
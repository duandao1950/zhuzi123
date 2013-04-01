package com.hibernate.beans;
// default package

import java.sql.Timestamp;


/**
 * Author entity. @author MyEclipse Persistence Tools
 */

public class Author  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String periodId;
     private String authorName;
     private String namePying;
     private Timestamp birth;
     private Timestamp death;
     private Integer isValid;


    // Constructors

    /** default constructor */
    public Author() {
    }
    
	/** minimal constructor */
    public Author(Integer id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }
    
    /** minimal constructor */
    public Author(String authorName) {
        this.authorName = authorName;
    }
    
    /** full constructor */
    public Author(Integer id, String periodId, String authorName, String namePying, Timestamp birth, Timestamp death, Integer isValid) {
        this.id = id;
        this.periodId = periodId;
        this.authorName = authorName;
        this.namePying = namePying;
        this.birth = birth;
        this.death = death;
        this.isValid = isValid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodId() {
        return this.periodId;
    }
    
    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getAuthorName() {
        return this.authorName;
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNamePying() {
        return this.namePying;
    }
    
    public void setNamePying(String namePying) {
        this.namePying = namePying;
    }

    public Timestamp getBirth() {
        return this.birth;
    }
    
    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public Timestamp getDeath() {
        return this.death;
    }
    
    public void setDeath(Timestamp death) {
        this.death = death;
    }

    public Integer getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
   








}
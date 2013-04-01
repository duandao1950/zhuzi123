package com.hibernate.beans;
// default package

import java.sql.Timestamp;


/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article  implements java.io.Serializable {

    // Fields    

     private Integer id;
     private Integer styleId;
     private String title;
     private Integer authorId;
     private String content;
     private String contentExt;
     private Timestamp createTime;
     private Timestamp updateTime;


    // Constructors

    /** default constructor */
    public Article() {
    }

	/** minimal constructor */
    public Article(Integer id, Integer authorId, String content, Timestamp createTime) {
        this.id = id;
        this.authorId = authorId;
        this.content = content;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public Article(Integer id, Integer styleId, String title, Integer authorId, String content, String contentExt, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.styleId = styleId;
        this.title = title;
        this.authorId = authorId;
        this.content = content;
        this.contentExt = contentExt;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStyleId() {
        return this.styleId;
    }
    
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }
    
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getContentExt() {
        return this.contentExt;
    }
    
    public void setContentExt(String contentExt) {
        this.contentExt = contentExt;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
   








}
/*
 * Created Thu Aug 23 15:30:25 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.util.Date;
import com.common.util.assistant.ExcelAnnotation;

/**
 * A class that represents a row in the 'address' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Address
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -884436909205017326L;

	@ExcelAnnotation(exportName = "ID")
	/** The composite primary key value. */
    private java.lang.Integer id;

	@ExcelAnnotation(exportName = "User Name")
    /** The value of the simple username property. */
    private java.lang.String username;

	@ExcelAnnotation(exportName = "Name")
    /** The value of the simple name property. */
    private java.lang.String name;

	//@ExcelAnnotation(exportName = "Sex ID")
    /** The value of the simple sex property. */
    private java.lang.String sex;
	
	@ExcelAnnotation(exportName = "Sex")
    /** The value of the simple sex property. */
    private java.lang.String sexLabel;

	@ExcelAnnotation(exportName = "Mobile")
    /** The value of the simple mobile property. */
    private java.lang.String mobile;

	@ExcelAnnotation(exportName = "Email")
    /** The value of the simple email property. */
    private java.lang.String email;

	@ExcelAnnotation(exportName = "QQ")
    /** The value of the simple qq property. */
    private java.lang.String qq;

	@ExcelAnnotation(exportName = "Company")
    /** The value of the simple company property. */
    private java.lang.String company;

	@ExcelAnnotation(exportName = "Address")
    /** The value of the simple address property. */
    private java.lang.String address;

	@ExcelAnnotation(exportName = "Post Code")
    /** The value of the simple postcode property. */
    private java.lang.String postcode;
    
	@ExcelAnnotation(exportName = "Update Date")
    /** The value of the simple filepath property. */
    private java.util.Date updateDate;

	@ExcelAnnotation(exportName = "File Path")
    /** The value of the simple filepath property. */
    private java.lang.String filepath;
	
	//@ExcelAnnotation(exportName = "File Path")
    /** The value of the simple address property. */
    private java.lang.String filepathPreview;
    
    @ExcelAnnotation(exportName = "BBS")
    /** The value of the simple BBS property. */
    private java.lang.String bbs;
    
	@ExcelAnnotation(exportName = "BBSQQ")
    /** The value of the simple BBSQQ property. */
    private java.lang.String bbsqq;
    
	/**
     * Simple constructor of Address instances.
     */
    public Address()
    {
    	
    }

    /**
     * Constructor of Address instances given a simple primary key.
     * @param id
     */
    /*public Address(java.lang.Integer id)
    {
        super(id);
    }

     Add customized code below 
    public Address(Integer id, String username, String name,
			String sex, String mobile, String email, String qq, String company,
			String address, String postcode,Date updateDate,String filepath) {
    	super(id, username, name, sex, mobile, email, qq, company, address, postcode,updateDate,filepath);
	}*/

    /**
     * Constructor of AbstractAddress instances given a simple primary key.
     * @param id
     */
    public Address(java.lang.Integer id)
    {
        this.setId(id);
    }

    public Address(Integer id, String username, String name,
			String sex,String sexLabel, String mobile, String email, String qq, String company,
			String address, String postcode,Date updateDate,String filepath,String bbs,String bbsqq) {
		this.setId(id);
		this.setUsername(username);
		this.setName(name);
		this.setSex(sex);
		this.setSexLabel(sexLabel);
		this.setMobile(mobile);
		this.setEmail(email);
		this.setQq(qq);
		this.setCompany(company);
		this.setAddress(address);
		this.setPostcode(postcode);
		this.setUpdateDate(updateDate);
		this.setFilepath(filepath);
		this.setBbs(bbsqq);
		this.setBbsqq(bbsqq);
	}
    
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getQq() {
		return qq;
	}

	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}

	public java.lang.String getCompany() {
		return company;
	}

	public void setCompany(java.lang.String company) {
		this.company = company;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getPostcode() {
		return postcode;
	}

	public void setPostcode(java.lang.String postcode) {
		this.postcode = postcode;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.String getFilepath() {
		return filepath;
	}

	public void setFilepath(java.lang.String filepath) {
		this.filepath = filepath;
	}

	public java.lang.String getSexLabel() {
		return sexLabel;
	}

	public void setSexLabel(java.lang.String sexLabel) {
		this.sexLabel = sexLabel;
	}

	public java.lang.String getFilepathPreview() {
		return filepathPreview;
	}

	public void setFilepathPreview(java.lang.String filepathPreview) {
		this.filepathPreview = filepathPreview;
	}
	
	public java.lang.String getBbs() {
		return bbs;
	}

	public void setBbs(java.lang.String bbs) {
		this.bbs = bbs;
	}

	public java.lang.String getBbsqq() {
		return bbsqq;
	}

	public void setBbsqq(java.lang.String bbsqq) {
		this.bbsqq = bbsqq;
	}
}

package com.hibernate.beans;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbstractDicKey entity provides the base persistence definition of the DicKey
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractDicKey implements java.io.Serializable {

	// Fields

	private String id;
	private String tableName;
	private String key;
	private Date effDate;
	private Date expDate;
	private String ordernumber;

	// Constructors

	/** default constructor */
	public AbstractDicKey() {
	}

	/** minimal constructor */
	public AbstractDicKey(String id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractDicKey(String id,String tableName, String key, Date effDate, Date expDate,
			String ordernumber) {
		this.id = id;
		this.tableName = tableName;
		this.key = key;
		this.effDate = effDate;
		this.expDate = expDate;
		this.ordernumber = ordernumber;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false, length = 45)),
			@AttributeOverride(name = "tableName", column = @Column(name = "table_name", nullable = false, length = 45)) })
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "key", length = 45)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFF_DATE", length = 10)
	public Date getEffDate() {
		return this.effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DATE", length = 10)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Column(name = "ORDERNUMBER", length = 45)
	public String getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
package com.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractDicValue entity provides the base persistence definition of the
 * DicValue entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractDicValue implements java.io.Serializable {

	// Fields

	private String id;
	private String tableName;
	private String value;
	private String valueAddi;
	private String language;

	// Constructors

	/** default constructor */
	public AbstractDicValue() {
	}

	/** minimal constructor */
	public AbstractDicValue(String id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractDicValue(String id, String tableName, String value,
			String valueAddi, String language) {
		this.id = id;
		this.tableName = tableName;
		this.value = value;
		this.valueAddi = valueAddi;
		this.language = language;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 45)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "table_name", length = 45)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "value", length = 45)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "value_addi", length = 45)
	public String getValueAddi() {
		return this.valueAddi;
	}

	public void setValueAddi(String valueAddi) {
		this.valueAddi = valueAddi;
	}

	@Column(name = "language", length = 45)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
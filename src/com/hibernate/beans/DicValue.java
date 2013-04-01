package com.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DicValue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dic_value", catalog = "zhuzi123")
public class DicValue extends AbstractDicValue implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public DicValue() {
	}

	/** minimal constructor */
	public DicValue(String id) {
		super(id);
	}

	/** full constructor */
	public DicValue(String id, String tableName, String value,
			String valueAddi, String language) {
		super(id, tableName, value, valueAddi, language);
	}

}

package com.hibernate.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DicKey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dic_key", catalog = "zhuzi123")
public class DicKey extends AbstractDicKey implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public DicKey() {
	}

	/** minimal constructor */
	public DicKey(String id) {
		super(id);
	}

	/** full constructor */
	public DicKey(String id,String tableName, String key, Date effDate, Date expDate,
			String ordernumber) {
		super(id,tableName, key, effDate, expDate, ordernumber);
	}

}

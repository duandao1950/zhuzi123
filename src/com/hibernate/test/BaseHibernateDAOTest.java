package com.hibernate.test;



import java.sql.Timestamp;
import java.util.Date;

import com.hibernate.beans.Address;
import com.hibernate.beans.Article;
import com.hibernate.beans.Author;
import com.hibernate.beans.DicKey;
import com.hibernate.beans.DicValue;
import com.hibernate.beans.Operators;
import com.hibernate.beans.User;
import com.hibernate.test.itest.IBaseDAOTest;

public class BaseHibernateDAOTest extends BaseDAOTest implements IBaseDAOTest{
    
	//User oo = new User();
	//Address oo = new Address();
	//Operators oo = new Operators();
	//Author oo = new Author();
	Article oo = new Article();
	public BaseHibernateDAOTest(String name) {
		super(name);
	}

	public void testDelete() throws Exception {
	//	super.testDelete(oo, "3");
	}

	public void testFindAllByName() throws Exception {
	//	super.testFindAllByName(oo);
	}

	public void testFindById() throws Exception {
	//	super.testFindById(oo, "1");
	}

	public void testInsert() throws Exception {
	//	Timestamp time = Timestamp.valueOf("2010-10-07 14:30:30"); 
//		oo.setAuthorName("sss");
//		oo.setPeriodId("111");
//		oo.setBirth(time);
//		oo.setDeath(time);
//		oo.setIsValid(1);
		super.testInsert(oo);
	}

	public void testUpdate() throws Exception {
	//	super.testUpdate(oo, "2","id");
	}

	public void testFindBySQLMap() throws Exception {
		//super.testFindBySQLMap(oo,"select_users","id","1");
		DicKey oo = new DicKey();
		//super.testFindBySQLMap(oo,"select_dic_key","id","S0001");
		
		DicValue oo1 = new DicValue();
		//super.testFindBySQLMap(oo1,"select_dic_value","id","INS0001");
	}
	
	public void testFindBySQLMap1() throws Exception {
		//super.testFindBySQLMap(oo,"select_users_name","id","1");
	}
	
	public void testFindBySQLMap2() throws Exception {
		//super.testFindBySQLMapDic("select_dic_key_value","id","S0001");
	}
}

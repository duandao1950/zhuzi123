package com.hibernate.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.hibernate.beans.Address;
import com.hibernate.dao.AddressDAO;
import com.hibernate.dao.idao.IBaseHibernateDAO;

import junit.framework.TestCase;

public class AddressDAOTest extends TestCase {

	public IBaseHibernateDAO addressDAO;

	public AddressDAOTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		addressDAO = (IBaseHibernateDAO) new AddressDAO();
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/classes/config/spring/applicationContext.xml");
		addressDAO = (IBaseHibernateDAO) ctx.getBean("addressDAO");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindAllByUsername() throws Exception {
		List list = addressDAO.findAllByUsername(Address.class,"admin");
		assertTrue(list.size() != 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Address address = (Address) it.next();
			assertNotNull(address);
		}
	}

	public void testFindById() throws Exception {
		Address address = (Address) addressDAO.findById(Address.class,Integer.valueOf("1"));
		assertNotNull(address);
	}

	public void testIsExist() throws Exception {
		boolean b = addressDAO.isExist(Address.class,"admin", "andy");
		assertTrue(b);
	}

	public void testInsert() throws Exception {
		Address address = new Address();
		address.setUsername("admin");
		address.setName("andy");
		address.setSex("2");
		address.setMobile("13888886666");
		address.setEmail("andy@163.com");
		address.setQq("12345678");
		address.setCompany("Intel");
		address.setAddress("上海市");
		address.setPostcode("200089");
		address.setBbs("TianYa");
		address.setBbsqq("10086");
		address.setUpdateDate(new Date());
		addressDAO.save(address);

		address = (Address) addressDAO.findById(Address.class,Integer.valueOf("5"));
		assertNotNull(address);
	}

	public void testUpdate() throws Exception {
		Address address = new Address();
		address.setId(new Integer(5));
		address.setUsername("admin");
		address.setName("andy");
		address.setSex("2");
		address.setMobile("13888886666");
		address.setEmail("andy@163.com");
		address.setQq("12345678");
		address.setCompany("Microsoft");
		address.setAddress("上海市");
		address.setPostcode("200089");
		address.setBbs("HuaSheng");
		address.setBbsqq("12580");
		addressDAO.saveOrUpdate(address);

		Address address2 = (Address) addressDAO.findById(Address.class,Integer.valueOf("5"));
		assertTrue(address2.getCompany().equals("Microsoft"));
	}

	public void testDelete() throws Exception {
		Address address = (Address) addressDAO.findById(Address.class,Integer.valueOf("7"));
		
		if (address != null){
			addressDAO.delete(Address.class,Integer.valueOf("7"));
		}
		
		address = (Address) addressDAO.findById(Address.class,Integer.valueOf("7"));
		assertNull(address);
	}
}

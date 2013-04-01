package com.hibernate.test;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.hibernate.beans.User;
import com.hibernate.dao.idao.IBaseHibernateDAO;
import com.struts.util.Utils;

import junit.framework.TestCase;

public class BaseDAOTest<T, ID extends Serializable> extends TestCase{

	public IBaseHibernateDAO baseHibernateDAO;

	public BaseDAOTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/classes/config/spring/applicationContext.xml");
		baseHibernateDAO = (IBaseHibernateDAO) ctx.getBean("baseHibernateDAO");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindAllByName(T entity) throws Exception {
		boolean login = baseHibernateDAO.isValid(entity.getClass(), "admin", "admin");
		assertTrue(login);
	}

	public void testFindById(T entity,ID id) throws Exception {
		T t = (T) baseHibernateDAO.findById(entity.getClass(), Integer.valueOf(id.toString()));
		assertNotNull(t);
	}

	public void testInsert(T entity) throws Exception {
		Utils.fillObject(entity);
		baseHibernateDAO.save(entity);
		
		entity = (T) baseHibernateDAO.findByExample(entity);
		assertNotNull(entity);
	}

	public void testUpdate(T entity,ID id,String key) throws Exception {
		Utils.fillObject(entity,true,key);
		baseHibernateDAO.saveOrUpdate(entity);

		T t = (T) baseHibernateDAO.findById(entity.getClass(),Integer.valueOf(id.toString()));
		assertNotNull(t);
	}

	public void testDelete(T entity,ID id) throws Exception {
		T t = (T) baseHibernateDAO.findById(entity.getClass(),Integer.valueOf(id.toString()));
		
		if (t != null){
			baseHibernateDAO.delete(entity.getClass(),Integer.valueOf(id.toString()));
		}
		
		entity = (T) baseHibernateDAO.findById(entity.getClass(),Integer.valueOf(id.toString()));
		assertNull(entity);
	}
	
	public void testFindBySQLMap(T entity,String param,String name,String value) throws Exception {
		List<T> list = baseHibernateDAO.findBySQLMap(param,name,value);
		assertNotNull(list);
	}
	
	public void testFindBySQLMapDic(String id,String tableName) throws Exception {
		List list = baseHibernateDAO.findBySQLMapDic(id, tableName);
		assertNotNull(list);
	}
}

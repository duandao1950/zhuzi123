package com.hibernate.bo.ibo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
@SuppressWarnings("unchecked")
public interface IBaseHibernateBo<T, ID extends Serializable>{
	public boolean isValid(final Class<T> entityClass,final String username, final String password) throws Exception;
	
	public void save(T entity) throws Exception;

	public void delete(T entity) throws Exception;
	
	public void delete(Class<T> entityClass,ID id) throws Exception;

	public List<T> findAll(Class<T> entityClass);

	public void saveOrUpdate(T entity) throws Exception;

	public T findById(Class<T> entityClass, ID id) throws Exception;
	
	public T load(Class<T> entityClass, ID id) throws Exception;

	public List<T> find(String hql, Object... values);

	public T findUnique(String hql,Object... values);

	public int findInt(String hql,Object... values);

	public int findTotalCount(Class<T> entityClass, String where,
			final Object... values);

	public int findTotalCount(Class<T> entityClass);

	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value);

	public List<T> findByExample(T entity) throws Exception;

	public T merge(T entity) throws Exception;

	public void attachClean(T entity) throws Exception;

	public Query createQuery(Session session, String hql, Object... objects);
	
	public List findAllByUsername(final Class<T> entityClass,final String username) throws Exception;

	public boolean isExist(final Class<T> entityClass,final String username, final String name) throws Exception;
	
	public boolean isExist(final Class<T> entityClass, final String name) throws RuntimeException;
	
	public String findSequence(String sequence) throws Exception;
	
	public boolean checkExist(Class<T> entityClass, String propertyName,
			Object value) throws Exception;
	
	public List findRelationList(String sql) throws Exception;
	
	public List<T> findAllOrderbyProperty(Class<T> entityClass,String propertyName) throws Exception;
	
	public List<T> findPartOrderByProperty(Class<T> entityClass,
			String propertyName, String orderByProperty, Object value) throws Exception;
	
	public List<T> findBySQLMap(final String param,final String name,final String value) throws Exception;
}

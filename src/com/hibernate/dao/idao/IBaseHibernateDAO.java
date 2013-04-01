package com.hibernate.dao.idao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


@SuppressWarnings("unchecked")
public interface IBaseHibernateDAO<T, ID extends Serializable> {
	public boolean isValid(final Class<T> entityClass,final String username, final String password) throws Exception;
	
	public void save(T entity) throws RuntimeException;

	public void delete(T entity) throws RuntimeException;

	public void delete(Class<T> entityClass, ID id) throws RuntimeException;

	public List<T> findAll(Class<T> entityClass) throws RuntimeException;

	public void saveOrUpdate(T entity) throws RuntimeException;

	public T findById(Class<T> entityClass, ID id) throws RuntimeException;

	public T load(Class<T> entityClass, ID id) throws RuntimeException;

	public List<T> find(String hql, Object... values) throws RuntimeException;

	public T findUnique(String hql, Object... values) throws RuntimeException;

	public int findInt(String hql, Object... values) throws RuntimeException;

	public int findTotalCount(Class<T> entityClass, String where,
			final Object... values) throws RuntimeException;

	public int findTotalCount(Class<T> entityClass) throws RuntimeException;

	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) throws RuntimeException;

	public List<T> findByExample(T entity) throws RuntimeException;

	public T merge(T entity) throws RuntimeException;

	public void attachClean(T entity) throws RuntimeException;

	public Query createQuery(Session session, String hql, Object... objects) throws RuntimeException;

	public List findAllByUsername(final Class<T> entityClass,
			final String username) throws RuntimeException;

	public boolean isExist(final Class<T> entityClass, final String name) throws RuntimeException;
	
	public boolean isExist(final Class<T> entityClass, final String username,
			final String name) throws RuntimeException;
	
	public String findSequence(String sequence) throws RuntimeException;

	public boolean checkExist(Class<T> entityClass, String propertyName,
			Object value) throws RuntimeException;
	
	public List findRelationList(String sql) throws RuntimeException;
	
	public List<T> findAllOrderbyProperty(Class<T> entityClass,String propertyName) throws RuntimeException;
	
	public List<T> findPartOrderByProperty(Class<T> entityClass,
			String propertyName, String orderByProperty, Object value) throws RuntimeException;
	
	public List<T> findBySQLMap(final String param,final String name,final String value) throws RuntimeException;
	
	public List<T> findBySQLMapDic(final String id,final String tableName) throws RuntimeException;
}

package com.hibernate.bo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import com.hibernate.bo.ibo.IBaseHibernateBo;
import com.hibernate.dao.BaseHibernateDAO;

@SuppressWarnings("unchecked")
public class BaseHibernateBo<T, ID extends Serializable> implements
		IBaseHibernateBo<T, ID> {

	private static final Logger log = Logger.getLogger(BaseHibernateBo.class);

	private BaseHibernateDAO baseHibernateDAO;

	public BaseHibernateDAO getBaseHibernateDAO() {
		return baseHibernateDAO;
	}

	public void setBaseHibernateDAO(BaseHibernateDAO baseHibernateDAO) {
		this.baseHibernateDAO = baseHibernateDAO;
	}

	/**
	 * ���ʵ�������״<br>
	 * ����δ��
	 * 
	 * @param entity
	 *            ʵ��
	 */
	public void attachClean(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.attachClean(entity);
	}

	/**
	 * ���ݲ�ѯ����������б���Query����
	 * 
	 * @param session
	 *            Hibernate�Ự
	 * @param hql
	 *            HQL���
	 * @param objects
	 *            �����б�
	 * @return Query����
	 */
	public Query createQuery(Session session, String hql, Object... objects) {
		return baseHibernateDAO.createQuery(session, hql, objects);
	}

	/**
	 * ɾ��ָ��ʵ��
	 * 
	 * @param entityobj
	 *            ʵ��
	 */
	public void delete(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.delete(entity);
	}

	/**
	 * ɾ��ָ��ʵ��
	 * 
	 * @param entityobj
	 *            ʵ��
	 */
	public void delete(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		baseHibernateDAO.delete(entityClass, id);
	}

	/**
	 * ��ѯָ��HQL�������ؼ���
	 * 
	 * @param hql
	 *            HQL���
	 * @param values
	 *            �ɱ�Ĳ�����
	 * @return ����
	 */
	public List<T> find(String hql, Object... values) {
		return baseHibernateDAO.find(hql, values);
	}

	/**
	 * ��ȡ��ʵ�弯
	 * 
	 * @param entityClass
	 *            ʵ��
	 * @return ����
	 */
	public List<T> findAll(Class<T> entityClass) {
		return baseHibernateDAO.findAll(entityClass);
	}

	/**
	 * ����ĳһ�û��µ�ָ��ʵ����Ϣ�ļ���
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @param username
	 *            �û���
	 * @return ʵ����󼯺�
	 */
	public List findAllByUsername(Class<T> entityClass, String username)
			throws Exception {
		if (null == username || StringUtils.isBlank(username)) {
			log.debug(" input username is null or empty!");
			throw new Exception("input username is null or empty!");
		}
		return baseHibernateDAO.findAllByUsername(entityClass, username);
	}

	/**
	 * ģ����ѯָ���������󼯺� <br>
	 * �÷�������ʵ�������յ�T������Ҫ��ѯĳ���ֶΣ���set���ֶε�����Ȼ����ñ���<br>
	 * ȱ�㣺Ŀǰ����ò��ֻ��֧��String��ģ����ѯ����Ȼ�а취��д����û��Ҫ��������HQL<br>
	 * 
	 * @param entity
	 *            ����ʵ��
	 * @return ���
	 */
	public List<T> findByExample(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		return baseHibernateDAO.findByExample(entity);
	}

	/**
	 * ����ָ��IDʵ�����
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @param id
	 *            ʵ��ID
	 * @return ʵ�����
	 */
	public T findById(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		return (T) baseHibernateDAO.findById(entityClass, id);
	}

	/**
	 * ����ָ������ʵ�弯��
	 * 
	 * @param entityClass
	 *            ʵ��
	 * @param propertyName
	 *            ����
	 * @param value
	 *            ����
	 * @return ʵ�弯��
	 */
	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
		return baseHibernateDAO
				.findByProperty(entityClass, propertyName, value);
	}

	public int findInt(String hql, Object... values) {
		return baseHibernateDAO.findInt(hql, values);
	}

	/**
	 * ��ȡָ��ʵ��Class�ļ�¼��
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @return ��¼����
	 */
	public int findTotalCount(Class<T> entityClass, String where,
			Object... values) {
		return baseHibernateDAO.findTotalCount(entityClass, where, values);
	}

	public int findTotalCount(Class<T> entityClass) {
		return baseHibernateDAO.findTotalCount(entityClass);
	}

	/**
	 * ����HQL����ѯΨһ����.
	 * 
	 * @param hql
	 *            HQL���
	 * @param values
	 *            �ɱ��������
	 * @return OBJECT����
	 */
	public T findUnique(String hql, Object... values) {
		return (T) baseHibernateDAO.findUnique(hql, values);
	}

	/**
	 * ����ĳһ�û��µļ���,�û����Ƿ��Ѿ�����
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @param username
	 *            �û�����
	 * @param name
	 *            ��ע���û���
	 */
	public boolean isExist(final Class<T> entityClass, String username,
			String name) {
		if (name == null || StringUtils.isBlank(name)) {
			log.debug(" input name is null or empty!");
			return true;
		}
		return baseHibernateDAO.isExist(entityClass, username, name);
	}
	
	/**
	 * �����û����Ƿ��Ѿ�����
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @param name
	 *            ��ע���û���
	 */
	public boolean isExist(final Class<T> entityClass,String name) {
		if (name == null || StringUtils.isBlank(name)) {
			log.debug(" input name is null or empty!");
			return true;
		}
		return baseHibernateDAO.isExist(entityClass,name);
	}

	/**
	 * ����ָ��IDʵ����
	 * 
	 * @param entityClass
	 *            ʵ��Class
	 * @param id
	 *            ʵ��ID
	 * @return ʵ�����
	 */
	public T load(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		return (T) baseHibernateDAO.load(entityClass, id);
	}

	/**
	 * session��״̬�־û�����
	 * 
	 * @param entity
	 *            ʵ��
	 * @return �־ú��ʵ��
	 */
	public T merge(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		return (T) baseHibernateDAO.merge(entity);
	}

	/**
	 * ����ָ��ʵ��
	 * 
	 * @param entityobj
	 *            ʵ��
	 */
	public void save(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.save(entity);
	}

	/**
	 * ���»򱣴�ָ��ʵ
	 * 
	 * @param entity
	 *            ʵ��
	 */
	public void saveOrUpdate(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.saveOrUpdate(entity);
	}

	/**
	 * ��oracle������,����ͨ��ӳ���ļ���ȡsequence, Ҳ����ͨ�����·����ڳ����л�ȡ
	 * 
	 * @param sequence
	 *            ִ��sequence������,��CommonContexts��
	 * 
	 * @return sequence
	 */
	public String findSequence(String sequence) throws Exception {
		if (sequence == null || StringUtils.isBlank(sequence)) {
			throw new Exception("the sequence name can not empty!");
		}
		return baseHibernateDAO.findSequence(sequence);
	}

	public boolean checkExist(Class<T> entityClass, String propertyName,
			Object value) throws Exception {
		return baseHibernateDAO.checkExist(entityClass, propertyName, value);
	}

	public List findRelationList(String sql) throws Exception {
		return baseHibernateDAO.findRelationList(sql);
	}

	public List<T> findAllOrderbyProperty(Class<T> entityClass,
			String propertyName) throws Exception {
		return baseHibernateDAO.findAllOrderbyProperty(entityClass, propertyName);
	}

	public List<T> findPartOrderByProperty(Class<T> entityClass,
			String propertyName, String orderByProperty, Object value)
			throws Exception {
		return baseHibernateDAO.findPartOrderByProperty(entityClass, propertyName, orderByProperty, value);
	}

	public boolean isValid(final Class<T> entityClass,
			String username, String password) throws Exception {
		if (username == null || StringUtils.isBlank(username)) {
			log.debug(" input name is null or empty!");
			return true;
		}
		
		if (password == null || StringUtils.isBlank(password)) {
			log.debug(" input name is null or empty!");
			return true;
		}
		
		return baseHibernateDAO.isExist(entityClass, username, password);
	}

	public List<T> findBySQLMap(final String param,final String name,final String value) throws Exception {
		if (param == null || StringUtils.isBlank(param)) {
			log.debug(" input properties is null or empty!");
			return Collections.EMPTY_LIST;
		}
		return baseHibernateDAO.findBySQLMap(param,name,value);
	}
}

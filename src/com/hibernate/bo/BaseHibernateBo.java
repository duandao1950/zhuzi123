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
	 * 清除实体的锁定状<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	public void attachClean(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.attachClean(entity);
	}

	/**
	 * 根据查询条件与参数列表创建Query对象
	 * 
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	public Query createQuery(Session session, String hql, Object... objects) {
		return baseHibernateDAO.createQuery(session, hql, objects);
	}

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void delete(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.delete(entity);
	}

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void delete(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		baseHibernateDAO.delete(entityClass, id);
	}

	/**
	 * 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列
	 * @return 集合
	 */
	public List<T> find(String hql, Object... values) {
		return baseHibernateDAO.find(hql, values);
	}

	/**
	 * 获取有实体集
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> findAll(Class<T> entityClass) {
		return baseHibernateDAO.findAll(entityClass);
	}

	/**
	 * 查找某一用户下的指定实体信息的集合
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param username
	 *            用户名
	 * @return 实体对象集合
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
	 * 模糊查询指定条件对象集合 <br>
	 * 用法：可以实例化个空的T对象，需要查询某个字段，就set该字段的条件然后调用本方<br>
	 * 缺点：目前测试貌似只能支持String的模糊查询，虽然有办法重写，但没必要，其他用HQL<br>
	 * 
	 * @param entity
	 *            条件实体
	 * @return 结合
	 */
	public List<T> findByExample(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		return baseHibernateDAO.findByExample(entity);
	}

	/**
	 * 查找指定ID实体类对
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	public T findById(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		return (T) baseHibernateDAO.findById(entityClass, id);
	}

	/**
	 * 查找指定属的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属名
	 * @param value
	 *            条件
	 * @return 实体集合
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
	 * 获取指定实体Class的记录数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass, String where,
			Object... values) {
		return baseHibernateDAO.findTotalCount(entityClass, where, values);
	}

	public int findTotalCount(Class<T> entityClass) {
		return baseHibernateDAO.findTotalCount(entityClass);
	}

	/**
	 * 按照HQL语句查询唯一对象.
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 */
	public T findUnique(String hql, Object... values) {
		return (T) baseHibernateDAO.findUnique(hql, values);
	}

	/**
	 * 查找某一用户下的集合,用户名是否已经存在
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param username
	 *            用户名称
	 * @param name
	 *            新注册用户名
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
	 * 查找用户名是否已经存在
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param name
	 *            新注册用户名
	 */
	public boolean isExist(final Class<T> entityClass,String name) {
		if (name == null || StringUtils.isBlank(name)) {
			log.debug(" input name is null or empty!");
			return true;
		}
		return baseHibernateDAO.isExist(entityClass,name);
	}

	/**
	 * 查找指定ID实体类
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	public T load(Class<T> entityClass, ID id) throws Exception {
		if (null == id || StringUtils.isBlank(id.toString())) {
			log.debug(" input id is null or empty!");
			throw new Exception("input id is null or empty!");
		}
		return (T) baseHibernateDAO.load(entityClass, id);
	}

	/**
	 * session的状态持久化对象
	 * 
	 * @param entity
	 *            实体
	 * @return 持久后的实体
	 */
	public T merge(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		return (T) baseHibernateDAO.merge(entity);
	}

	/**
	 * 保存指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void save(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.save(entity);
	}

	/**
	 * 更新或保存指定实
	 * 
	 * @param entity
	 *            实体
	 */
	public void saveOrUpdate(T entity) throws Exception {
		if (null == entity) {
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}
		baseHibernateDAO.saveOrUpdate(entity);
	}

	/**
	 * 在oracle数据中,可以通过映射文件获取sequence, 也可以通过如下方法在程序中获取
	 * 
	 * @param sequence
	 *            执行sequence的名字,见CommonContexts类
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

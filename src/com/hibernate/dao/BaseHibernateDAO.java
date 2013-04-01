package com.hibernate.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.WebApplicationContext;

import com.hibernate.beans.User;
import com.hibernate.dao.idao.IBaseHibernateDAO;

/**
 * DAO操作基类<br>
 * 本DAO层实现了通用的数据操
 * 
 * @param <T>
 *            POJO实体对象
 * @param <ID>
 *            ID
 */
@SuppressWarnings("unchecked")
public class BaseHibernateDAO<T, ID extends Serializable> extends
		HibernateDaoSupport implements IBaseHibernateDAO<T, ID> {

	private static final Logger logger = Logger
			.getLogger(BaseHibernateDAO.class);

	/**
	 * 保存指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void save(T entity) throws RuntimeException{
		getHibernateTemplate().save(entity);
		if (logger.isDebugEnabled()) {
			logger.debug("保存实体类," + entity.getClass().getName());
		}
	}

	/**
	 * 更新或保存指定实
	 * 
	 * @param entity
	 *            实体
	 */
	public void saveOrUpdate(T entity) throws RuntimeException{
		getHibernateTemplate().saveOrUpdate(entity);
		if (logger.isDebugEnabled()) {
			logger.debug("更新或保存实体," + entity.getClass().getName());
		}
	}

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void delete(T entity) throws RuntimeException{
		getHibernateTemplate().delete(entity);
		if (logger.isDebugEnabled()) {
			logger.debug("删除实体类成," + entity.getClass().getName());
		}
	}

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体
	 */
	public void delete(Class<T> entityClass, ID id) throws RuntimeException{
		Object p = getHibernateTemplate().load(entityClass, id);
		getHibernateTemplate().delete(p);
		if (logger.isDebugEnabled()) {
			logger.debug("删除实体类成," + entityClass.getClass().getName());
		}
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
	public List<T> find(String hql, Object... values) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("开始查询指定HQL语句," + hql);
		}
		return getHibernateTemplate().find(hql, values);
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
	public T findById(Class<T> entityClass, ID id) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("开始查找ID" + id + "的实体：" + entityClass);
		}
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 获取有实体集
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> findAll(Class<T> entityClass) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("开始删除实体：" + entityClass.getName());
		}
		StringBuffer sbf = new StringBuffer("from " + entityClass.getName());

		return getHibernateTemplate().find(sbf.toString());
	}

	/**
	 * 获取有实体集 根据propertyName 排序
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> findAllOrderbyProperty(Class<T> entityClass,
			String propertyName) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("开始删除实体：" + entityClass.getName());
		}
		StringBuffer sbf = new StringBuffer("from " + entityClass.getName());
		if (propertyName != null && StringUtils.isNotBlank(propertyName)) {
			sbf.append(" model where 1=1 order by model.").append(
					propertyName).append(" asc");
		}

		return getHibernateTemplate().find(sbf.toString());
	}

	/**
	 * 查找指定HQL并返回INT
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return INT
	 */
	public int findInt(final String hql, final Object... values) throws RuntimeException{
		return findUnique(hql, values) == null ? 0 : 1;
	}

	/**
	 * 查找指定HQL并返回INT 查找指定属性的实体集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return INT
	 */
	public boolean checkExist(Class<T> entityClass, String propertyName,
			Object value) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("始查找指定属性：" + propertyName + "?" + value + "的实体"
					+ entityClass.getName());
		}
		String queryStr = "from " + entityClass.getName()
				+ " as model where model." + propertyName + "=?";
		return getHibernateTemplate().find(queryStr, value.toString())
				.size() == 0 ? false : true;
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
	public T findUnique(final String hql, final Object... values) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("开始查询返回唯一结果的HQL语句," + hql);
		}
		return (T) getHibernateTemplate().execute(new HibernateCallback() {
			public T doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = createQuery(s, hql, values);
				return (T) query.uniqueResult();
			}
		});
	}

	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 */
	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("始查找指定属性：" + propertyName + "?" + value + "的实体"
					+ entityClass.getName());
		}
		String queryStr = "from " + entityClass.getName()
				+ " as model where model." + propertyName + "=?";
		return getHibernateTemplate().find(queryStr, value);
	}

	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 */
	public List<T> findPartOrderByProperty(Class<T> entityClass,
			String propertyName, String orderByProperty, Object value) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("始查找指定属性：" + propertyName + "?" + value + "的实体"
					+ entityClass.getName());
		}
		StringBuffer queryStr = new StringBuffer("from "
				+ entityClass.getName() + " as model where model."
				+ propertyName + "=?");

		if (StringUtils.isNotBlank(orderByProperty)) {
			queryStr.append(" order by ").append("model.").append(
					orderByProperty).append(" asc");
		}
		return getHibernateTemplate().find(queryStr.toString(), value);
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
	public List<T> findByExample(T entity) throws RuntimeException{
		List<T> results = getHibernateTemplate().findByExample(entity);
		return results;
	}

	/**
	 * 补充方法(未测) 据说可以无视session的状态持久化对象
	 * 
	 * @param entity
	 *            实体
	 * @return 持久后的实体
	 */
	public T merge(T entity) throws RuntimeException{
		T result = (T) getHibernateTemplate().merge(entity);
		return result;
	}

	/**
	 * 清除实体的锁定状<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	public void attachClean(T entity) throws RuntimeException{
		getHibernateTemplate().lock(entity, LockMode.NONE);
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
	public Query createQuery(Session session, String hql, Object... objects) throws RuntimeException{
		Query query = session.createQuery(hql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query;
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
	public T load(Class<T> entityClass, ID id) throws RuntimeException{
		return (T) getHibernateTemplate().load(entityClass, id);
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
	public List findAllByUsername(final Class<T> entityClass,
			final String username) throws RuntimeException{
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(entityClass).add(
						Restrictions.eq("name", username)).list();
				return result;
			}
		});
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
	public boolean isExist(final Class<T> entityClass, final String username,
			final String name) throws RuntimeException{
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						List result = session.createCriteria(entityClass).add(
								Restrictions.eq("name", name)).add(
								Restrictions.eq("username", username)).list();
						return result;
					}
				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isExist(final Class<T> entityClass, final String name)
			throws RuntimeException {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						List result = session.createCriteria(entityClass).add(
								Restrictions.eq("name", name)).list();
						return result;
					}
				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 在oracle数据中,可以通过映射文件获取sequence, 也可以通过如下方法在程序中获取
	 * 
	 * @param sequence
	 *            执行sequence的名字,见CommonContexts类
	 * 
	 * @return sequence
	 */
	public String findSequence(String sequence) throws RuntimeException {
		StringBuffer sql = new StringBuffer(20);
		sql.append("select ").append(sequence).append(" from dual");
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		String sequenceValue = session.createSQLQuery(sql.toString())
				.uniqueResult().toString();
		session.close();
		return sequenceValue;
	}

	/**
	 * 在oracle数据中,可以通过映射文件获取sequence, 也可以通过如下方法在程序中获取
	 * 
	 * @param sequence
	 *            执行sequence的名字,见CommonContexts类
	 * 
	 * @return sequence
	 */
	public List findRelationList(final String sql) throws RuntimeException {
//		Session session = getHibernateTemplate().getSessionFactory()
//				.openSession();
//		List list = session.createSQLQuery(sql).list();
//		session.close();
		
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createSQLQuery(sql).list();
				return result;
			}
		});
		return list;
	}

	/*
	 * 在DAO中如此调用 1.单个流水： BigDecimal
	 * seq=this.getBigDecimalSequence(PmPurchaseOrderList.class); 2.
	 * 批量流水,取得的流水为第一个，其它的流水通过seq+1 BigDecimal
	 * seq=this.getBigDecimalSequence(PmPurchaseOrderList.class,size); 3.日期+几位流水
	 * BigDecimal getDateSequence(Class entityClass, Date nowDate,String
	 * dateStyle, int length); 4.批量取日期+几位流水 BigDecimal getDateSequence(Class
	 * entityClass, Date nowDate,String dateStyle, int length, int size)；
	 */

	/**
	 * 从Spring上下文中获取本类对象<br>
	 * 此方法可能存在线程并发问题（待测
	 * 
	 * @param context
	 *            Spring上下
	 * @return 本类对象
	 */
	public static IBaseHibernateDAO getFromApplicationContext(
			WebApplicationContext context) {
		return (IBaseHibernateDAO) context.getBean("BaseHibernateDAO");
	}

	/**
	 * 获取指定实体Class指定条件的记录数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param where
	 *            HQL的查询条,支持参数列表
	 * @param values
	 *            可变参数列表
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass, String where,
			Object... values) throws RuntimeException {
		String hql = "select count(1) from " + entityClass.getName() + " as e "
		+ where;
		return findInt(hql, values);
	}

	/**
	 * 获取指定实体Class的记录数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass) throws RuntimeException {
		return findTotalCount(entityClass, "");
	}

	public boolean isValid(Class<T> entityClass, final String username,
			final String password) throws Exception {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("name", username)).add(
						Restrictions.eq("password", password)).add(
						Restrictions.gt("cancelTime", new Date())).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 配置SQL语句查询对象
	 * @param param
	 *            SQL语句ID
	 * @return List对象
	 */
	public List<T> findBySQLMap(final String param,final String name,final String value) throws RuntimeException{
		if (logger.isDebugEnabled()) {
			logger.debug("根据配置文件中的SQL查询返回结果, " + param);
		}
		return (List<T>)getHibernateTemplate().execute(new HibernateCallback() {
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				List<T> list = session.getNamedQuery(param).setString("id", value).list();
				return list;
			}
		});
	}
	
	/**
	 * 配置SQL语句查询对象
	 * @param param
	 *            SQL语句ID
	 * @return List对象
	 */
	public List<T> findBySQLMapDic(final String id,final String tableName) throws RuntimeException{
		final String queryName = "select_dic_key_value";
		if (logger.isDebugEnabled()) {
			logger.debug("根据配置文件中的SQL查询返回结果, " + queryName + "["+id+","+tableName+"]");
		}
		return (List<T>)getHibernateTemplate().execute(new HibernateCallback() {
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				List<T> list = session.getNamedQuery(queryName)
				.setString("id", id)
				.setString("table_name", tableName)
				.list();
				return list;
			}
		});
	}
}

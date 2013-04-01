package com.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Config;


public class ConfigDAO extends HibernateDaoSupport 
{
	private static final Logger logger = Logger
	.getLogger(BaseHibernateDAO.class);
	
	/**
	 * 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列
	 * @return 集合
	 */
	public List<T> find(Class<Config> class1, Config configValue) 
	{
		StringBuffer sql = new StringBuffer();
		List list = new ArrayList();
		sql.append(" from Config where 1=1 ");
		if(null != configValue.getInfName() && !"".equals(configValue.getInfName()))
		{
			sql.append(" and infName = '")
			   .append(configValue.getInfName())
			   .append("'");
		}
		if(null != configValue.getId() && !"".equals(configValue.getId()))
		{
			sql.append(" and id = '")
			   .append(configValue.getId())
			   .append("'");
		}
		
		
		Configuration config = new Configuration();
		config = config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		try 
		{
			
			if (logger.isDebugEnabled()) 
			{
				logger.debug("开始查询指定HQL语句," + sql.toString());
				
			}
			list = session.createQuery(sql.toString()).list();
			trans.commit();
			session.close();
		} 
		catch (RuntimeException e) 
		{
			logger.error("查询指定HQL异常，HQL" + sql.toString(), e);
			throw e;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		finally
		{
			if(null != trans)
			{
				trans.commit();
			}
			if(null != session)
			{
				session.close();
			}
			
		}
		return list;
	}

    
}

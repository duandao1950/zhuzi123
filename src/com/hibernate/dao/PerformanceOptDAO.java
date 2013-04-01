package com.hibernate.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.PerformanceOpt;
import com.hibernate.dao.idao.IPerformanceOptDAO;

public class PerformanceOptDAO extends HibernateDaoSupport implements
		IPerformanceOptDAO {

	private Logger log = Logger.getLogger(this.getClass());
	
	public void addPerformanceOpt(PerformanceOpt pfOpt) throws Exception {
		
		try
		{
			this.getHibernateTemplate().save(pfOpt);
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Add performanceOpt err.",e);
		}
	}

	public void delPerformanceOpt(PerformanceOpt pfOpt) throws Exception {
		
		if(null == pfOpt)
		{
			log.error("null parameter when del performanceOpt");
			throw new Exception("null parameter when del performanceOpt");
		}
		try
		{
			this.getHibernateTemplate().delete(pfOpt);
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Del performanceOpt err",e);
		}
	}

	public ArrayList findAllPerformanceOpt() throws Exception {
		ArrayList pfOptList = null;
		try
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from PerformanceOpt");
			pfOptList = (ArrayList)this.getSession().createQuery(hql.toString()).list();
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Search all performanceOpt err",e);
		}
		return pfOptList;
	}

	public ArrayList findPerformanceOptById(String staffId)
			throws Exception {
		
		if(null == staffId || "".equals(staffId))
		{
			log.error("null parameter when search performanceOpt by id");
			throw new Exception("null parameter when search performanceOpt by id");
		}
		
		ArrayList pf = null;
		try
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from PerformanceOpt p where p.staffId='");
			hql.append(staffId);
			hql.append("'");
			
			pf = (ArrayList)this.getSession().createQuery(hql.toString()).list();
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Search operformanceOpt by id err",e);
		}
		return pf;
	}

	public ArrayList findPerformanceOptByName(String staffName)
			throws Exception {
		if(null == staffName || "".equals(staffName))
		{
			log.error("null parameter when search performanceOpt by name");
			throw new Exception("null parameter when search performanceOpt by id");
		}
		
		ArrayList pf = null;
		try
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from PerformanceOpt p where p.staffName='");
			hql.append(staffName);
			hql.append("'");
			
			pf = (ArrayList)this.getSession().createQuery(hql.toString()).list();
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Search operformanceOpt by name err",e);
		}
		return pf;
	}

	public void updatePerformanceOpt(PerformanceOpt pfOpt) throws Exception {
		
		if(null == pfOpt)
		{
			log.error("null parameter when modify performanceOpt");
			throw new Exception("null parameter when modify performanceOpt");
		}
		try
		{
			this.getHibernateTemplate().update(pfOpt);
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Modify performanceOpt err",e);
		}
	}

	public PerformanceOpt findPerformanceOptById(String staffId, String month)
			throws Exception {
		if(null == staffId || "".equals(staffId) || null == month || "".equals(month))
		{
			log.error("null parameter when search performanceOpt by id and month");
			throw new Exception("null parameter when search performanceOpt by id and month");
		}
		
		PerformanceOpt pf = null;
		try
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from PerformanceOpt p where p.staffId='");
			hql.append(staffId);
			hql.append("' ");
			hql.append("and ");
			hql.append("p.month='");
			hql.append(month);
			hql.append("'");
			
			pf = (PerformanceOpt)this.getSession().createQuery(hql.toString()).uniqueResult();
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("Search operformanceOpt by id err",e);
		}
		return pf;
	}

}

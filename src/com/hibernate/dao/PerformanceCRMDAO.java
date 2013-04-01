package com.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.PerformanceCRM;
import com.hibernate.dao.idao.IPerformanceCRMDAO;

public class PerformanceCRMDAO extends BaseHibernateDAO implements IPerformanceCRMDAO
{
	private Logger log = Logger.getLogger(this.getClass());
	
	/*
	 * 根据条件查询
	 * @see com.hibernate.dao.idao.IPerformanceCRMDAO#findAllByCondition(java.lang.Class, com.hibernate.beans.PerformanceCRM)
	 */
	public List<T> findAllByCondition(Class<PerformanceCRM> class1,
			PerformanceCRM perCRM)  throws Exception
	{
		if(null == perCRM)
		{
			return null;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("from PerformanceCRM where 1=1 ");
		if(null != perCRM.getStaffId() && !"".equals(perCRM.getStaffId()))
		{
			sql.append(" and staffId = '")
			   .append(perCRM.getStaffId())
			   .append("'");
		}
		if(null != perCRM.getStaffName() && !"".equals(perCRM.getStaffName()))
		{
			sql.append(" and staffName = '")
			   .append(perCRM.getStaffName())
			   .append("'");
		}
		if(null != perCRM.getInMonth() && !"".equals(perCRM.getInMonth()))
		{
			sql.append(" and inMonth = '")
			   .append(perCRM.getInMonth())
			   .append("'");
		}
		return super.find(sql.toString(), null);
		
	}
	
	/*
	 * 删除绩效信息
	 * @see com.hibernate.dao.idao.IPerformanceCRMDAO#deleteByCompositeId(java.lang.String, java.lang.String)
	 */
	public void deleteByCompositeId(String staffId, String inMonth) throws Exception
	{
		if(null == staffId || "".equals(staffId) || null == inMonth)
		{
			log.error("The input parameter roleId is null.");
			return;
		}
		StringBuffer hql = new StringBuffer();
		hql.append("delete from PerformanceCRM where staffId = '")
		   .append(staffId)
		   .append("' and inMonth = '")
		   .append(inMonth)
		   .append("'");
		try
		{
			this.getSession().createQuery(hql.toString()).executeUpdate();
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("del performance CRM err",e);
		}
	}
	
	/*
	 * 编辑绩效信息
	 * @see com.hibernate.dao.idao.IPerformanceCRMDAO#editByCompositeId(java.lang.String, java.lang.String)
	 */
	/*public PerformanceCRM findByCompositeId(String staffId, String inMonth) throws Exception
	{
		if(null == staffId || "".equals(staffId) || null == inMonth)
		{
			log.error("The input parameter roleId is null.");
			return;
		}
		StringBuffer hql = new StringBuffer();
		hql.append("select from PerformanceCRM where staffId = '")
		   .append(staffId)
		   .append("' and inMonth = '")
		   .append(inMonth)
		   .append("'");
		try
		{
			
		}
		catch(Exception e)
		{
			log.error(e);
			throw new Exception("update performance CRM err", e);
		}
		
	}*/

}

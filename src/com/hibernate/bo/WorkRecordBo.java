package com.hibernate.bo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.WorkRecord;
import com.hibernate.bo.ibo.IWorkRecordBo;
import com.hibernate.dao.WorkRecordDAO;

public class WorkRecordBo extends BaseHibernateBo implements IWorkRecordBo
{
	
	private WorkRecordDAO workRecordDAO;

	public WorkRecordDAO getWorkRecordDAO() 
	{
		return workRecordDAO;
	}

	public void setWorkRecordDAO(WorkRecordDAO workRecordDAO) 
	{
		this.workRecordDAO = workRecordDAO;
	}
	
	public List<T> findAllByCondition(Class<WorkRecord> class1,
			WorkRecord workRecord) throws Exception 
	{
		// TODO Auto-generated method stub
		/*if (null == entity)
		{
			log.debug(" input entity is null or empty!");
			throw new Exception("input entity is null or empty!");
		}*/
		return workRecordDAO.findAllByCondition(class1, workRecord);
		/*return baseHibernateDAO.findByExample(entity);*/
	}
	
}

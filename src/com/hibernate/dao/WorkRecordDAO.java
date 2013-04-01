package com.hibernate.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.WorkRecord;
import com.hibernate.dao.idao.IWorkRecordDAO;

public class WorkRecordDAO extends BaseHibernateDAO implements IWorkRecordDAO
{
	public List<T>  findAllByCondition(Class<WorkRecord> class1,
			WorkRecord workRecord) throws Exception 
	{
		if(null == workRecord)
		{
			return null;
		}
		try
		{
			StringBuffer sql = new StringBuffer();
			sql.append("from WorkRecord where 1=1 ");
			if(!("".equals(workRecord.getStaffId())) && null !=  workRecord.getStaffId())
			{
				sql.append(" and staffId = '")
				   .append(workRecord.getStaffId())
				   .append("'");
				
				
			}
			if(!("".equals(workRecord.getApproveStaffId())) && null !=  workRecord.getApproveStaffId())
			{
				sql.append(" and approveStaffId = '")
				   .append(workRecord.getApproveStaffId())
				   .append("'");
			}
			
			return super.find(sql.toString(), null);
			
		}catch(Exception e)
		{
			throw new Exception("error");
		}
		
		
	}
}

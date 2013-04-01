package com.hibernate.bo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.PerformanceCRM;
import com.hibernate.bo.ibo.IPerformanceCRMBO;
import com.hibernate.dao.PerformanceCRMDAO;

public class PerformanceCRMBo extends BaseHibernateBo implements IPerformanceCRMBO
{
	private PerformanceCRMDAO perCRMDAO;

	

	public PerformanceCRMDAO getPerCRMDAO() {
		return perCRMDAO;
	}



	public void setPerCRMDAO(PerformanceCRMDAO perCRMDAO) {
		this.perCRMDAO = perCRMDAO;
	}



	public List<T> findAllByCondition(Class<PerformanceCRM> class1,
			PerformanceCRM perCRM)  throws Exception
	{
		return perCRMDAO.findAllByCondition(class1, perCRM);
	}


    /*
     * 根据联合主键删除绩效信息
     * @see com.hibernate.bo.ibo.IPerformanceCRMBO#deleteByCompositeId(java.lang.String, java.lang.Integer)
     */
	public void deleteByCompositeId(String staffId, String inMonth) throws Exception
	{
		perCRMDAO.deleteByCompositeId(staffId, inMonth);
	}
	
	/*
	 * 根据联合主键编辑绩效信息
	 * @see com.hibernate.bo.ibo.IPerformanceCRMBO#editByCompositeId(java.lang.String, java.lang.String)
	 */
	/*public PerformanceCRM findByCompositeId(String staffId, String inMonth) throws Exception
	{
		return perCRMDAO.findByCompositeId(staffId, inMonth);
	}*/

}

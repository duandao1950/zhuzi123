package com.hibernate.bo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Staff;
import com.hibernate.bo.ibo.IStaffBo;
import com.hibernate.dao.StaffDAO;

@SuppressWarnings("unchecked")
public class StaffBo extends BaseHibernateBo implements IStaffBo
{
	private StaffDAO staffDAO = null;

	public StaffDAO getStaffDAO() 
	{
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) 
	{
		this.staffDAO = staffDAO;
	}

	public List<T> findBeanListByCondition(Class<Staff> class1, Staff staff) throws Exception
	{
		return staffDAO.findBeanListByCondition(class1,staff);
	}
	
	public List<T> findBeanList(Class<Staff> class1, Staff staff) throws Exception
	{
		return staffDAO.findBeanListByCondition(class1,staff);
	}
	
	

}

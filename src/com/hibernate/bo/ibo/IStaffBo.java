package com.hibernate.bo.ibo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Staff;

public interface IStaffBo 
{
	public List<T> findBeanListByCondition(Class<Staff> class1, Staff staff)throws Exception;
	
	public List<T> findBeanList(Class<Staff> class1, Staff staff) throws Exception;

}

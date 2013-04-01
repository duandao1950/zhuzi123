package com.hibernate.dao.idao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Staff;

public interface IStaffDAO 
{
	public List<T> findBeanListByCondition(Class<Staff> class1, Staff staff) throws Exception;

}

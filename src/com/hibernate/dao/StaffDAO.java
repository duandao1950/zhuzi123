package com.hibernate.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Staff;
import com.hibernate.dao.idao.IStaffDAO;

@SuppressWarnings("unchecked")
public class StaffDAO extends BaseHibernateDAO implements IStaffDAO
{

	public List<T> findBeanListByCondition(Class<Staff> class1, Staff staff) throws Exception
	{
		if(null == staff)
		{
			return null;
		}
		try
		{
			StringBuffer sql = new StringBuffer();
			sql.append("from Staff where 1=1");
			if((null != staff.getStaffId()) && !("".equals(staff.getStaffId())))
			{
				sql.append(" and staffId = '")
				.append(staff.getStaffId())
				.append("'");
			}
			if((null != staff.getStaffName()) && !("".equals(staff.getStaffName())))
			{
				sql.append(" and staffName = '")
				.append(staff.getStaffName())
				.append("'");
			}
			return super.find(sql.toString(), null);
			
		}
		catch(Exception e)
		{
			throw new Exception("error");
		}
	}
	
	public List<T> findBeanList(Class<Staff> class1, Staff staff) throws Exception
	{
		
		if(null == staff)
		{
			return null;
		}
		try
		{
			StringBuffer sql = new StringBuffer();
			sql.append("from Staff where 1=1");
			if((null != staff.getStaffId()) && !("".equals(staff.getStaffId())))
			{
				sql.append(" and staffId = '")
				.append(staff.getStaffId())
				.append("'");
			}
			if((null != staff.getStaffName()) && !("".equals(staff.getStaffName())))
			{
				sql.append(" and staffName = '")
				.append(staff.getStaffName())
				.append("'");
			}
			if(null != staff.getSkill() && !"".equals(staff.getSkill()))
			{
				sql.append(" and skill = '")
				   .append(staff.getSkill())
				   .append("'");
			}
			if(null != staff.getTel1() && !"".equals(staff.getTel1()))
			{
				sql.append(" and tel1 = '")
				   .append(staff.getTel1())
				   .append("'");
			}
			if(null != staff.getTel2() && !"".equals(staff.getTel2()))
			{
				sql.append(" and tel2 = '")
				   .append(staff.getTel2())
				   .append("'");
			}
			if(null != staff.getEmail1() && !"".equals(staff.getEmail1()))
			{
				sql.append(" and email1 = '")
				   .append(staff.getEmail1())
				   .append("'");
			}
			if(null != staff.getEmail2()&& !"".equals(staff.getEmail2()))
			{
				sql.append(" and email2 = '")
				   .append(staff.getEmail2())
				   .append("'");
			}
			if(null != staff.getEnterComDate() && !"".equals(staff.getEnterComDate()))
			{
				sql.append(" and enterComDate = '")
				   .append(staff.getEnterComDate())
				   .append("'");
			}
			
			if(null != staff.getExitComDate() && !"".equals(staff.getExitComDate()))
			{
				sql.append(" and exitComDate = '")
				   .append(staff.getExitComDate())
				   .append("'");
			}
			if(null != staff.getGroupName() && !"".equals(staff.getGroupName()))
			{
				sql.append(" and groupName = '")
				   .append(staff.getGroupName())
				   .append("'");
			}
			if(null != staff.getStatusId() && !"".equals(staff.getStatusId()))
			{
				sql.append(" and statusId = '")
				   .append(staff.getStatusId())
				   .append("'");
			}
			if(null != staff.getWorkYears() && !"".equals(staff.getWorkYears()))
			{
				sql.append(" and workYears = '")
				   .append(staff.getWorkYears())
				   .append("'");
			}
			return super.find(sql.toString(), null);
			
		}
		catch(Exception e)
		{
			throw new Exception("error");
		}
	}

}

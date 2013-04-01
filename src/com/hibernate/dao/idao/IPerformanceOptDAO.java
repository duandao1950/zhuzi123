package com.hibernate.dao.idao;

import java.util.ArrayList;

import com.hibernate.beans.PerformanceOpt;

/**
 * 维优组绩效分数操作类
 * @author wKF36120
 * @version 01 2011-04-22
 *
 */
public interface IPerformanceOptDAO {

	/**
	 * 添加一个绩效
	 * @throws Exception
	 */
	public void addPerformanceOpt(PerformanceOpt pfOpt) throws Exception;
	
	/**
	 * 删除绩效
	 * @throws Exception
	 */
	public void delPerformanceOpt(PerformanceOpt pfOpt) throws Exception;
	
	/**
	 * 根据员工id查找绩效
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ArrayList findPerformanceOptById(String staffId) throws Exception;
	
	/**
	 * 根据员工id和所属月份查找
	 * @param staffId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public PerformanceOpt findPerformanceOptById(String staffId,String month) throws Exception;	
	
	/**
	 * 根据员工名称查找绩效
	 * @param staffName
	 * @return
	 * @throws Exception
	 */
	public ArrayList findPerformanceOptByName(String staffName) throws Exception;
	
	/**
	 * 查找所有绩效
	 * @return
	 * @throws Exception
	 */
	public ArrayList findAllPerformanceOpt() throws Exception;
	
	/**
	 * 更新绩效
	 * @param pfOpt
	 * @throws Exception
	 */
	public void updatePerformanceOpt(PerformanceOpt pfOpt) throws Exception;
}

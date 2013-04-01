package com.hibernate.bo.ibo;

import java.util.ArrayList;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;

public interface IOperatorBo {
	
	/**
	 * 添加操作员
	 * @param oper
	 * @throws Exception
	 */
	public void addOperator(Operator oper) throws Exception;
	
	public ArrayList findOpersByRoleId(String roleId) throws Exception;
	
	/**
	 * 更新操作员
	 * @param oper
	 * @throws Exception
	 */
	public void updateOperator(Operator oper) throws Exception;
	/**
	 * 根据id获取操作员
	 * @param operId
	 * @return
	 * @throws Exception
	 */
	public Operator getOperator(String operId) throws Exception;
	
	/**
	 * 根据名称查找操作员
	 * @param operName
	 * @return
	 * @throws Exception
	 */
	public Operator getOperByName(String operName) throws Exception;
	
	/**
	 * 获取所有操作员
	 * @return
	 * @throws Exception
	 */
	public ArrayList getAllOperators() throws Exception;
	
	/**
	 * 删除操作员
	 * @param operId
	 * @throws Exception
	 */
	public void delOperator(String operId) throws Exception;
	
	/**
	 * 删除操作员
	 * @param oper
	 * @throws Exception
	 */
	public void delOperator(Operator oper) throws Exception;	
	
	/**
	 * 获取所有菜单
	 * @return
	 * @throws Exception 
	 */
	public ArrayList getAllMenus() throws Exception;
	/**
	 * 获取操作员对应的菜单
	 * @param operId
	 * @return
	 * @throws Exception 
	 */
	public ArrayList getMenusByOperId(String operId) throws Exception;	
	
	/**
	 * 查询一个菜单
	 * @param privilegeId
	 * @return
	 * @throws Exception 
	 */
	public Menu getMenu(String privilegeId) throws Exception;
	/**
	 * 获取配置信息表信息
	 * @return
	 */
	public ArrayList getAllConfig();
}

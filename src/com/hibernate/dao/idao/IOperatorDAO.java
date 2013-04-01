package com.hibernate.dao.idao;

import java.util.ArrayList;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
/**
 * 操作员相关操作类
 * @author wKF36120
 * @version 01 2011-04-02
 *
 */
public interface IOperatorDAO {

	/**
	 * 添加一个操作员
	 * @param oper
	 */
	public void addOperator(Operator oper) throws Exception;
	
	/**
	 * 更新操作员信息
	 * @param oper
	 */
	public void updateOperator(Operator oper) throws Exception;
	
	/**
	 * 根据id查找操作员
	 * @param operId
	 * @return
	 */
	public Operator getOperator(String operId) throws Exception;
	
	/**
	 * 根据名称查询操作员
	 * @param operName
	 * @return
	 * @throws Exception
	 */
	public Operator getOperByName(String operName) throws Exception;
	
	/**
	 * 获取全部操作员
	 * @return
	 */
	public ArrayList getAllOperators() throws Exception;
	
	/**
	 * 根据角色id查找属于该角色的操作员
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public ArrayList findOpersByRoleId(String roleId) throws Exception;
	
	/**
	 * 根据id删除操作员
	 * @param operId
	 */
	public void delOperator(String operId) throws Exception;
	
	/**
	 * 删除操作员 
	 * @param oper
	 */
	public void delOperator(Operator oper) throws Exception;
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	public ArrayList getAllMenus() throws Exception;
	/**
	 * 获取操作员对应的菜单
	 * @param operId
	 * @return
	 */
	public ArrayList getMenusByOperId(String operId) throws Exception;
	
	/**
	 * 查询一个菜单
	 * @param privilegeId
	 * @return
	 */
	public Menu getMenu(String privilegeId) throws Exception;
	/**
	 * 获取配置信息表信息
	 * @return
	 */
	public ArrayList getAllConfig();
}

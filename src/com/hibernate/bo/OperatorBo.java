package com.hibernate.bo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
import com.hibernate.bo.ibo.IOperatorBo;
import com.hibernate.dao.idao.IOperatorDAO;

public class OperatorBo implements IOperatorBo {

	private Logger log = Logger.getLogger(this.getClass());
	private IOperatorDAO operDao;
		
	public IOperatorDAO getOperDao() {
		return operDao;
	}

	public void setOperDao(IOperatorDAO operDao) {
		this.operDao = operDao;
	}

	public void addOperator(Operator oper) throws Exception {
		
		operDao.addOperator(oper);
	}

	public ArrayList getAllOperators() throws Exception {
		
		return operDao.getAllOperators();
	}

	public Operator getOperator(String operId) throws Exception {
		
		return operDao.getOperator(operId);
	}

	public void updateOperator(Operator oper) throws Exception {
		
		operDao.updateOperator(oper);

	}

	public void delOperator(String operId) throws Exception {
		
		operDao.delOperator(operId);
	}

	public void delOperator(Operator oper) throws Exception {
		
		operDao.delOperator(oper);		
	}

	public ArrayList getAllMenus() throws Exception {
		
		return operDao.getAllMenus();
	}

	public ArrayList getMenusByOperId(String operId) throws Exception {
		
		return operDao.getMenusByOperId(operId);
	}

	public Menu getMenu(String privilegeId) throws Exception {
		
		return operDao.getMenu(privilegeId);
	}

	public Operator getOperByName(String operName) throws Exception {
		
		return operDao.getOperByName(operName);
	}
	public ArrayList getAllConfig() 
	{
		return operDao.getAllConfig();
	}
	
	public ArrayList findOpersByRoleId(String roleId) throws Exception
	{
		return operDao.findOpersByRoleId(roleId);
	}
}

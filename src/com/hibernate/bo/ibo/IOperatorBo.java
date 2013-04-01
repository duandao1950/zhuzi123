package com.hibernate.bo.ibo;

import java.util.ArrayList;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;

public interface IOperatorBo {
	
	/**
	 * ��Ӳ���Ա
	 * @param oper
	 * @throws Exception
	 */
	public void addOperator(Operator oper) throws Exception;
	
	public ArrayList findOpersByRoleId(String roleId) throws Exception;
	
	/**
	 * ���²���Ա
	 * @param oper
	 * @throws Exception
	 */
	public void updateOperator(Operator oper) throws Exception;
	/**
	 * ����id��ȡ����Ա
	 * @param operId
	 * @return
	 * @throws Exception
	 */
	public Operator getOperator(String operId) throws Exception;
	
	/**
	 * �������Ʋ��Ҳ���Ա
	 * @param operName
	 * @return
	 * @throws Exception
	 */
	public Operator getOperByName(String operName) throws Exception;
	
	/**
	 * ��ȡ���в���Ա
	 * @return
	 * @throws Exception
	 */
	public ArrayList getAllOperators() throws Exception;
	
	/**
	 * ɾ������Ա
	 * @param operId
	 * @throws Exception
	 */
	public void delOperator(String operId) throws Exception;
	
	/**
	 * ɾ������Ա
	 * @param oper
	 * @throws Exception
	 */
	public void delOperator(Operator oper) throws Exception;	
	
	/**
	 * ��ȡ���в˵�
	 * @return
	 * @throws Exception 
	 */
	public ArrayList getAllMenus() throws Exception;
	/**
	 * ��ȡ����Ա��Ӧ�Ĳ˵�
	 * @param operId
	 * @return
	 * @throws Exception 
	 */
	public ArrayList getMenusByOperId(String operId) throws Exception;	
	
	/**
	 * ��ѯһ���˵�
	 * @param privilegeId
	 * @return
	 * @throws Exception 
	 */
	public Menu getMenu(String privilegeId) throws Exception;
	/**
	 * ��ȡ������Ϣ����Ϣ
	 * @return
	 */
	public ArrayList getAllConfig();
}

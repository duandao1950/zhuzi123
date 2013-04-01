package com.hibernate.dao.idao;

import java.util.ArrayList;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
/**
 * ����Ա��ز�����
 * @author wKF36120
 * @version 01 2011-04-02
 *
 */
public interface IOperatorDAO {

	/**
	 * ���һ������Ա
	 * @param oper
	 */
	public void addOperator(Operator oper) throws Exception;
	
	/**
	 * ���²���Ա��Ϣ
	 * @param oper
	 */
	public void updateOperator(Operator oper) throws Exception;
	
	/**
	 * ����id���Ҳ���Ա
	 * @param operId
	 * @return
	 */
	public Operator getOperator(String operId) throws Exception;
	
	/**
	 * �������Ʋ�ѯ����Ա
	 * @param operName
	 * @return
	 * @throws Exception
	 */
	public Operator getOperByName(String operName) throws Exception;
	
	/**
	 * ��ȡȫ������Ա
	 * @return
	 */
	public ArrayList getAllOperators() throws Exception;
	
	/**
	 * ���ݽ�ɫid�������ڸý�ɫ�Ĳ���Ա
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public ArrayList findOpersByRoleId(String roleId) throws Exception;
	
	/**
	 * ����idɾ������Ա
	 * @param operId
	 */
	public void delOperator(String operId) throws Exception;
	
	/**
	 * ɾ������Ա 
	 * @param oper
	 */
	public void delOperator(Operator oper) throws Exception;
	
	/**
	 * ��ȡ���в˵�
	 * @return
	 */
	public ArrayList getAllMenus() throws Exception;
	/**
	 * ��ȡ����Ա��Ӧ�Ĳ˵�
	 * @param operId
	 * @return
	 */
	public ArrayList getMenusByOperId(String operId) throws Exception;
	
	/**
	 * ��ѯһ���˵�
	 * @param privilegeId
	 * @return
	 */
	public Menu getMenu(String privilegeId) throws Exception;
	/**
	 * ��ȡ������Ϣ����Ϣ
	 * @return
	 */
	public ArrayList getAllConfig();
}

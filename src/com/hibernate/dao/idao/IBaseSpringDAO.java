package com.hibernate.dao.idao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import com.hibernate.beans.Privilege;
import com.hibernate.beans.Roles;

public interface IBaseSpringDAO{
	/**
	 * ��ò���Ա->��ɫ->�˵�->��ɫ��˵�֮��Ĺ�ϵ
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	public List<Privilege> getMenuList(String operId) throws Exception;
	
	public List getRolesByOperId(String operId) throws Exception;
	
	public void deleteOperatorRolesRelation(String operId,Integer roleId) throws Exception;
	
	public List getPrivilegesByRoleId(Integer roleId) throws Exception;
	
	public void deleteRolePrivilegesRelation(Integer roleId,String privilegeId) throws Exception;
	
	public List<Privilege> getPartPrivilegesByParentId(String parentId) throws Exception;
	
	public LinkedHashMap<String,String> getDicContenByDicName(String dicName) throws Exception;
	
	public String loadDicContent(String dicName,String id) throws Exception;
}
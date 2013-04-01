package com.hibernate.bo;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.log4j.Logger;
import com.hibernate.beans.Privilege;
import com.hibernate.bo.ibo.IBaseSpringBo;
import com.hibernate.dao.BaseSpringDAO;

public class BaseSpringBo implements IBaseSpringBo {

	Logger log = Logger.getLogger(this.getClass());
	
	private BaseSpringDAO baseSpringDAO;
	public BaseSpringDAO getBaseSpringDAO() {
		return baseSpringDAO;
	}

	public void setBaseSpringDAO(BaseSpringDAO baseSpringDAO) {
		this.baseSpringDAO = baseSpringDAO;
	}
	
	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	public List<Privilege> getMenuList(String operId) throws SQLException {
		return baseSpringDAO.getMenuList(operId);
	}

	public List getRolesByOperId(String operId) throws Exception {
		// TODO Auto-generated method stub
		return baseSpringDAO.getRolesByOperId(operId);
	}

	public void deleteOperatorRolesRelation(String operId, Integer roleId)
			throws Exception {
		// TODO Auto-generated method stub
		baseSpringDAO.deleteOperatorRolesRelation(operId, roleId);
	}

	public List getPrivilegesByRoleId(Integer roleId) throws Exception {
		// TODO Auto-generated method stub
		return baseSpringDAO.getPrivilegesByRoleId(roleId);
	}

	public void deleteRolePrivilegesRelation(Integer roleId, String privilegeId)
			throws Exception {
		// TODO Auto-generated method stub
		baseSpringDAO.deleteRolePrivilegesRelation(roleId, privilegeId);
	}

	public List<Privilege> getPartPrivilegesByParentId(String parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return baseSpringDAO.getPartPrivilegesByParentId(parentId);
	}

	public LinkedHashMap<String, String> getDicContenByDicName(String dicName)
			throws Exception {
		// TODO Auto-generated method stub
		return baseSpringDAO.getDicContenByDicName(dicName);
	}

	public String loadDicContent(String dicName,String id) throws Exception {
		// TODO Auto-generated method stub
		return baseSpringDAO.loadDicContent(dicName,id);
	}
	
}
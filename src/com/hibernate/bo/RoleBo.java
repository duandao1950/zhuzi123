package com.hibernate.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hibernate.beans.Role;
import com.hibernate.bo.ibo.IRoleBo;
import com.hibernate.dao.idao.IRoleDAO;

public class RoleBo extends BaseHibernateBo implements IRoleBo {

	private Logger log = Logger.getLogger(this.getClass());
	private IRoleDAO roleDao;
	
	public IRoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public void addRole(Role role) throws Exception {
		
		roleDao.addRole(role);

	}

	public void delRole(Role role) throws Exception {
		
		roleDao.delRole(role);

	}

	public Role getRole(String roleId) throws Exception {
		
		return roleDao.getRole(roleId);
	}

	public List<Role> getRoles(Long userId) throws Exception {
		return roleDao.getRoles(userId);
	}

	public void updateRole(Role role) throws Exception {
		
		roleDao.updateRole(role);

	}

	public void delRole(String roleId) throws Exception {
		
		roleDao.delRole(roleId);
		
	}

	public Role getRoleByName(String roleName) throws Exception {

		return roleDao.getRoleByName(roleName);
	}

}

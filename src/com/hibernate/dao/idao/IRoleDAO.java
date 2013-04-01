package com.hibernate.dao.idao;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Role;

public interface IRoleDAO {

	/**
	 * 添加一个角色
	 * @param role
	 */
	public void addRole(Role role) throws Exception;
	
	/**
	 * 删除一个角色
	 * @param role
	 */
	public void delRole(Role role) throws Exception;
	
	/**
	 * 根据id删除
	 * @param roleId
	 */
	public void delRole(String roleId) throws Exception;
	
	/**
	 * 查询一个角色
	 * @param roleId
	 * @return
	 */
	public Role getRole(String roleId) throws Exception;
	
	/**
	 * 根据名称查询角色
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	public Role getRoleByName(String roleName) throws Exception;
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> getRoles(Long userId) throws Exception;
	
	/**
	 * 修改角色
	 * @param role
	 */
	public void updateRole(Role role) throws Exception;
}

package com.hibernate.dao.idao;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Role;

public interface IRoleDAO {

	/**
	 * ���һ����ɫ
	 * @param role
	 */
	public void addRole(Role role) throws Exception;
	
	/**
	 * ɾ��һ����ɫ
	 * @param role
	 */
	public void delRole(Role role) throws Exception;
	
	/**
	 * ����idɾ��
	 * @param roleId
	 */
	public void delRole(String roleId) throws Exception;
	
	/**
	 * ��ѯһ����ɫ
	 * @param roleId
	 * @return
	 */
	public Role getRole(String roleId) throws Exception;
	
	/**
	 * �������Ʋ�ѯ��ɫ
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	public Role getRoleByName(String roleName) throws Exception;
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role> getRoles(Long userId) throws Exception;
	
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 */
	public void updateRole(Role role) throws Exception;
}

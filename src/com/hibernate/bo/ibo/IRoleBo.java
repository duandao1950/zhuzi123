package com.hibernate.bo.ibo;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Role;

public interface IRoleBo {

	/**
	 * ���һ����ɫ
	 * @param role
	 * @throws Exception 
	 */
	public void addRole(Role role) throws Exception;
	
	/**
	 * ɾ��һ����ɫ
	 * @param role
	 * @throws Exception 
	 */
	public void delRole(Role role) throws Exception;

	/**
	 * ����idɾ��
	 * @param roleId
	 * @throws Exception 
	 */
	public void delRole(String roleId) throws Exception;
	
	/**
	 * ��ѯһ����ɫ
	 * @param roleId
	 * @return
	 * @throws Exception 
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
	 * @throws Exception 
	 */
	public List<Role> getRoles(Long userId) throws Exception;
	
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 * @throws Exception 
	 */
	public void updateRole(Role role) throws Exception;
}

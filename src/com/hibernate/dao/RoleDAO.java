package com.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Role;
import com.hibernate.dao.idao.IRoleDAO;

public class RoleDAO extends HibernateDaoSupport implements IRoleDAO {

	private Logger log = Logger.getLogger(this.getClass());
	
	public void addRole(Role role) {
		
		this.getHibernateTemplate().save(role);
	}

	public void delRole(Role role) {
		
		this.getHibernateTemplate().delete(role);
	}

	public Role getRole(String roleId) throws Exception {
		
		if(null == roleId || "".equals(roleId)) {
			log.error("The input parameter roleId is null.");
			return null;
		}
		Role role = null;
		StringBuffer hql = new StringBuffer();
		try {
			hql.append("select r from Role r ");
			hql.append("left join fetch r.privleges");
			hql.append(" where r.roleId=");
			hql.append("'");
			hql.append(roleId);
			hql.append("'");
			role = (Role) this.getSession().createQuery(hql.toString())
					.uniqueResult();
		} catch (Exception e) {
			log.error(e);
			throw new Exception("query role by id err",e);
		}
		return role;
	}

	@SuppressWarnings("unchecked")
	public List<Role> getRoles(Long userId) throws Exception {
		List<Role> roleList = null;
		try{
			roleList = this.getHibernateTemplate().find(" from user_role where user_id="+userId);
		}catch (Exception e){
			log.error(e);
			throw new Exception("query roles err",e);
		}
		return roleList;
	}

	public void updateRole(Role role) throws Exception {
		if(null == role)
		{
			log.error("null input paramter when modify role");
			throw new Exception("null para mod role");
		}
		this.getHibernateTemplate().update(role);

	}

	public void delRole(String roleId) throws Exception {
		
		if (null == roleId || "".equals(roleId))
		{
			log.error("The input parameter roleId is null.");
		}
		StringBuffer hql = new StringBuffer();
		hql.append("delete from Role r ");
		hql.append("where r.roleId=");
		hql.append("'");
		hql.append(roleId);
		hql.append("'");
		try{
			this.getSession().createQuery(hql.toString()).executeUpdate();
		}catch(Exception e)
		{
			log.error(e);
			throw new Exception("del role err",e);
		}
	}

	public Role getRoleByName(String roleName) throws Exception {
		
		if(null == roleName || "".equals(roleName)) {
			log.error("The input parameter roleId is null.");
			return null;
		}
		Role role = null;
		StringBuffer hql = new StringBuffer();
		try {
			hql.append("select r from Role r ");
			hql.append("left join fetch r.privleges");
			hql.append(" where r.roleName=");
			hql.append("'");
			hql.append(roleName);
			hql.append("'");
			role = (Role) this.getSession().createQuery(hql.toString())
					.uniqueResult();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return role;
	}

}

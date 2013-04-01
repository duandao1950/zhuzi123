package com.hibernate.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
import com.hibernate.dao.idao.IOperatorDAO;

public class OperatorDAO extends HibernateDaoSupport implements IOperatorDAO {

	private Logger log = Logger.getLogger(this.getClass());
	
	public void addOperator(Operator oper) throws Exception {
		
		if(null == oper){
			log.error("The input parameter oper is null.");
			throw new Exception("null parameter");
		}
		try{
			this.getHibernateTemplate().save(oper);
		}catch(Exception e){
			log.error(e);
			throw new Exception("add oper err",e);
		}
	}

	public ArrayList getAllOperators() throws Exception {
		
		ArrayList operList = new ArrayList();
		try{
			operList = (ArrayList) this.getHibernateTemplate().find(" select distinct o from Operator o left join fetch o.role r left join fetch r.privleges ");
		}catch(Exception e){
			log.error(e);
			throw new Exception("query all oper err",e);
		}
		return operList;
	}

	public Operator getOperator(String operId) throws Exception {
		
		if ("".equals(operId) || null == operId){
			log.error("The input parameter operId is null.");
			return null;
		}
		Operator oper = null;
		try{
			
			StringBuffer hql = new StringBuffer("select o from Operator o");
			hql.append(" left join fetch o.role r");	
			hql.append(" left join fetch r.privleges p");
			hql.append(" where o.operId=");
			hql.append("'");
			hql.append(operId);
			hql.append("'");
			hql.append("order by p.privilegeId");
			
			oper = (Operator) this.getSession().createQuery(hql.toString()).uniqueResult();
			
			//oper = (Operator)this.getSession().createQuery(" from Operator").uniqueResult();

		}catch(Exception e){
			log.error(e);
			throw new Exception("error occured when query oper info",e);
		}
		return oper;
	}

	public void updateOperator(Operator oper) throws Exception {
		
		if(null == oper){
			log.error("The input parameter oper is null.");
			throw new Exception("null parameter");
		}
		try{
			
			this.getHibernateTemplate().saveOrUpdate(oper);
			
		}catch(Exception e){
			log.error(e);
			throw new Exception("modify oper err",e);
		}
	}

	public void delOperator(String operId) throws Exception {
		
		if ("".equals(operId) || null == operId){
			log.error("The input parameter operId is null.");
			throw new Exception("null parameter when del oper");
		}		
		try {
			StringBuffer hql = new StringBuffer("delete Operator o where o.operId=");
			hql.append("'");
			hql.append(operId);
			hql.append("'");
			
			this.getSession().createQuery(hql.toString()).executeUpdate();
		} catch (Exception e) {
			log.error(e);
			throw new Exception("del oper err",e);
		}		
	}

	public void delOperator(Operator oper) throws Exception {
		if (null == oper){
			log.error("The input parameter is null.");
			throw new Exception("null paramter when del oper");
		}
		try {
			
			this.getHibernateTemplate().delete(oper);
			
		} catch (Exception e) {
			log.error(e);
			throw new Exception("failed to del oper",e);
		}
	}

	public ArrayList getAllMenus() {
		ArrayList menus = null;
		
		menus = (ArrayList) this.getHibernateTemplate().find(" from Menu ");
		
		return menus;
	}

	public ArrayList getMenusByOperId(String operId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Menu getMenu(String privilegeId) throws Exception {
		if(null == privilegeId || "".equals(privilegeId))
		{
			log.error("The input parameter privilegeId is null.");
			return null;
		}
		Menu menu = null;
		StringBuffer hql = new StringBuffer();
		hql.append("select m from Menu m ");
		hql.append("where m.privilegeId='");
		hql.append(privilegeId);
		hql.append("'");
		try{
			menu = (Menu)this.getSession().createQuery(hql.toString()).uniqueResult();
		}catch(Exception e)
		{
			log.error(e);
			throw new Exception("query menus err",e);
		}
		return menu;
	}

	public Operator getOperByName(String operName) throws Exception {
		
		if("".equals(operName) || null == operName)
		{
			log.error("the input parameter is null when query oper by name");
			return null;
		}
		Operator oper = null;
		
		try {
			StringBuffer hql = new StringBuffer("select o from Operator o");
			hql.append(" left join fetch o.role r");	
			hql.append(" left join fetch r.privleges p");
			hql.append(" where o.operName=");
			hql.append("'");
			hql.append(operName);
			hql.append("'");
			hql.append("order by p.privilegeId");	
			
			oper = (Operator) this.getSession().createQuery(hql.toString()).uniqueResult();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("query oper by name err",e);
		}
		return oper;
	}
	public ArrayList getAllConfig() {
		ArrayList config = null;
		
		config = (ArrayList) this.getHibernateTemplate().find(" from Config ");
		
		return config;
	}

	public ArrayList findOpersByRoleId(String roleId) throws Exception {

		ArrayList opers = null;
		if (null == roleId || "".equals(roleId)){
			log.error("The input parameter roleId is null.");
			return null;
		}
		Operator oper = null;
		try{
			
			StringBuffer hql = new StringBuffer("select o from Operator o");
			hql.append(" left join fetch o.role r");	
			hql.append(" where o.role=");
			hql.append("'");
			hql.append(roleId);
			hql.append("'");
			
			opers = (ArrayList) this.getSession().createQuery(hql.toString()).list();
			
		}catch(Exception e){
			log.error(e);
			throw new Exception("error occured when query oper info",e);
		}
		
		return opers;
	}
}

package com.struts.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hibernate.beans.Menu;
import com.hibernate.beans.Operator;
import com.hibernate.bo.ibo.IOperatorBo;
import com.hibernate.bo.ibo.IRoleBo;
import com.struts.util.Constants;

public class MenuAction extends BaseAction {

	private Logger log = Logger.getLogger(this.getClass());
	
	private IOperatorBo operBo;
	
	private IRoleBo roleBo;
	
	public IRoleBo getRoleBo() {
		return roleBo;
	}
	public void setRoleBo(IRoleBo roleBo) {
		this.roleBo = roleBo;
	}
	public IOperatorBo getOperBo() {
		return operBo;
	}
	public void setOperBo(IOperatorBo operBo) {
		this.operBo = operBo;
	}
	public String query()throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ArrayList rootList = new ArrayList();
		ArrayList subList = new ArrayList();//存放子菜单
		
		Operator oper = null;
		oper = (Operator) session.getAttribute(Constants.CURRENT_OPERINFO);
		if("0".equals(oper.getOperId())) {//0 is super operator
			rootList = operBo.getAllMenus();
		}else{
			//获取该操作员的所有菜单
//			Set menus = oper.getRole().getPrivleges();
//			Iterator tree = menus.iterator();
//			
//			while(tree.hasNext()) {
//				Menu m = (Menu)tree.next();
//				if(null == m.getUrl() || "".equals(m.getUrl()))
//				{
//					rootList.add(m);
//				}
//				else
//				{
//					subList.add(m);
//				}
//			}
		}		
		log.info("********sub list size=["+subList.size()+"],rootList size=["+rootList.size()+"]");
		request.setAttribute(Constants.MENU_OF_OPER_ROOT, rootList);
		request.setAttribute(Constants.MENU_OF_OPERATOR, subList);
		
		return Constants.LIST_KEY;
	}
	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findBeanList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

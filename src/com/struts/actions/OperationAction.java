package com.struts.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Operator;
import com.hibernate.beans.Role;
import com.hibernate.bo.ibo.IOperatorBo;
import com.hibernate.bo.ibo.IRoleBo;
import com.struts.util.Constants;

public class OperationAction extends BaseAction {

	private IOperatorBo operBo;
	private IRoleBo roleBo;
	private String operId;
	private String operName;
	private String password;
	private String valid;
	private Timestamp logintime;
	private ArrayList roles;
	private String roleId;
	
	private Role operRol;

	public Role getOperRol() {
		return operRol;
	}

	public void setOperRol(Role operRol) {
		this.operRol = operRol;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Timestamp getLogintime() {
		return logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IOperatorBo getOperBo() {
		return operBo;
	}

	public void setOperBo(IOperatorBo operBo) {
		this.operBo = operBo;
	}
	
	public String init() throws Exception {
		
		return Constants.INIT_KEY;
	}

	@Override
	public String add() throws Exception {

		//查出所有的角色供选择
		this.roles = (ArrayList) roleBo.getRoles(0L);
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return Constants.LIST_KEY;
	}

	@Override
	public String delete() throws Exception {
		
		String operId = request.getParameter("operId");
		operBo.delOperator(operId);
		return Constants.LIST_KEY;
	}

	@Override
	public String edit() throws Exception {
		
		String operId = request.getParameter("operId");
		if(null == operId || "".equals(operId)){
			this.addActionError(this.getText("The operator's id is not exist."));
			return Constants.LIST_KEY;			
		}else{
			Operator oper = operBo.getOperator(operId);
			if(null == oper){
				this.addActionError(this.getText("Can not find any operator by this ID [ ")+operId+" ]");
				return Constants.LIST_KEY;
			}
			//to do
			this.operName = oper.getOperName();
			this.password = oper.getPassword();
			this.valid = oper.getValid();
			this.logintime = oper.getLoginTime();
			
			this.operRol = oper.getRole();
			
			//查出所有的角色供选择
			this.roles = (ArrayList) roleBo.getRoles(0L);			
		}
		return Constants.EDIT_KEY;
	}

	@Override
	public List findBeanList() throws Exception {
		
		List operList = null;
		
		if (!"".equals(this.operId) && null != this.operId)
		{
			operList = new ArrayList();
			Operator oper = operBo.getOperator(this.operId);
			if(null != oper)
			{
				operList.add(oper);
			}
		}
		else if(!"".equals(this.operName) && null != this.operName)
		{
			operList = new ArrayList();
			Operator oper = operBo.getOperByName(operName);
			if(null != oper)
			{
				operList.add(oper);
			}
		}
		else
		{
			operList = operBo.getAllOperators();
		}		
		return operList;
	}

	@Override
	public String insert() throws Exception {
		Operator oper = null;
		
		oper = operBo.getOperator(operId);
		
		if(null != oper){
			
			this.addActionError(this.getText("The operator has been exist."));
			return Constants.ADD_KEY;
		}else{
			oper = new Operator();
			oper.setOperId(this.operId);
			oper.setOperName(this.operName);
			oper.setPassword(this.password);
			oper.setValid("1");//默认有效为1
			
			//设置操作员的角色
			oper.setRole(roleBo.getRole(this.roleId));
			
			operBo.addOperator(oper);	
			
			this.addActionMessage(this.getText("change.message.addoredit.success"));
			return Constants.LIST_KEY;			
		}		
		
	}

	@Override
	public String update() throws Exception {
		Operator oper = new Operator();
		oper.setOperId(this.operId);
		oper.setOperName(this.operName);
		oper.setPassword(this.password);
		oper.setValid(this.valid);
		oper.setLoginTime(this.getLogintime());
		
		//设置操作员的角色
		oper.setRole(roleBo.getRole(this.roleId));
		
		operBo.updateOperator(oper);
		return Constants.LIST_KEY;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public IRoleBo getRoleBo() {
		return roleBo;
	}

	public void setRoleBo(IRoleBo roleBo) {
		this.roleBo = roleBo;
	}

	public ArrayList getRoles() {
		return roles;
	}

	public void setRoles(ArrayList roles) {
		this.roles = roles;
	}

}

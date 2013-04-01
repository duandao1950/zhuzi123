package com.struts.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.hibernate.beans.Operators;
import com.hibernate.bo.OperatorsBo;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {

	Logger log = Logger.getLogger(this.getClass());
	
	protected OperatorsBo operatorsBo;
	
	public OperatorsBo getOperatorsBo() {
		return operatorsBo;
	}

	public void setOperatorsBo(OperatorsBo operatorsBo) {
		this.operatorsBo = operatorsBo;
	}

	protected String operId = null;
	
	protected String operName = null;
	
	protected String isValid = null;
	
	protected String password = null;
	
	protected String prePassword = null;
	
	protected String registerTime = null;
	
	public String init() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// invalidate the original session if exists
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return INPUT;
	}

	public String registerOperators()throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			// if exist
			boolean isExist = isExist(request, this.operId);

			if (isExist) {
				this.addActionError(this.getText("register.message.failed"));
			} else {
				insert();
				log.info("User " + this.operId + " register.");
			}
		} catch (Exception e) {
			this.addActionError(this.getText("register.message.failed"));
		}
		
		// invalidate the original session if exists
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		// If a message is required, save the specified key(s)
		if (this.hasActionErrors()) {
			return INPUT;
		} else {
			return Constants.SUCCESS_KEY;
		}
	}

	private boolean isExist(HttpServletRequest request,
			String operId) {
		if (operatorsBo.isExist(operId)) {
			return true;
		} else {
			return false;
		}
	}

	private void insert() {
		Operators operator = new Operators();
		operator.setOperId(this.operId);
		operator.setOperName(this.operName);
		operator.setPassword(this.password);
		operator.setIsValid(this.isValid);
		operator.setLoginTime(new Date());
		operator.setRegisterTime(new Date());
		operatorsBo.insertOperator(operator);
	}

	@Override
	public void validate() {
		/*if (null != this.operId && "".equals(this.operId)){
			this.addActionError("the user name is require!");
		}
		
		if (null != this.password1 && "".equals(this.password1)){
			this.addActionError("the password is require!");
		}
		
		if (null != this.password2 && "".equals(this.password2)){
			this.addActionError("the Confirm password is require!");
		}
		
//		if (!this.password1.equals(this.password2)){
//			this.addActionError("the password1 must be equals password2!");
//		}
		
		if (null != this.email && "".equals(this.email)){
			this.addActionError("the email is require!");
		}*/
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
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

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrePassword() {
		return prePassword;
	}

	public void setPrePassword(String prePassword) {
		this.prePassword = prePassword;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
}

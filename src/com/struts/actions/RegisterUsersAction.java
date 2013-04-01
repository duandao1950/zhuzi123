package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hibernate.beans.User;
import com.hibernate.bo.ibo.IBaseHibernateBo;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class RegisterUsersAction extends ActionSupport {

	Logger log = Logger.getLogger(this.getClass());
	
	protected IBaseHibernateBo iBaseHibernateBo;
	public IBaseHibernateBo getiBaseHibernateBo() {
		return iBaseHibernateBo;
	}

	public void setiBaseHibernateBo(IBaseHibernateBo iBaseHibernateBo) {
		this.iBaseHibernateBo = iBaseHibernateBo;
	}

	protected String username = null;

	protected String password1 = null;
	
	protected String password2 = null;
	
	protected String email = null;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String init() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// invalidate the original session if exists
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return INPUT;
	}

	public String registerUser()throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			// if exist
			boolean isExist = isExist(request, this.username);

			if (isExist) {
				this.addActionError(this.getText("register.message.failed"));
			} else {
				insert(request);
				log.info("User " + this.username + " register.");
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

	private boolean isExist(HttpServletRequest request,String name) {
		if (iBaseHibernateBo.isExist(User.class,name)) {
			return true;
		} else {
			return false;
		}
	}

	private void insert(HttpServletRequest request) {
		User user = new User();
		user.setUserName(this.username);
		user.setPassword(this.password1);
		user.setEmail(this.email);
		//userBo.insertUser(user);
	}

	@Override
	public void validate() {
		if (null != this.username && "".equals(this.username)){
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
		}
	}
}

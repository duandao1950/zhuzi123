package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.hibernate.bo.OperatorsBo;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	
	Logger log = Logger.getLogger(this.getClass());
	
	protected OperatorsBo operatorsBo;
	
	public OperatorsBo getOperatorsBo() {
		return operatorsBo;
	}

	public void setOperatorsBo(OperatorsBo operatorsBo) {
		this.operatorsBo = operatorsBo;
	}
	
	//ÍË³ö
	@RequestMapping("/logout")
	public String execute() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		// invalidate the original session if exists
		HttpSession session = request.getSession(false);
		String operatorID = (String)session.getAttribute(Constants.OPERATORSID_KEY);
		if (session != null) {
			session.invalidate();
		}
		
		log.info("Operator ID " + operatorID + " logout.");
		// Finish with
		return Constants.LOGOUT_KEY;
	}
}

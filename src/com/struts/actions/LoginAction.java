package com.struts.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.beans.Privilege;
import com.hibernate.bo.BaseSpringBo;
import com.hibernate.bo.OperatorsBo;
import com.struts.util.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("loginAction")
@RequestMapping("/login")
public class LoginAction extends ActionSupport{

	Logger log = Logger.getLogger(this.getClass());

	protected OperatorsBo operatorsBo;
	
	public OperatorsBo getOperatorsBo() {
		return operatorsBo;
	}

	public void setOperatorsBo(OperatorsBo operatorsBo) {
		this.operatorsBo = operatorsBo;
	}

	protected BaseSpringBo baseSpringBo;
	
	public BaseSpringBo getBaseSpringBo() {
		return baseSpringBo;
	}

	public void setBaseSpringBo(BaseSpringBo baseSpringBo) {
		this.baseSpringBo = baseSpringBo;
	}
	
	protected String operId = "admin";
	
	protected String password = "admin";
	
	private String privilegeId;
	
	private String privilegeName;
	
	private String description;
	
	private String porder;
	
	private String parentPorder;
	
	private String url;
	
	@RequestMapping("")
	public String login()throws Exception {
		UsernamePasswordToken token = new UsernamePasswordToken(this.operId,this.password);
		//记录该令牌，如果不记录则类似购物车功能不能使用。
		token.setRememberMe(false);
		//subject理解成权限对象。类似user
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (UnknownAccountException ex) {//用户名没有找到
			ex.printStackTrace();
		} catch (IncorrectCredentialsException ex) {//用户名密码不匹配
			ex.printStackTrace();
		}catch (AuthenticationException e) {//其他的登录错误
			e.printStackTrace();
		}
		subject.checkPermission("add");
		subject.checkRole("admin");
		if(subject.isPermitted("add")){
			System.out.println("admin");
		}
		
		if(subject.isPermitted("add")){
			System.out.println("add");
		}
		//验证是否成功登录的方法
		if (subject.isAuthenticated()) {
			return Constants.SUCCESS_KEY;
		}
		return Constants.FAILURE_KEY;
		
//		HttpServletRequest request = ServletActionContext.getRequest();
//		// invalidate the original session if exists
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.invalidate();
//		}
//
//		// create a new session for the user
//		session = request.getSession(true);
//
//		boolean isValid = valid(this.operId,this.password);
//		
//		if (isValid) {
//			//List<OperatorRoles> operatorRolesList = baseHibernateBo.findByProperty(OperatorRoles.class, "operId", this.operId);
//			
//			List<Privilege> operPrivilegeList= baseSpringBo.getMenuList(operId);
//			
//			//String sql = "select * from OPER_PRIVILEGE c where c.privilege_id in(select b.privilege_id from oper_roles_relation a,oper_privs b where a.role_id=b.role_id and a.oper_id= '" +this.operId+ "')";
//			//List list = baseHibernateBo.findRelationList(sql);
//			request.setAttribute("operPrivilegeList", operPrivilegeList);
//			session.setAttribute(Constants.OPERATORSID_KEY, operId);
//			log.info("User " + operId + " login.");
//		//	return Constants.SUCCESS_KEY;
//		} else {
//			this.addActionError(this.getText("login.message.failed"));
//		//	return Constants.FAILURE_KEY;
//		}
	}

	//退出
	@RequestMapping("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
	
	public String welcome()throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		String operId = (String)session.getAttribute(Constants.OPERATORSID_KEY);
		if (StringUtils.isNotBlank(operId)){
			List<Privilege> operPrivilegeList= baseSpringBo.getMenuList(operId);
			request.setAttribute("operPrivilegeList", operPrivilegeList);
		}
		return Constants.SUCCESS_KEY;
	}
	
	private boolean valid(String operId, String password) {
		if (operatorsBo.isValid(operId,password)) {
			return true;
		} else {
			return false;
		}
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public String getParentPorder() {
		return parentPorder;
	}

	public void setParentPorder(String parentPorder) {
		this.parentPorder = parentPorder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

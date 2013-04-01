package com.struts.actions;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.common.util.DateUtil;
import com.hibernate.beans.OperatorRoles;
import com.hibernate.beans.Operators;
import com.hibernate.beans.Roles;
import com.hibernate.bo.OperatorsBo;
import com.struts.util.Constants;

/**
 * struts2 ��������ActionForm,����ͨ�����Ե�get/set�������������
 * @author zs
 */
@SuppressWarnings("serial")
public class OperatorAction extends BaseAction {

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * ע��OperatorsBo��������,��DAO����в���
	 * �����ĵ������,��/ɾ/��,�Լ��Զ���SQL��ѯ,�Ѿ���װ���丸���BaseHibernateBo��
	 * һ��ֱ����BaseHibernateBo���ü���
	 * ������Ҫ��չ���߼�������IOperatorsBo�ӿ��ж���,��OperatorsBo��ʵ��
	 * @return
	 */
	protected OperatorsBo operatorsBo;

	public OperatorsBo getOperatorsBo() {
		return operatorsBo;
	}

	public void setOperatorsBo(OperatorsBo operatorsBo) {
		this.operatorsBo = operatorsBo;
	}

	private Integer operCode = null;
	private String operId = null;
	private String operName = null;
	private String isValid = "10002";
	private String password = null;
	private String prePassword = null;
	private String belongTeam = null;
	private String mobilePhone = null;
	private String firstEmail = null;
	private String secondEmail = null;
	private String notesId = null;
	private Date registerTime = null;
	private Date loginTime = null;
	private List rolesId = null;
	
	private Operators operators = null;

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		operators = new Operators();
		operators.setIsValid("10002");
		operators.setBelongTeam("B0001");
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return Constants.LIST_KEY;
	}
	
	/* (non-Javadoc)
	 * @see com.struts.actions.BaseAction#findBeanList()
	 * �˷�����÷�ҳPage����,���ǰ̨��ҳ��ǩһ��ʹ��
	 * <site:page name="page" action="operators_list.action" />
	 * �˷�����Action���ж��ƶ�ȡ,Ȼ�����BaseAction��list����������ת
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// get pager
		return baseHibernateBo.findAll(Operators.class);
	}

	/*
	 * (non-Javadoc)
	 * 1.
	 * oracle���ݿ����������ͨ��ӳ���ȡsequence,��ͨ�����·�ʽ��ȡ
	 * this.id = baseHibernateBo.findSequence(CommonContexts.ADDRESSSEQ);
	 * operators.setId(new Integer(id));
	 * 2.
	 * �˴��ϴ�ֻ�����super.uploadFile()�������,�����ļ�����,�������ݿ�
	 * Ŀǰ�ϴ��ļ������Ŀ¼��apache-tomcat-6.0.18/webapps/demo/upload
	 * @see com.struts.actions.BaseAction#insert()
	 */
	@SuppressWarnings("unchecked")
	public String insert() throws Exception {
		// check if exists
		boolean b = baseHibernateBo.checkExist(Operators.class, "operId", this.operId);
		// insert object
		Operators operators = new Operators();
		operators.setOperId(this.operId);
		operators.setOperName(this.operName);
		operators.setPassword(this.password);
		operators.setIsValid(isValid);
		operators.setRegisterTime(new Date());
		operators.setLoginTime(new Date());
		operators.setBelongTeam(belongTeam);
		operators.setFirstEmail(firstEmail);
		operators.setMobilePhone(mobilePhone);
		operators.setNotesId(notesId);
		operators.setOperCode(operCode);
		operators.setSecondEmail(secondEmail);
		
		if (!b && this.addValidate()) {
			//save object
			baseHibernateBo.save(operators);
			// save messages
			this.addActionMessage(this.getText("change.message.addoredit.success"));
			return Constants.LIST_KEY;
		} else {
			//����Ѿ������ֵ
			this.operators = operators;
			if (operId == null || "".equals(operId)) {
				this.addActionError(this.getText("operators.error.name"));
			}else{
				this.addActionError(this.getText("operators.message.add.failed"));
			}
			return Constants.ADD_KEY;
		}
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String id = request.getParameter("id");

		if (id == null || "".equals(id)) {
			// id not exist, save messages
			this.addActionError(this.getText("operators.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// get object
			Operators operators = (Operators) baseHibernateBo.findById(Operators.class,new Integer(id));

			if (operators == null) {
				this.addActionError(this.getText("operators.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.operators = operators;
		}
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception {
		Operators operators = new Operators();
		operators.setOperId(this.operId);
		operators.setOperName(this.operName);
		operators.setPassword(this.password);
		operators.setIsValid(isValid);
		operators.setRegisterTime(new Date());
		operators.setLoginTime(new Date());
		operators.setBelongTeam(belongTeam);
		operators.setFirstEmail(firstEmail);
		operators.setMobilePhone(mobilePhone);
		operators.setNotesId(notesId);
		operators.setOperCode(operCode);
		operators.setSecondEmail(secondEmail);
		
		if (this.addValidate()){
			// update object
			baseHibernateBo.saveOrUpdate(operators);
			// save messages
			this.addActionMessage(this.getText("operators.message.edit.success"));
		}else{
			this.operators = operators;
			return Constants.EDIT_KEY;
		}
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String delete() throws Exception {
		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			this.addActionMessage(this.getText("operators.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// delete object
			baseHibernateBo.delete(Operators.class, new Integer(id));

			// save messages
			this.addActionMessage(this.getText("operators.message.delete.success"));
		}
		return Constants.OPERATOR_RESULT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String operatorRolesRelationEdit() throws Exception {
		String id = request.getParameter("id");
		String operId = request.getParameter("operId");
		if (id == null || "".equals(id)) {
			// id not exist, save messages
			this.addActionError(this.getText("operators.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// get object
			Operators operators = (Operators) baseHibernateBo.findById(Operators.class,new Integer(id));

			if (operators == null) {
				this.addActionError(this.getText("operators.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.operators = operators;
		}
		
		List operatorRolesList = baseSpringBo.getRolesByOperId(operId);
		List<Roles> roleList = baseHibernateBo.findAllOrderbyProperty(Roles.class,"orderNumber");
		request.setAttribute("operatorRolesList", operatorRolesList);
		request.setAttribute("roleList", roleList);
		return Constants.EDIT_KEY;
	}
	
	@SuppressWarnings("unchecked")
	public String operatorRolesRelationUpdate() throws Exception {
		//����û����н�ɫ
		List operatorRolesList = baseSpringBo.getRolesByOperId(this.operId);
		//������ɫ�����н�ɫ�Ա�,�õ��û��˴β���ʧȥ�Ľ�ɫ�������Ľ�ɫ,��������Ա���ɫ�Ĺ�ϵ
		if (rolesId != null && rolesId.size()>0){
			List operRolesRelation = (List) CollectionUtils.intersection(operatorRolesList,rolesId);
			rolesId.removeAll(operRolesRelation);
			operatorRolesList.removeAll(operRolesRelation);
			for (int i=0;i<rolesId.size();i++){
				OperatorRoles operatorRoles = new OperatorRoles();
				operatorRoles.setOperId(this.operId);
				operatorRoles.setRoleId(new Integer(rolesId.get(i).toString()));
				baseHibernateBo.save(operatorRoles);
			}
		}
		
		for (int i=0;i<operatorRolesList.size();i++){
			baseSpringBo.deleteOperatorRolesRelation(this.operId,new Integer(operatorRolesList.get(i).toString()));
		}
		return Constants.LIST_KEY;
	}
	
	public boolean addValidate() {
		boolean validFlag = true;
		
		if (null == this.operId || "".equals(this.operId)){
			this.addActionError("the user name is require!");
			validFlag = false;
		}
		
		if (null == this.password || "".equals(this.password)){
			this.addActionError("the password is require!");
			validFlag = false;
		}
		
		if (null == this.prePassword || "".equals(this.prePassword)){
			this.addActionError("the Confirm password is require!");
			validFlag = false;
		}
		
		if (null != this.prePassword){
			if (!this.prePassword.equals(this.password)){
				this.addActionError("the Confirm password must be equals password!");
				validFlag = false;
			}
		}
		
		if (null == this.mobilePhone || "".equals(this.mobilePhone)){
			this.addActionError("the mobile phone is require!");
			validFlag = false;
		}
		
		return validFlag;
	}
	
	public Object getModel() {
		operators = new Operators();
		return operators;
	}

	public Integer getOperCode() {
		return operCode;
	}

	public void setOperCode(Integer operCode) {
		this.operCode = operCode;
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

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Operators getOperators() {
		return operators;
	}

	public void setOperators(Operators operators) {
		this.operators = operators;
	}

	public List getRolesId() {
		return rolesId;
	}

	public void setRolesId(List rolesId) {
		this.rolesId = rolesId;
	}

	public String getPrePassword() {
		return prePassword;
	}

	public void setPrePassword(String prePassword) {
		this.prePassword = prePassword;
	}

	public String getBelongTeam() {
		return belongTeam;
	}

	public void setBelongTeam(String belongTeam) {
		this.belongTeam = belongTeam;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getFirstEmail() {
		return firstEmail;
	}

	public void setFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}

	public String getNotesId() {
		return notesId;
	}

	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}
}
	



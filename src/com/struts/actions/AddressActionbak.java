package com.struts.actions;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.hibernate.beans.Address;
import com.hibernate.bo.AddressBo;
import com.struts.util.Constants;

/**
 * struts2 基本不用ActionForm,都是通过属性的get/set方法来填充属性
 * @author zs
 */
@SuppressWarnings("serial")
public class AddressActionbak extends BaseAction {

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 注入AddressBo服务层对象,对DAO层进行操纵
	 * 大量的单表操作,增/删/改,以及自定制SQL查询,已经封装在其父类的BaseHibernateBo中
	 * 一般直接用BaseHibernateBo调用即可
	 * 对于需要扩展的逻辑可以在IAddressBo接口中定义,在AddressBo中实现
	 * @return
	 */
	protected AddressBo addressBo;

	public AddressBo getAddressBo() {
		return addressBo;
	}

	public void setAddressBo(AddressBo addressBo) {
		this.addressBo = addressBo;
	}

	protected String id = null;

	protected String name = null;

	protected String sex = null;

	protected String mobile = null;

	protected String email = null;

	protected String qq = null;

	protected String company = null;

	protected String address = null;

	protected String postcode = null;

	protected Date updateDate = null;
	
	private Address address_obj = null;

	/* (non-Javadoc)
	 * @see com.struts.actions.BaseAction#findBeanList()
	 * 此方法获得分页Page对象,结合前台分页标签一起使用
	 * <site:page name="page" action="address_list.action" />
	 * 此方法对Action进行定制读取,然后调用BaseAction中list方法进行跳转
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// get pager
		return baseHibernateBo.findAllByUsername(Address.class, operId);
	}

	/*
	 * (non-Javadoc)
	 * 1.
	 * oracle数据库中如果不想通过映射获取sequence,可通过如下方式获取
	 * this.id = baseHibernateBo.findSequence(CommonContexts.ADDRESSSEQ);
	 * address.setId(new Integer(id));
	 * 2.
	 * 此处上传只需调用super.uploadFile()这个方法,返回文件名称,保存数据库
	 * 目前上传文件保存的目录是apache-tomcat-6.0.18/webapps/demo/upload
	 * @see com.struts.actions.BaseAction#insert()
	 */
	@SuppressWarnings("unchecked")
	public String insert() throws Exception {
		// check if exists
		boolean b = baseHibernateBo.isExist(Address.class, operId, this.name);
		
		// insert object
		Address address = new Address();
		address.setUsername(operId);
		address.setName(this.name);
		address.setSex(this.sex);
		address.setMobile(this.mobile);
		address.setEmail(this.email);
		address.setQq(this.qq);
		address.setCompany(this.company);
		address.setAddress(this.address);
		address.setPostcode(this.postcode);
		address.setUpdateDate(this.updateDate);
		String filepath = super.uploadFile();
		address.setFilepath(filepath);
		
		if (!b) {
			//save object
			baseHibernateBo.save(address);
			// save messages
			this.addActionMessage(this.getText("change.message.addoredit.success"));
			return Constants.OPERATOR_RESULT_KEY;
		} else {
			//填充已经输入的值
			address_obj = address;
			if (name == null || "".equals(name)) {
				this.addActionError(this.getText("address.error.name"));
			}else{
				this.addActionError(this.getText("address.message.add.failed"));
			}
			return Constants.ADD_KEY;
		}
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String id = request.getParameter("id");

		if (id == null || "".equals(id)) {
			// id not exist, save messages
			this.addActionError(this.getText("address.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// get object
			Address address = (Address) baseHibernateBo.findById(Address.class,
					new Integer(id));

			if (address == null) {
				this.addActionError(this.getText("address.message.edit.notexist"));
				return Constants.LIST_KEY;
			}

			this.address_obj = address;
		}
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception {
		Address address = new Address();
		address.setUsername(operId);
		address.setId(new Integer(this.id));
		address.setName(this.name);
		address.setSex(this.sex);
		address.setMobile(this.mobile);
		address.setEmail(this.email);
		address.setQq(this.qq);
		address.setCompany(this.company);
		address.setAddress(this.address);
		address.setPostcode(this.postcode);
		address.setUpdateDate(this.updateDate);
		String filepath = super.uploadFile();
		address.setFilepath(filepath);
		
		// update object
		baseHibernateBo.saveOrUpdate(address);

		// save messages
		this.addActionMessage(this.getText("address.message.edit.success"));

		return Constants.OPERATOR_RESULT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String delete() throws Exception {
		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			this.addActionMessage(this.getText("address.message.edit.notexist"));
			return Constants.LIST_KEY;
		} else {
			// delete object
			baseHibernateBo.delete(Address.class, new Integer(id));

			// save messages
			this.addActionMessage(this.getText("address.message.delete.success"));
		}
		return Constants.OPERATOR_RESULT_KEY;
	}

	@SuppressWarnings("unchecked")
	public String showDilog() throws Exception {
		return "showDilog";
	}

	
	public Object getModel() {
		address_obj = new Address();
		return address_obj;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Address getAddress_obj() {
		return address_obj;
	}

	public void setAddress_obj(Address address_obj) {
		this.address_obj = address_obj;
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
	}

	@Override
	public String back() throws Exception {
		// TODO Auto-generated method stub
		return Constants.LIST_KEY;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}

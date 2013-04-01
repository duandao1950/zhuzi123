package com.struts.actions;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.common.util.CommonDicContexts;
import com.common.util.DateUtil;
import com.hibernate.beans.Address;
import com.hibernate.bo.AddressBo;

/**
 * struts2 基本不用ActionForm,都是通过属性的get/set方法来填充属性
 * 采用ajax方式都是通过get方式传值,即Action中定制的setAllParameter方法
 * struts_address_ajax.xml 配置的都是父类BaseAjaxAction的method逻辑
 * 子类的所有方法都是定制所用
 * @author zs
 */
@SuppressWarnings("serial")
public class AddressAjaxAction extends BaseAjaxAction {

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

	/* (non-Javadoc)
	 * @see com.struts.actions.BaseAction#findBeanList()
	 * 此方法获得分页Page对象,结合前台分页标签一起使用
	 * <site:page name="page" action="address_list.action" />
	 * 此方法对Action进行定制读取,然后调用BaseAction中list方法进行跳转
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// get pager
		List<Address> list = baseHibernateBo.findAllByUsername(Address.class, operId);
		//定制改造显示列表,比如：<site:baseSelect property="sex" id="sex" tableName="DIC_SEX" defaultValue="S0001"/>
		//页面时使用了自定制标签显示下拉框,在table中显示的时候会存在只显示键值的情况,此处定制修改
		for(Address address : list){
			String sexLabel = baseSpringBo.loadDicContent(CommonDicContexts.DIC_SEX, address.getSex());
			address.setSexLabel(sexLabel);
			String filePathPreview = address.getFilepath();
			if (StringUtils.isNotBlank(filePathPreview)){
				if (filePathPreview.indexOf(":") != -1){
					address.setFilepathPreview(StringUtils.substringBefore(filePathPreview, ":"));
				}else{
					address.setFilepathPreview(filePathPreview);
				}
			}
		}
		return list;
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
	public void saveOrUpdate() throws Exception {
		Address address = this.setAllParameter();
		baseHibernateBo.saveOrUpdate(address);
	}

	@SuppressWarnings("unchecked")
	public Address edit(String id) throws Exception {
		Address address = (Address) baseHibernateBo.findById(Address.class,
				new Integer(id));
		return address;
	}

	@SuppressWarnings("unchecked")
	public void delete(String id) throws Exception {
		baseHibernateBo.delete(Address.class, new Integer(id));
	}

	public Address setAllParameter() throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String company = request.getParameter("company");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String updateDateStr = request.getParameter("updateDate");

		Date updateDate = DateUtil.stringDate(updateDateStr + " 00:00:00");
		
		Address addressParameter = new Address();
		addressParameter.setUsername(operId);
		if (StringUtils.isNotBlank(id)){
			addressParameter.setId(new Integer(id));
		}
		addressParameter.setName(name);
		addressParameter.setSex(sex);
		addressParameter.setMobile(mobile);
		addressParameter.setEmail(email);
		addressParameter.setQq(qq);
		addressParameter.setCompany(company);
		addressParameter.setAddress(address);
		addressParameter.setPostcode(postcode);
		addressParameter.setUpdateDate(updateDate);
		//多附件上传,结合<site:upload/>多附件上传标签一起使用
		String[] fileArray = request.getParameterValues("file");
		String filepath = super.uploadFileAjax(fileArray);
		addressParameter.setFilepath(filepath);
		
		return addressParameter;
	}
}

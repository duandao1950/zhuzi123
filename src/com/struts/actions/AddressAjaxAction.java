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
 * struts2 ��������ActionForm,����ͨ�����Ե�get/set�������������
 * ����ajax��ʽ����ͨ��get��ʽ��ֵ,��Action�ж��Ƶ�setAllParameter����
 * struts_address_ajax.xml ���õĶ��Ǹ���BaseAjaxAction��method�߼�
 * ��������з������Ƕ�������
 * @author zs
 */
@SuppressWarnings("serial")
public class AddressAjaxAction extends BaseAjaxAction {

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * ע��AddressBo��������,��DAO����в���
	 * �����ĵ������,��/ɾ/��,�Լ��Զ���SQL��ѯ,�Ѿ���װ���丸���BaseHibernateBo��
	 * һ��ֱ����BaseHibernateBo���ü���
	 * ������Ҫ��չ���߼�������IAddressBo�ӿ��ж���,��AddressBo��ʵ��
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
	 * �˷�����÷�ҳPage����,���ǰ̨��ҳ��ǩһ��ʹ��
	 * <site:page name="page" action="address_list.action" />
	 * �˷�����Action���ж��ƶ�ȡ,Ȼ�����BaseAction��list����������ת
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// get pager
		List<Address> list = baseHibernateBo.findAllByUsername(Address.class, operId);
		//���Ƹ�����ʾ�б�,���磺<site:baseSelect property="sex" id="sex" tableName="DIC_SEX" defaultValue="S0001"/>
		//ҳ��ʱʹ�����Զ��Ʊ�ǩ��ʾ������,��table����ʾ��ʱ������ֻ��ʾ��ֵ�����,�˴������޸�
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
	 * oracle���ݿ����������ͨ��ӳ���ȡsequence,��ͨ�����·�ʽ��ȡ
	 * this.id = baseHibernateBo.findSequence(CommonContexts.ADDRESSSEQ);
	 * address.setId(new Integer(id));
	 * 2.
	 * �˴��ϴ�ֻ�����super.uploadFile()�������,�����ļ�����,�������ݿ�
	 * Ŀǰ�ϴ��ļ������Ŀ¼��apache-tomcat-6.0.18/webapps/demo/upload
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
		//�฽���ϴ�,���<site:upload/>�฽���ϴ���ǩһ��ʹ��
		String[] fileArray = request.getParameterValues("file");
		String filepath = super.uploadFileAjax(fileArray);
		addressParameter.setFilepath(filepath);
		
		return addressParameter;
	}
}

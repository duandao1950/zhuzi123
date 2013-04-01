package com.struts.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.common.page.Page;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hibernate.beans.Address;
import com.hibernate.bo.AddressBo;
import com.opensymphony.xwork2.Action;
import com.struts.util.Constants;

/**
 * struts2 基本不用ActionForm,都是通过属性的get/set方法来填充属性
 * @author zs
 */
@SuppressWarnings("serial")
public class AddressAction extends BaseAction {

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
	
	private static Integer NUM = 100;
	
	/*private Map json = new HashMap(); 
	
	private Integer toPage;
	
	private Integer pageSize;
	
	private String keyword;
	
	private String page;
	
	private String rows;*/
	
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
		address.setUpdateDate(new Date());
		String filepath = super.uploadFile();
		address.setFilepath(filepath);
		
		if (!b) {
			//save object
			baseHibernateBo.saveOrUpdate(address);
			// save messages
			this.addActionMessage(this.getText("change.message.addoredit.success"));
			return Constants.LIST_KEY;//Constants.OPERATOR_RESULT_KEY;
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

	public String insertAjax() throws Exception {
		// insert object
		Address address = this.setAllParameter();
		baseHibernateBo.saveOrUpdate(address);

		super.list();
		return Constants.LIST_KEY;
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
	
	public void editAjax() throws Exception {
		String id = request.getParameter("id");

		response.setContentType("text/plain; charset=utf-8");
        PrintWriter out = response.getWriter();
        String result = "";
		if (id == null || "".equals(id)) {
			// id not exist, save messages
			out.print("error");
		} else {
			// get object
			Address address = (Address) baseHibernateBo.findById(Address.class,
					new Integer(id));

			if (address == null) {
			}

			Gson gson = new Gson();
			this.address_obj = address;
			
			result = gson.toJson(address);
		}
		out.print(result);
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
	
	public void updateAjax() throws Exception {
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
		return Constants.LIST_KEY;
	}

	public String deleteAjax() throws Exception {
		String id = request.getParameter("id");
		response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
		if (id == null) {
			// if id not exist
			out.print("error");
		} else {
			// delete object
			baseHibernateBo.delete(Address.class, new Integer(id));
		}
        out.print(id);
        return Constants.LIST_KEY;
	}
	
	/*public void findJsonData() throws Exception{
		list = this.findBeanList();

		if(page==null) page ="1";
		if(rows==null) rows ="40";
		
		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, new Integer(this.page), new Integer(rows));
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}
		
		PrintWriter out = response.getWriter();
		
		int rowsInt=Integer.parseInt(rows);
		int totalRows = list.size();
		int totalPages =(int)Math.floor( (double)totalRows/(double)rowsInt+1);
		try {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("page", ""+page);
			obj.addProperty("total",totalPages);
			obj.addProperty("records",""+totalRows);
			
			JsonArray lineitemArray = new JsonArray();
			Address address = new Address();
			
			Iterator it = beanList.iterator();
			int no=0;

			while (it.hasNext()) {
				no++;
				address = (Address) it.next();
				JsonObject objlineitem = new JsonObject();			
				objlineitem.addProperty("id",address.getId());
				objlineitem.addProperty("name", address.getName());
				objlineitem.addProperty("sex", address.getSex());  //fake data, so sorting won't works on this column
				objlineitem.addProperty("email",address.getEmail());
				objlineitem.addProperty("compay", address.getCompany());
				objlineitem.addProperty("address", address.getAddress());
				objlineitem.addProperty("postcode", address.getPostcode());
				
				lineitemArray.add(objlineitem);
			}
			obj.add("rows", lineitemArray);
			out.print(obj.toString());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String findData() throws Exception{
		
		toPage = (toPage == null) ?  1 : toPage ;
		
		pageSize = (pageSize == null) ?  7 : pageSize ;

		Integer start = (toPage - 1)*pageSize;
		Integer end = toPage*pageSize;
		
		List list = baseHibernateBo.findAllByUsername(Address.class, "admin");

		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, start, end);
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}

		Gson gson = new Gson();
		String result = gson.toJson(beanList);
		
//		System.out.println(result1);
//		
//		Type typeOfSrc = new TypeToken<List<Address>>(){}.getType();
//
//		String result = gson.toJson(list1,typeOfSrc);
		
		json.put("data", result);
		json.put("totalRecord",list.size());

//		String id = request.getParameter("id");
//		response.setContentType("appliaction/json; charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.print(result);
//        out.print(id);
		return Action.SUCCESS;
	}
	
	public String page() throws Exception{
		toPage = (toPage == null) ?  1 : toPage ;
		pageSize = (pageSize == null) ?  7 : pageSize ;
		Integer start = (toPage - 1)*pageSize;
		Integer end = toPage*pageSize;
		List list = baseHibernateBo.findAllByUsername(Address.class, "admin");

		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, start, end);
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}

		Gson gson = new Gson();
		String result = gson.toJson(beanList);
		json.put("data", result);
		json.put("totalRecord",list.size());
		return Action.SUCCESS;
	}
	
	public String findData1(){
		List<String []> list = new ArrayList<String []>();
		
		for(int i=0;i<NUM;i++){
			list.add(new String[]{"公司" + i,"www.add"+i + ".com","2"+i,"3"+i});
		}
		
		toPage = (toPage == null) ?  1 : toPage ;
		
		pageSize = (pageSize == null) ?  10 : pageSize ;
		
		if(toPage < 1){
			toPage = 1;
		}
		if(pageSize < 1){
			pageSize = 10;
		}
		
		Integer start = (toPage - 1)*pageSize;
		Integer end = toPage*pageSize;
		int c = 0 ;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			if(keyword != null && strings[0].indexOf(keyword) == -1){
				c ++;
				iterator.remove();
			}
		}
		String[][] data = null;

		if(start > NUM -c){
			json.put("data", data);
			json.put("totalRecord", 0);
			return Action.SUCCESS;
		}
		
		if(end > NUM -c)end = NUM -c;
		List<String []> list1 = list.subList(start, end);
		
		data = list1.toArray(new String[list1.size()][4]);
		
		json.put("data", data);
		json.put("totalRecord", NUM - c);
		
		return Action.SUCCESS;
	}*/
	
	public void submitAjax() throws Exception {
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.print("is OK!");
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
		
		Address addressParameter = new Address();
		
		addressParameter.setUsername(operId);
		if (StringUtils.isNotBlank(this.id)){
			addressParameter.setId(new Integer(this.id));
		}
		addressParameter.setName(this.name);
		addressParameter.setSex(this.sex);
		addressParameter.setMobile(this.mobile);
		addressParameter.setEmail(this.email);
		addressParameter.setQq(this.qq);
		addressParameter.setCompany(this.company);
		addressParameter.setAddress(this.address);
		addressParameter.setPostcode(this.postcode);
		addressParameter.setUpdateDate(this.updateDate);
		String filepath = super.uploadFile();
		addressParameter.setFilepath(filepath);

		return addressParameter;
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

	public static Integer getNUM() {
		return NUM;
	}

	public static void setNUM(Integer num) {
		NUM = num;
	}

	/*public Map getJson() {
		return json;
	}

	public void setJson(Map json) {
		this.json = json;
	}

	public Integer getToPage() {
		return toPage;
	}

	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}*/

	public List getBeanList() {
		return beanList;
	}

	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}

	/*public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}*/
}

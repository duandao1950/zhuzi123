package com.struts.actions;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.common.page.Page;
import com.common.util.CommonContexts;
import com.common.util.ExcelExport;
import com.common.util.UploadUtils;
import com.google.gson.Gson;
import com.hibernate.beans.Privilege;
import com.hibernate.bo.BaseHibernateBo;
import com.hibernate.bo.BaseSpringBo;
import com.struts.util.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * BaseAction 说明： 1.request对象已经在此类由容器注入,子类Action将不需要再次关心request对象如何获取
 * 2.baseHibernateBo 此类包含所有基础的操作DAO的方法,子类Action可以直接使用也可以继承扩展自己的服务层
 * 3.上传,下载功能在此类中已经包含,子类Action只需关心对应的struts.xml配置，直接调用,不需要再添加逻辑
 * 4.包含所有基本的跳转index、list、add、edit 5.操作员的获取getUsername() 6.AddressAction
 * 运用的demo,所有基础操作可按此类来做
 * 
 * @author zs
 */
@SuppressWarnings("serial")
abstract public class BaseAction extends ActionSupport implements Action,
		ServletRequestAware, ServletResponseAware, Preparable {

	/**
	 * 通过spring的配置文件注入BaseHibernateBo服务层对象,对DAO层进行操纵 封装了大量的单表操作,增/删/改,以及自定制SQL查询
	 * 一般继承的子类Action可直接用BaseHibernateBo操纵数据库
	 * 对于需要新增的基类逻辑可以在IBaseHibernateBo接口中定义,在BaseHibernateBo中实现
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BaseHibernateBo baseHibernateBo;

	@SuppressWarnings("unchecked")
	public BaseHibernateBo getBaseHibernateBo() {
		return baseHibernateBo;
	}

	@SuppressWarnings("unchecked")
	public void setBaseHibernateBo(BaseHibernateBo baseHibernateBo) {
		this.baseHibernateBo = baseHibernateBo;
	}

	/**
	 * 通过spring的配置文件注入BaseSpringBo服务层对象,对DAO层进行操纵
	 * 此DAO为Hibernate服务层辅助对象,对于复杂的SQL关系,不想配置繁琐复杂的映射关系可采用此类直接用SQL操作数据库表之间的关系
	 * 一般继承的子类Action可直接用BaseSpringBo操纵数据库
	 * 对于需要新增的基类逻辑可以在BaseSpringBo接口中定义,在BaseSpringBo中实现
	 * 
	 * @return
	 */
	protected BaseSpringBo baseSpringBo;
	
	public BaseSpringBo getBaseSpringBo() {
		return baseSpringBo;
	}

	public void setBaseSpringBo(BaseSpringBo baseSpringBo) {
		this.baseSpringBo = baseSpringBo;
	}
	
	/*
	 * (non-Javadoc) @ time 2011-03-19
	 * 
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 *      利用ServletRequestAware接口依赖容器注入的方式从baseAction获取request对象
	 *      避免子类action频繁获取request对象,这是资料建议不使用的方法,是一种侵入式的做法
	 *      考虑框架的搭建而使用,一般采用非耦合方式获取request对象, 如下：HttpServletRequest request =
	 *      ServletActionContext.getRequest();
	 */
	public HttpServletRequest request = null;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse response = null;

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 预加载首先获取登陆的操作员,子类Action中将不重复获取，直接取属性名称即可
	 */
	protected String operId = null;

	/**
	 * 此方法接受struts.xml中的参数值获取具体行为操作 由于struts2本身有一个BUG,但不影响执行结果,采用另外的方法解决,暂时弃用,预留
	 */
	private String methodParamter = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.struts.actions.BaseAction#findBeanList()
	 *      此方法获得分页Page对象,结合前台分页标签一起使用 <site:page name="page"
	 *      action="address_list.action" />
	 *      此方法对Action进行定制读取,然后调用BaseAction中list方法进行跳转
	 *      页面自动获取beanList,参考address.jsp示例：<s:iterator value="beanList"
	 *      status="addressNo">
	 */
	@SuppressWarnings("unchecked")
	public List beanList = null;

	protected List list = null;

	/**
	 * 以下6个参数都与上传下载相关 1.DOWNLOADFILEPATH 上传/下载文件服务器原始存放路径 2.fileName 下载时用文件名
	 * 3.saveDestFile 上传文件返回的值,就是文件名称,可能是对个 4.file 多文件上传集合 struts2框架固定参数
	 * 5.fileFileName 多文件上传文件名称集合 struts2框架固定参数 6.fileContentType 多文件上传文类型
	 * struts2框架固定参数,可以在对应的struts.xml文件中匹配到
	 */

	protected String fileName = null;

	protected String[] saveDestFile = null;

	private List<File> file = null;

	private List<String> fileFileName = null;

	private List<String> fileContentType = null;

	private InputStream stream;

	private String realPath = "";
	
	private Integer toPage;
	
	private Integer pageSize;
	
	private Map json = new HashMap(); 

	/*
	 * (non-Javadoc) @time 2011-03-19
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 *      实现Preparable接口,预加载方法,框架搭建预留使用
	 */
	public void prepare() throws Exception {
		String actionPath = request.getRequestURI();
		String localName = request.getContextPath() + "/";
		if (actionPath.indexOf(".action") != -1) {
			String action = StringUtils.substringBetween(actionPath, localName,
					".action");
			request.setAttribute("action", action);
			String actionForward = StringUtils.substringBetween(actionPath,
					localName, "_");
			request.setAttribute("actionForward", "'" + actionForward + "_list"
					+ "'");
		}
		operId = this.getUsername();
        
		if (StringUtils.isNotBlank(operId)){
			List<Privilege> operPrivilegeList = baseSpringBo.getMenuList(operId);
			request.setAttribute("operPrivilegeList", operPrivilegeList);
		}
		
		realPath = request.getRealPath(CommonContexts.DOWNLOADFILEPATH);
	}

	/**
	 * get username from session
	 * 
	 * @param request
	 * @return
	 */
	protected String getUsername() {
		return (String) request.getSession().getAttribute(
				Constants.OPERATORSID_KEY);
	}

	/**
	 * check if user is timeout
	 * 
	 * @param request
	 * @return
	 */
	protected boolean isTimeout() {
		if (request.getSession().getAttribute(Constants.OPERATORSID_KEY) == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * save object in session
	 * 
	 * @param request
	 * @param key
	 * @param obj
	 */
	protected void setSession(String key, Object obj) {
		request.getSession().setAttribute(key, obj);
	}

	/*
	 * check if obj exists in session
	 */
	protected boolean isExistSession(String key) {
		if (request.getSession().getAttribute(key) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * get object from session
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	protected Object getSession(String key) {
		return request.getSession().getAttribute(key);
	}

	/**
	 * 默认分页List方法,暂时采用假分页,以后优化
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		if (isTimeout()) {
			return Constants.INDEX_KEY;
		}

		String startStr = request.getParameter("start");
		String pageRowStr = request.getParameter("pageRows");

		startStr = (startStr == null || "".equals(startStr)) ? "0" : startStr;
		int start = startStr.equals("0") ? 0 : Integer.parseInt(startStr);
		// 每页显示行数
		pageRowStr = (pageRowStr == null || "".equals(pageRowStr)) ? "16"
				: pageRowStr;
		int count = Integer.parseInt(pageRowStr);

		list = this.findBeanList();

		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, start, count);
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}

		// 此方法接受struts.xml中的参数值获取具体行为操作
		// 由于struts2本身有一个BUG,但不影响执行结果,采用另外的方法解决,暂时弃用,预留
		/*
		 * String methodParamter = request.getParameter("methodParamter"); if
		 * (StringUtils.isNotBlank(methodParamter)){
		 * this.addActionMessage(this.getText("change.message.addoredit.success")); }
		 */
		// set addressList
		request.setAttribute("page", page);
		return Constants.LIST_KEY;
	}
	
	/**
	 * sitemesh框架能够给统一样式,但是带来的问题是不能局部刷新,此处采用Ajax分页
	 * 默认分页List方法,暂时采用假分页,以后优化
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String listAjax() throws Exception {
		if (isTimeout()) {
			return Constants.INDEX_KEY;
		}
		//导出当前页所用参数
		String curentPageKey = request.getParameter("start");
		if (StringUtils.isNotBlank(curentPageKey)){
			toPage = new Integer(curentPageKey);
		}
		
		toPage = (toPage == null) ?  1 : toPage ;
		pageSize = (pageSize == null) ?  10 : pageSize ;

		Integer start = (toPage - 1)*pageSize;
		Integer end = toPage*pageSize;
			
		list = this.findBeanList();

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

	public String listInit() throws Exception {
		return Action.SUCCESS;
	}
	
	/**
	 * 导出List方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel() throws Exception {
		String sheetName = request.getParameter("sheetName");
		String exportResult = request.getParameter(CommonContexts.EXPORTRESULT_CURRENTPAGE);
		if (StringUtils.isBlank(sheetName)) {
			sheetName = request.getLocalName();
		}
		this.list();
		String exportPatch = realPath + "\\" + sheetName
				+ CommonContexts.FILENAME_EXCEL2003;
		ExcelExport excelExport = new ExcelExport();
		if (CommonContexts.EXPORTRESULT_CURRENTPAGE.equals(exportResult)) {
			excelExport.exportExcel(sheetName, beanList, exportPatch, response);
		} else {
			excelExport.exportExcel(sheetName, list, exportPatch, response);
		}
	}

	/**
	 * 导出List方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(String sheetName) throws Exception {
		String exportResult = request.getParameter(CommonContexts.EXPORTRESULT_CURRENTPAGE);
		if (StringUtils.isBlank(sheetName)) {
			sheetName = request.getLocalName();
		}
		this.list();
		String exportPatch = realPath + "\\" + sheetName
				+ CommonContexts.FILENAME_EXCEL2003;
		ExcelExport excelExport = new ExcelExport();
		if (CommonContexts.EXPORTRESULT_CURRENTPAGE.equals(exportResult)) {
			excelExport.exportExcel(sheetName, beanList, exportPatch, response);
		} else {
			excelExport.exportExcel(sheetName, list, exportPatch, response);
		}
	}

	/**
	 * 导出List方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void ajaxExportExcel() throws Exception {
		String sheetName = request.getParameter("sheetName");
		String exportResult = request.getParameter(CommonContexts.EXPORTRESULT_CURRENTPAGE);
		if (StringUtils.isBlank(sheetName)) {
			sheetName = request.getLocalName();
		}
		String curentPageKey = request.getParameter("start");
		this.listAjax();
		String exportPatch = realPath + "\\" + sheetName
				+ CommonContexts.FILENAME_EXCEL2003;
		ExcelExport excelExport = new ExcelExport();
		if (CommonContexts.EXPORTRESULT_CURRENTPAGE.equals(exportResult)) {
			excelExport.exportExcel(sheetName, beanList, exportPatch, response);
		} else {
			excelExport.exportExcel(sheetName, list, exportPatch, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	public abstract List findBeanList() throws Exception;

	/**
	 * 返回逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String back() throws Exception;

	/**
	 * 添加逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String add() throws Exception;

	/**
	 * 保存逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String insert() throws Exception;

	/**
	 * 编辑逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String edit() throws Exception;

	/**
	 * 更新逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String update() throws Exception;

	/**
	 * 删除逻辑的默认跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String delete() throws Exception;

	/**
	 * 多附件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String uploadFile() throws Exception {
		return UploadUtils.uploadFile(file, fileFileName, realPath);
	}

	/**
	 * 多附件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String uploadFileAjax(List<File> file,List<String> fileFileName) throws Exception {
		return UploadUtils.uploadFile(file, fileFileName, realPath);
	}
	/**
	 * @time 2011-03-22 下载附件,包括三个方法 结合struts.xml文件方法执行顺序如下：
	 *       downLoadFile->getDownloadFile->getDownloadChineseFileName
	 * @return
	 * @throws Exception
	 */
	public String downLoadFile() throws Exception {
		if (isTimeout()) {
			return Constants.INDEX_KEY;
		}
		if (StringUtils.isBlank(fileName)) {
			return INPUT;
		}
		return SUCCESS;
	}

	// 从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(
				CommonContexts.DOWNLOADFILEPATH + fileName);
	}

	// 如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName() throws Exception {
		return (fileName != null && !"".equals(fileName)) ? new String(fileName
				.getBytes(), "UTF-8") : "";
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	@SuppressWarnings("unchecked")
	public List getBeanList() {
		return beanList;
	}

	@SuppressWarnings("unchecked")
	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMethodParamter() {
		return methodParamter;
	}

	public void setMethodParamter(String methodParamter) {
		this.methodParamter = methodParamter;
	}

	public InputStream getImageStream() {
		return stream;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
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

	public Map getJson() {
		return json;
	}

	public void setJson(Map json) {
		this.json = json;
	}
}

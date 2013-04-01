package com.struts.actions;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.common.page.Page;
import com.common.util.CommonContexts;
import com.common.util.CommonUtils;
import com.common.util.ExcelExport;
import com.common.util.UploadUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
abstract public class BaseAjaxAction extends ActionSupport implements Action,
		ServletRequestAware, ServletResponseAware, Preparable {

	Logger log = Logger.getLogger(this.getClass());
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
	
	@SuppressWarnings("unchecked")
	public List beanList = null;

	@SuppressWarnings("unchecked")
	protected List list = null;

	private Integer toPage;
	
	private Integer pageSize;
	
	@SuppressWarnings("unchecked")
	private Map json = new HashMap(); 

	/*
	 * (non-Javadoc) @time 2011-03-19
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 *      实现Preparable接口,预加载方法,框架搭建预留使用
	 */
	public void prepare() throws Exception {
		operId = this.getUsername();
        
		if (StringUtils.isNotBlank(operId)){
			List<Privilege> operPrivilegeList = baseSpringBo.getMenuList(operId);
			request.setAttribute("operPrivilegeList", operPrivilegeList);
		}
	}

	@SuppressWarnings("unchecked")
	public abstract List findBeanList() throws Exception;
	
	@SuppressWarnings("unchecked")
	public abstract void saveOrUpdate() throws Exception;
	
	@SuppressWarnings("unchecked")
	public abstract Object edit(String id) throws Exception;
	
	@SuppressWarnings("unchecked")
	public abstract void delete(String id) throws Exception;
	
	@SuppressWarnings("unchecked")
	public abstract Object setAllParameter() throws Exception;
	
	@SuppressWarnings("unchecked")
	public void saveOrUpdateAjax() throws Exception{
		// insert object
        StringBuffer result = new StringBuffer();
		try{
			this.saveOrUpdate();
			result.append("success");
		}catch(Exception e){
			result.append("操作错误：\r");
			for(int i=0;i<e.getStackTrace().length;i++){
				if (i>15){
					break;
				}
				result.append(e.getStackTrace()[i].toString()+"\r");
			}
			log.debug("saveOrUpdateAjax:"+e);
		}
		
		CommonUtils.outPrintWriterToResult(response, result.toString());
	}
	
	@SuppressWarnings("unchecked")
	public void editAjax() throws Exception{
		String id = request.getParameter("id");
        String result = "";
		if (id == null || "".equals(id)) {
			// id not exist, save messages
			result = "Please select a record!";
			log.debug("editAjax: Please select a record!");
		} else {
			// get object
			Object object = this.edit(id);

			if (object == null) {
				result = "Please select a record!";
				log.debug("editAjax: object is null!");
			}else{
				Gson gson = new Gson();
				result = gson.toJson(object);
			}
		}
		
		CommonUtils.outPrintWriterToResult(response, result.toString());
	}
	
	@SuppressWarnings("unchecked")
	public void deleteAjax() throws Exception{
		String id = request.getParameter("id");
        String result = "";
		if (id == null) {
			// if id not exist
			result = "Please select a record!";
			log.debug("deleteAjax: Please select a record!");
		} else {
			// delete object
			this.delete(id);
			result = id;
		}
		
		CommonUtils.outPrintWriterToResult(response, result.toString());
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
		//	return Constants.INDEX_KEY;
		}
		//导出当前页所用参数
		String curentPageKey = request.getParameter("start");
		if (StringUtils.isNotBlank(curentPageKey)){
			toPage = new Integer(curentPageKey);
		}
		
		toPage = (toPage == null) ?  1 : toPage ;
		pageSize = (pageSize == null) ?  20 : pageSize ;

		Integer start = (toPage - 1)*pageSize;
		Integer count =  pageSize;
			
		list = this.findBeanList();

		Page page = null;
		if (null != list && list.size() > 0) {
			page = new Page(list, start, count);
		}

		if (null != page && page.getList().size() > 0) {
			beanList = page.getList();
		}
		
	    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();  
		String result = gson.toJson(beanList);
		
		json.put("data", result);
		json.put("totalRecord",list.size());
		return Action.SUCCESS;
	}

	public String listInitAjax() throws Exception {
		return Action.SUCCESS;
	}
	
	/**
	 * 导出List方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void exportExcelAjax() throws Exception {
		String sheetName = request.getParameter("sheetName");
		String exportResult = request.getParameter(CommonContexts.EXPORTRESULT_CURRENTPAGE);
		if (StringUtils.isBlank(sheetName)) {
			sheetName = request.getLocalName();
		}

		this.listAjax();
		
		String realPath = request.getRealPath(CommonContexts.DOWNLOADFILEPATH);
		
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
	 * 多附件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String uploadFileAjax(String[] fileArray) throws Exception {
		if (fileArray.length == 0){
			return "";
		}
		
		String realPath = request.getRealPath(CommonContexts.DOWNLOADFILEPATH);
		
		List<File> file = new ArrayList<File>();
		List<String> fileFileName = new ArrayList<String>();
		for(int i=0;i<fileArray.length;i++){
			//剔除数组空值的问题
			if("".equals(fileArray[i])){
				continue;
			}
			file.add(new File(fileArray[i]));
			fileFileName.add(new File(fileArray[i]).getName());
		}
		
		if (fileFileName !=null && fileFileName.size()>0){
			return UploadUtils.uploadFile(file, fileFileName, realPath) +":"+ ArrayUtils.toString(fileFileName);
		}
		return UploadUtils.uploadFile(file, fileFileName, realPath);
	}
	/**
	 * @time 2011-03-22 下载附件,包括三个方法
	 *       downLoadFile->getDownloadFile->getDownloadChineseFileName
	 * @return
	 * @throws Exception
	 */
	public void downLoadFileAjax() throws Exception {
		// this.getFile();
		String fileName = request.getParameter("fileName");
		if (StringUtils.isNotBlank(fileName)) {
			fileName = this.getDownloadChineseFileName(fileName.trim());
		}
		InputStream in = null;// 输入流
		ServletOutputStream out = null; // 输出流
		try {
			in = this.getDownloadFile(fileName);
			if (in == null) {
				CommonUtils.outPrintWriterToResult(response, "ERROR:无法下载此附件已经丢失!");
			} else {
				response.reset();
				response.setHeader("Content-Disposition",
						"attachment;filename=" + fileName);
				response.setHeader("Connection", "close");
				response.setHeader("Content-Type", "application/octet-stream;");

				out = response.getOutputStream();
				out.flush();
				int aRead = 0;
				while ((aRead = in.read()) != -1 && in != null) {
					out.write(aRead);
				}
				out.flush();
			}
		} catch (Throwable e) {
			log.debug("downLoadFileAjax:"+e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (Throwable e) {
			}
		}
	}

	// 从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile(String fileName) throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(CommonContexts.DOWNLOADFILEPATH +fileName);
	}

	// 如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName(String fileName) throws Exception {
		return (fileName != null && !"".equals(fileName)) ? new String(fileName
				.getBytes(), "UTF-8") : "";
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
	
	@SuppressWarnings("unchecked")
	public List getBeanList() {
		return beanList;
	}

	@SuppressWarnings("unchecked")
	public void setBeanList(List beanList) {
		this.beanList = beanList;
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

	@SuppressWarnings("unchecked")
	public Map getJson() {
		return json;
	}

	@SuppressWarnings("unchecked")
	public void setJson(Map json) {
		this.json = json;
	}
}

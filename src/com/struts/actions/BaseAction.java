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
 * BaseAction ˵���� 1.request�����Ѿ��ڴ���������ע��,����Action������Ҫ�ٴι���request������λ�ȡ
 * 2.baseHibernateBo ����������л����Ĳ���DAO�ķ���,����Action����ֱ��ʹ��Ҳ���Լ̳���չ�Լ��ķ����
 * 3.�ϴ�,���ع����ڴ������Ѿ�����,����Actionֻ����Ķ�Ӧ��struts.xml���ã�ֱ�ӵ���,����Ҫ������߼�
 * 4.�������л�������תindex��list��add��edit 5.����Ա�Ļ�ȡgetUsername() 6.AddressAction
 * ���õ�demo,���л��������ɰ���������
 * 
 * @author zs
 */
@SuppressWarnings("serial")
abstract public class BaseAction extends ActionSupport implements Action,
		ServletRequestAware, ServletResponseAware, Preparable {

	/**
	 * ͨ��spring�������ļ�ע��BaseHibernateBo��������,��DAO����в��� ��װ�˴����ĵ������,��/ɾ/��,�Լ��Զ���SQL��ѯ
	 * һ��̳е�����Action��ֱ����BaseHibernateBo�������ݿ�
	 * ������Ҫ�����Ļ����߼�������IBaseHibernateBo�ӿ��ж���,��BaseHibernateBo��ʵ��
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
	 * ͨ��spring�������ļ�ע��BaseSpringBo��������,��DAO����в���
	 * ��DAOΪHibernate����㸨������,���ڸ��ӵ�SQL��ϵ,�������÷������ӵ�ӳ���ϵ�ɲ��ô���ֱ����SQL�������ݿ��֮��Ĺ�ϵ
	 * һ��̳е�����Action��ֱ����BaseSpringBo�������ݿ�
	 * ������Ҫ�����Ļ����߼�������BaseSpringBo�ӿ��ж���,��BaseSpringBo��ʵ��
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
	 *      ����ServletRequestAware�ӿ���������ע��ķ�ʽ��baseAction��ȡrequest����
	 *      ��������actionƵ����ȡrequest����,�������Ͻ��鲻ʹ�õķ���,��һ������ʽ������
	 *      ���ǿ�ܵĴ��ʹ��,һ����÷���Ϸ�ʽ��ȡrequest����, ���£�HttpServletRequest request =
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
	 * Ԥ�������Ȼ�ȡ��½�Ĳ���Ա,����Action�н����ظ���ȡ��ֱ��ȡ�������Ƽ���
	 */
	protected String operId = null;

	/**
	 * �˷�������struts.xml�еĲ���ֵ��ȡ������Ϊ���� ����struts2������һ��BUG,����Ӱ��ִ�н��,��������ķ������,��ʱ����,Ԥ��
	 */
	private String methodParamter = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.struts.actions.BaseAction#findBeanList()
	 *      �˷�����÷�ҳPage����,���ǰ̨��ҳ��ǩһ��ʹ�� <site:page name="page"
	 *      action="address_list.action" />
	 *      �˷�����Action���ж��ƶ�ȡ,Ȼ�����BaseAction��list����������ת
	 *      ҳ���Զ���ȡbeanList,�ο�address.jspʾ����<s:iterator value="beanList"
	 *      status="addressNo">
	 */
	@SuppressWarnings("unchecked")
	public List beanList = null;

	protected List list = null;

	/**
	 * ����6�����������ϴ�������� 1.DOWNLOADFILEPATH �ϴ�/�����ļ�������ԭʼ���·�� 2.fileName ����ʱ���ļ���
	 * 3.saveDestFile �ϴ��ļ����ص�ֵ,�����ļ�����,�����ǶԸ� 4.file ���ļ��ϴ����� struts2��̶ܹ�����
	 * 5.fileFileName ���ļ��ϴ��ļ����Ƽ��� struts2��̶ܹ����� 6.fileContentType ���ļ��ϴ�������
	 * struts2��̶ܹ�����,�����ڶ�Ӧ��struts.xml�ļ���ƥ�䵽
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
	 *      ʵ��Preparable�ӿ�,Ԥ���ط���,��ܴԤ��ʹ��
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
	 * Ĭ�Ϸ�ҳList����,��ʱ���üٷ�ҳ,�Ժ��Ż�
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
		// ÿҳ��ʾ����
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

		// �˷�������struts.xml�еĲ���ֵ��ȡ������Ϊ����
		// ����struts2������һ��BUG,����Ӱ��ִ�н��,��������ķ������,��ʱ����,Ԥ��
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
	 * sitemesh����ܹ���ͳһ��ʽ,���Ǵ����������ǲ��ֲܾ�ˢ��,�˴�����Ajax��ҳ
	 * Ĭ�Ϸ�ҳList����,��ʱ���üٷ�ҳ,�Ժ��Ż�
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String listAjax() throws Exception {
		if (isTimeout()) {
			return Constants.INDEX_KEY;
		}
		//������ǰҳ���ò���
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
	 * ����List����
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
	 * ����List����
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
	 * ����List����
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
	 * �����߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String back() throws Exception;

	/**
	 * ����߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String add() throws Exception;

	/**
	 * �����߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String insert() throws Exception;

	/**
	 * �༭�߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String edit() throws Exception;

	/**
	 * �����߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String update() throws Exception;

	/**
	 * ɾ���߼���Ĭ����ת
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public abstract String delete() throws Exception;

	/**
	 * �฽���ϴ�
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String uploadFile() throws Exception {
		return UploadUtils.uploadFile(file, fileFileName, realPath);
	}

	/**
	 * �฽���ϴ�
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String uploadFileAjax(List<File> file,List<String> fileFileName) throws Exception {
		return UploadUtils.uploadFile(file, fileFileName, realPath);
	}
	/**
	 * @time 2011-03-22 ���ظ���,������������ ���struts.xml�ļ�����ִ��˳�����£�
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

	// �������ļ�ԭʼ���·����ȡ�õ��ļ������
	public InputStream getDownloadFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(
				CommonContexts.DOWNLOADFILEPATH + fileName);
	}

	// ��������ļ���Ϊ���ģ������ַ�����ת��
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

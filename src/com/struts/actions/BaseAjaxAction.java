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
 * BaseAction ˵���� 1.request�����Ѿ��ڴ���������ע��,����Action������Ҫ�ٴι���request������λ�ȡ
 * 2.baseHibernateBo ����������л����Ĳ���DAO�ķ���,����Action����ֱ��ʹ��Ҳ���Լ̳���չ�Լ��ķ����
 * 3.�ϴ�,���ع����ڴ������Ѿ�����,����Actionֻ����Ķ�Ӧ��struts.xml���ã�ֱ�ӵ���,����Ҫ������߼�
 * 4.�������л�������תindex��list��add��edit 5.����Ա�Ļ�ȡgetUsername() 6.AddressAction
 * ���õ�demo,���л��������ɰ���������
 * 
 * @author zs
 */
@SuppressWarnings("serial")
abstract public class BaseAjaxAction extends ActionSupport implements Action,
		ServletRequestAware, ServletResponseAware, Preparable {

	Logger log = Logger.getLogger(this.getClass());
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
	 *      ʵ��Preparable�ӿ�,Ԥ���ط���,��ܴԤ��ʹ��
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
			result.append("��������\r");
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
	 * sitemesh����ܹ���ͳһ��ʽ,���Ǵ����������ǲ��ֲܾ�ˢ��,�˴�����Ajax��ҳ
	 * Ĭ�Ϸ�ҳList����,��ʱ���üٷ�ҳ,�Ժ��Ż�
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String listAjax() throws Exception {
		if (isTimeout()) {
		//	return Constants.INDEX_KEY;
		}
		//������ǰҳ���ò���
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
	 * ����List����
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
	 * �฽���ϴ�
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
			//�޳������ֵ������
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
	 * @time 2011-03-22 ���ظ���,������������
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
		InputStream in = null;// ������
		ServletOutputStream out = null; // �����
		try {
			in = this.getDownloadFile(fileName);
			if (in == null) {
				CommonUtils.outPrintWriterToResult(response, "ERROR:�޷����ش˸����Ѿ���ʧ!");
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

	// �������ļ�ԭʼ���·����ȡ�õ��ļ������
	public InputStream getDownloadFile(String fileName) throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(CommonContexts.DOWNLOADFILEPATH +fileName);
	}

	// ��������ļ���Ϊ���ģ������ַ�����ת��
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

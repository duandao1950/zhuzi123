package com.struts.actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.util.CommonDicContexts;
import com.common.util.DateUtil;
import com.hibernate.beans.Article;
import com.hibernate.bo.AddressBo;
import com.hibernate.bo.BaseHibernateBo;
import com.struts.util.Utils;

/**
 * struts2 ��������ActionForm,����ͨ�����Ե�get/set�������������
 * ����ajax��ʽ����ͨ��get��ʽ��ֵ,��Action�ж��Ƶ�setAllParameter����
 * struts_address_ajax.xml ���õĶ��Ǹ���BaseAjaxAction��method�߼�
 * ��������з������Ƕ�������
 * @author zs
 */
@SuppressWarnings("serial")
public class ArticleAction extends BaseAjaxAction {

	Logger log = Logger.getLogger(this.getClass());

	private Integer id;
    private Integer styleId;
    private String title;
    private Integer authorId;
    private String content;
    private String contentExt;
    private Timestamp createTime;
    private Timestamp updateTime;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentExt() {
		return contentExt;
	}

	public void setContentExt(String contentExt) {
		this.contentExt = contentExt;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * ע��AddressBo��������,��DAO����в���
	 * �����ĵ������,��/ɾ/��,�Լ��Զ���SQL��ѯ,�Ѿ���װ���丸���BaseHibernateBo��
	 * һ��ֱ����BaseHibernateBo���ü���
	 * ������Ҫ��չ���߼�������IAddressBo�ӿ��ж���,��AddressBo��ʵ��
	 * @return
	 */
	@Autowired
	protected BaseHibernateBo baseHibernateBo;

	public BaseHibernateBo getBaseHibernateBo() {
		return baseHibernateBo;
	}

	public void setBaseHibernateBo(BaseHibernateBo baseHibernateBo) {
		this.baseHibernateBo = baseHibernateBo;
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
		List<Article> list = baseHibernateBo.findAll(Article.class);
		//���Ƹ�����ʾ�б�,���磺<site:baseSelect property="sex" id="sex" tableName="DIC_SEX" defaultValue="S0001"/>
		//ҳ��ʱʹ�����Զ��Ʊ�ǩ��ʾ������,��table����ʾ��ʱ������ֻ��ʾ��ֵ�����,�˴������޸�
		for(Article article : list){
//			String sexLabel = baseSpringBo.loadDicContent(CommonDicContexts.DIC_SEX, article.getSex());
//			article.setSexLabel(sexLabel);
//			String filePathPreview = article.getFilepath();
//			if (StringUtils.isNotBlank(filePathPreview)){
//				if (filePathPreview.indexOf(":") != -1){
//					article.setFilepathPreview(StringUtils.substringBefore(filePathPreview, ":"));
//				}else{
//					article.setFilepathPreview(filePathPreview);
//				}
//			}
			
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			article.setCreateTime(Timestamp.valueOf(df.format(article.getCreateTime())));
//			System.out.println(article.getCreateTime());
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 1.
	 * oracle���ݿ����������ͨ��ӳ���ȡsequence,��ͨ�����·�ʽ��ȡ
	 * this.id = baseHibernateBo.findSequence(CommonContexts.ADDRESSSEQ);
	 * article.setId(new Integer(id));
	 * 2.
	 * �˴��ϴ�ֻ�����super.uploadFile()�������,�����ļ�����,�������ݿ�
	 * Ŀǰ�ϴ��ļ������Ŀ¼��apache-tomcat-6.0.18/webapps/demo/upload
	 * @see com.struts.actions.BaseAction#insert()
	 */
	@SuppressWarnings("unchecked")
	public void saveOrUpdate() throws Exception {
		Article article = this.setAllParameter();
		baseHibernateBo.saveOrUpdate(article);
	}

	@SuppressWarnings("unchecked")
	public Article edit(String id) throws Exception {
		Article article = (Article) baseHibernateBo.findById(Article.class,
				new Integer(id));
		return article;
	}

	@SuppressWarnings("unchecked")
	public void delete(String id) throws Exception {
		baseHibernateBo.delete(Article.class, new Integer(id));
	}

	public Article setAllParameter() throws Exception {
		String id = request.getParameter("id");
		String styleId = request.getParameter("styleId");
		String title = request.getParameter("title");
		String authorId = request.getParameter("authorId");
		String content = request.getParameter("content");
		String contentExt = request.getParameter("contentExt");

		Article article = new Article();
		if(id != null && !"".equals(id)){
			article.setId(Integer.valueOf(id));
		}
		article.setStyleId(Integer.valueOf(styleId));
		article.setTitle(title);
		article.setAuthorId(Integer.valueOf(authorId));
		article.setContent(content);
		article.setContentExt(contentExt);
		article.setCreateTime(DateUtil.getCurrentTime());
		//Utils.fillObject(addressParameter);
		
		return article;
	}
}

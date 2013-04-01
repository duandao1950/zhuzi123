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
 * struts2 基本不用ActionForm,都是通过属性的get/set方法来填充属性
 * 采用ajax方式都是通过get方式传值,即Action中定制的setAllParameter方法
 * struts_address_ajax.xml 配置的都是父类BaseAjaxAction的method逻辑
 * 子类的所有方法都是定制所用
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
	 * 注入AddressBo服务层对象,对DAO层进行操纵
	 * 大量的单表操作,增/删/改,以及自定制SQL查询,已经封装在其父类的BaseHibernateBo中
	 * 一般直接用BaseHibernateBo调用即可
	 * 对于需要扩展的逻辑可以在IAddressBo接口中定义,在AddressBo中实现
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
	 * 此方法获得分页Page对象,结合前台分页标签一起使用
	 * <site:page name="page" action="address_list.action" />
	 * 此方法对Action进行定制读取,然后调用BaseAction中list方法进行跳转
	 */
	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception {
		// get pager
		List<Article> list = baseHibernateBo.findAll(Article.class);
		//定制改造显示列表,比如：<site:baseSelect property="sex" id="sex" tableName="DIC_SEX" defaultValue="S0001"/>
		//页面时使用了自定制标签显示下拉框,在table中显示的时候会存在只显示键值的情况,此处定制修改
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
	 * oracle数据库中如果不想通过映射获取sequence,可通过如下方式获取
	 * this.id = baseHibernateBo.findSequence(CommonContexts.ADDRESSSEQ);
	 * article.setId(new Integer(id));
	 * 2.
	 * 此处上传只需调用super.uploadFile()这个方法,返回文件名称,保存数据库
	 * 目前上传文件保存的目录是apache-tomcat-6.0.18/webapps/demo/upload
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

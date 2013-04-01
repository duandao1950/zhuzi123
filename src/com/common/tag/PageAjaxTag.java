package com.common.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PageAjaxTag extends TagSupport {

	private String action;
	private String bgcolor;
	private String height;
	private String target;
	private String name;
	private String export;

	public PageAjaxTag() {
		bgcolor = "#FFFFFF";
		height = "25";
		target = "_self";
		name = null;
		export = "false";
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeight() {
		return height;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}
	
	public int doStartTag() throws JspException {
		JspWriter outcontent = pageContext.getOut();
		StringBuffer content = new StringBuffer();
		content.append("<div class='dl' id='pageFix' style='display: none'>\r");
		content.append("   <table width='100%' align='left' border='0' cellpadding='0' cellspacing='0'>\r");
		content.append("     <input id='curentPageKey' name='curentPageKey' type='hidden'/>\r");
		content.append("     <tr>\r");
		content.append("         <td colspan='10' align='left'>\r");
		content.append("           共&nbsp;<span id='totalRecord' style='color: red' >0</span>&nbsp;条记录\r");
		content.append("           共&nbsp;<span id='count' style='color: red'>0</span>&nbsp;页\r");
		content.append("           当前&nbsp;<span style='color: red' id='curentPage'></span>&nbsp;页\r");
		content.append("         </td>\r");
		if (export.equals("true")){
			content.append("         <td align='center' id='export' style='display: bolck'>\r");
		}else{
			content.append("         <td align='center' id='export' style='display: none'>\r");
		}
		content.append("             Export&nbsp;\r");
		content.append("             <a id='exportAll' href='export_excel_ajax.action' >All</a>&nbsp;\r");
		content.append("             <a id='exportPage' href='javascript:exportPage()'>Current Page</a>\r");
		content.append("             </td>\r");
		content.append("          <td height='25' align='right'><nobr>\r");
		content.append("              <a class='page-start' href='#' id='firstA'>第一页</a>\r");
		content.append("              <a class='page-start' href='#' id='prevA' accesskey='p'>上一页</a>\r");
		content.append("              <a class='page-end' href='#'  id='nextA' accesskey='n'>下一页</a>\r");
		content.append("              <a class='page-end' href='#'  id='lastA'>末一页</a>\r");
		content.append("              跳转到 <input id='toPageText' type='text' size='3' maxlength='3'>页<a class='page-next' href='#' id='skipA'>GO</a>\r");
		content.append("          </td>\r");
		content.append("     </tr>\r");
		content.append("   </table>\r");
		content.append("</div>\r");
		
		content.append("<script type='text/javascript'>\r");
		content.append("   $(function(){\r");
		content.append("       $('#firstA').click(function(){\r");
		content.append("            if(window.bigPage)bigPage.firstPage();\r");
		content.append("       });\r");
		content.append("       $('#prevA').click(function(){\r");
		content.append("            if(window.bigPage)bigPage.prevPage();\r");
		content.append("       });\r");
		content.append("       $('#nextA').click(function(){\r");
		content.append("            if(window.bigPage)bigPage.nextPage();\r");
		content.append("       });\r");
		content.append("       $('#lastA').click(function(){\r");
		content.append("            if(window.bigPage)bigPage.lastPage();\r");
		content.append("       });\r");
		content.append("       $('#skipA').click(function(){\r");
		content.append("            if(window.bigPage)bigPage.skipPage($('#toPageText').val());\r");
		content.append("       });\r");
		content.append("   });\r");
		content.append("</script>\r");
		try {
			outcontent.write(content.toString());
			//System.out.println(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}

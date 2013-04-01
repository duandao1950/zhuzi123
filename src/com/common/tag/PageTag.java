package com.common.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.common.page.Page;
import com.common.util.CommonContexts;

@SuppressWarnings("serial")
public class PageTag extends TagSupport {

	private String action;
	private String bgcolor;
	private String height;
	private String target;
	private String name;
	private String export;

	public PageTag() {
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

	public int doStartTag() throws JspException {
		Page pageobj = Page.EMPTY_PAGE;
		JspWriter outcontent = pageContext.getOut();
		Object tempPageObj = pageContext.findAttribute(name);
		StringBuffer content = new StringBuffer();
		try {
			if (tempPageObj == null) {
				outcontent
						.write("<font color='red'>Not exist any data!</font>");
				return 1;
			}

			pageobj = (Page) tempPageObj;

			outcontent
					.write("<table width=\"100%\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
			outcontent.write("<tr><td colspan=\"10\" align=\"center\">");
			if (pageobj.getList().size() == 0) {
				outcontent
						.write("<font color='red'>Query records is empty!</font>");
			} else {

				boolean hasNextPage = pageobj.getHasNextPage();
				boolean hasPreviousPage = pageobj.getHasPreviousPage();
				int startOfNextPage = pageobj.getStartOfNextPage();
				int startOfPreviousPage = pageobj.getStartOfPreviousPage();
				int firstPage = pageobj.getFirstPage();
				int lastPage = pageobj.getLastPage();
				int totalPage = pageobj.getTotalPage();
				int currentPage = pageobj.getCurrentPage();
				int pageRecordCount = pageobj.getCount();
				int total = pageobj.getTotal();

				String newAction = action;
				if (action.indexOf("?") == -1) {
					newAction = newAction + "?";
				} else {
					newAction = newAction + "&";
				}
				newAction = newAction + "start=";
				content
						.append("<input type=hidden  id=\"idHidePageDownStart\" name=\"hidePageDownStart\">\r");
				content
						.append("      <input type=hidden  id=\"idHidePageDownCurrentCount\" name=\"hidePageDownCurrentCount\" value=\""
								+ String.valueOf(pageRecordCount) + "\">\r");
				content.append("      <SCRIPT language=JavaScript>\r");
				content.append("        function trimPage(s)\r");
				content.append("        {\r");
				content
						.append("          return s.replace( /^\\s*/, \"\" ).replace( /\\s*$/, \"\" );\r");
				content.append("        }\r");
				content.append("\r");
				content.append("        function dolink(url)\r");
				content.append("        {\r");
				content.append("         window.location.href =url;\r");
				// content.append(" document.forms[0].submit();\r");
				content.append("        }\r");
				content.append("\r");

				content.append("        function  jump(page,flag)\r");
				content.append("        {\r");
				content
						.append("          var f=document.all(\"PageDownGoPageNo\").value;\r");
				content.append("\r");
				content
						.append("          if(f==null || f==\"\" || trimPage(f)==\"\" || f<=0 || f>page || page<=0 )\r");
				content.append("          {\r");
				content.append("            alert(\""
						+ "Please type a page number from 1 to  "
						+ "\" + page +\"" + " ." + "\");\r");
				content
						.append("            document.all(\"PageDownGoPageNo\").focus();\r");
				content
						.append("            window.event.returnValue = false;\r");
				content.append("            return false;\r");
				content.append("          }\r");
				content.append("\r");
				content
						.append("          if(isNaN(f) || f.indexOf(\".\")!=-1)\r");
				content.append("          {\r");
				content.append("            alert(\"" + "Integer only"
						+ "\");\r");
				content
						.append("            document.all(\"PageDownGoPageNo\").focus();\r");
				content
						.append("            window.event.returnValue = false;\r");
				content.append("            return false;\r");
				content.append("          }\r");
				content
						.append("          document.all(\"PageDownGoPageNo\").value=trimPage(f);\r");
				content.append("          var startindex=(f-1)*"
						+ pageRecordCount + ";\r");
				content.append("          var url=\"" + newAction
						+ "\"+startindex;\r");
				content.append("          dolink(url);\r");
				content.append("          return true;\r");
				content.append("        }\r");
				content.append("        function firekeydownevent(){\r");
				content.append("          if(event.keyCode==13){\r");
				content
						.append("            urlPageDownGoPageNo.fireEvent(\"onclick\");\r");
				content.append("            event.returnValue = false;\r");
				content.append("          }\r");
				content.append("        }\r");
				content.append("      </SCRIPT>\r");

				content.append("      <tr bgcolor=\"" + bgcolor + "\">\r");
				content
						.append("          <td>&nbsp;&nbsp;"
								+ String.valueOf(total)
								+ "&nbsp;&nbsp;record(s)&nbsp;"
								+ String.valueOf(currentPage)
								+ "&nbsp;&nbsp;page(s)&nbsp;No."
								+ String.valueOf(totalPage)
								+ "&nbsp;&nbsp;page</td>\r");
				if ("true".equals(export)){
					content.append("<td align=\"center\">Export&nbsp;<a href=\"exportExcel.action\">All</a>&nbsp;");
					content.append("<a href=\"exportExcel.action?exportResult="+CommonContexts.EXPORTRESULT_CURRENTPAGE+"&start="+(pageRecordCount*(currentPage-1))+"\">Current Page</a></td>");
				}
				content.append("        <td height=\"" + height
						+ "\" align=\"right\"><nobr>\r");
				content.append("\r");
				if (totalPage > 1 && currentPage > 1) {
					content.append("          <a href=\"javascript:dolink('"
							+ newAction + firstPage + "')\" target=\"" + target
							+ "\">");
					content.append("First\r");
				} else {
					content.append("First\r");
				}
				if (hasPreviousPage) {
					content.append("          <a href=\"javascript:dolink('"
							+ newAction + startOfPreviousPage
							+ "')\" target=\"" + target + "\">Previous</a>\r");
				} else {
					content.append("Previous\r");
				}
				if (hasNextPage) {
					content.append("          <a href=\"javascript:dolink('"
							+ newAction + startOfNextPage + "')\" target=\""
							+ target + "\">Next</a>\r");
				} else {
					content.append("Next\r");
				}
				if (totalPage > 1) {
					if (totalPage > currentPage) {
						content
								.append("          <a href=\"javascript:dolink('"
										+ newAction
										+ lastPage
										+ "')\" target=\""
										+ target
										+ "\">Last</a>\r");
					} else {
						content.append("Last\r");
					}
				} else if (totalPage == 1) {
					content.append("Last\r");
				}
			}
		} catch (Exception e) {
			throw new JspException("CastClass Exception!", e);
		}

		content.append("</td></tr></table>");
		/*
		 * content.append(" </nobr></td>\r"); content.append("<td width=\"50\" align=\"right\"><nobr>");
		 * content .append(" " + "&nbsp;Goto" + " <input type=\"text\"
		 * class=\"text\" id=\"PageDownGoPageNo\" name=\"GoPageNo\" size=\"1\"
		 * onKeyPress=\"firekeydownevent()\"/> \r"); content .append(" <a
		 * id=\"urlPageDownGoPageNo\" href=\"#\"; onClick=\"jump(" + totalPage +
		 * ",null)\">"); // content.append("<img src=\"" +
		 * request.getContextPath()+ // "/images/BtnTable_Go.gif" + "\" alt=\""+
		 * "Go to page" + "\" // width=\"40\" height=\"13\" border=\"0\"></a>\r");
		 * content.append("Page</a>\r"); content.append("</nobr></td>");
		 * content.append(" </tr>\r");
		 */
		try {
			outcontent.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}
}

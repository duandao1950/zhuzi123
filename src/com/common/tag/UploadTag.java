package com.common.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class UploadTag extends TagSupport {

	private String bgcolor;
	private String height;
	private String target;

	public UploadTag() {
		bgcolor = "#FFFFFF";
		height = "25";
		target = "_self";
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

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	public int doStartTag() throws JspException {
		JspWriter outcontent = pageContext.getOut();
		
		StringBuffer content = new StringBuffer();
		content.append("<SCRIPT language=JavaScript>\r");
		content.append("function addMore()\r");
		content.append(" {\r");
		content.append("   var td = document.getElementById(\"more\");\r");
		content.append("   var br = document.createElement(\"br\");\r");
		content.append("   var input = document.createElement(\"input\");\r");
		content.append("   var button = document.createElement(\"input\");\r");
		content.append("   input.type=\"file\";\r");
		content.append("   input.name=\"file\";\r");
		content.append("   button.type=\"button\";\r");
		content.append("   button.value=\"Remove\";\r");
		content.append("   button.onclick = function()\r");
		content.append("   {\r");
		content.append("   td.removeChild(br);\r");
		content.append("   td.removeChild(input);\r");
		content.append("   td.removeChild(button);\r");
		content.append("   }\r");
		content.append("   td.appendChild(br);\r");
		content.append("   td.appendChild(input);\r");
		content.append("   td.appendChild(button);\r");
		content.append("}\r</SCRIPT>\r");
		content.append("<TR><TD>file:</TD>\r");
		content.append("<TD id=\"more\"><input type=\"file\" id=\"filepath\" name=\"file\" value=\"\"/>");
		content.append("<input type=\"button\" value=\"Add More ...\" onClick=\"addMore()\"/></TD></TR>\r");

		try {
			outcontent.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}

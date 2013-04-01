<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.struts.util.Constants"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>Zhuzi - <decorator:title default="Welcome!" /></title>
<link rel="stylesheet" type="text/css" href="../../css/styles.css">

<decorator:head />
</head>

<body>
<base href="<%=basePath%>">
<div align="center" width="100%"><%if (session.getAttribute(Constants.OPERATORSID_KEY) != null) {%>
<table width="100%">
	<tr>
		<td><b>Zhuzi LOGO<b></td>
	</tr>
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	<tr>
		<td width="160" bgcolor="#EEEEEE" valign="top">
		<table width="100%">
			<tr>
				<td><li>
				<IMG id=IMG_0 style="CURSOR: hand" onclick="javascript:showHiddenNode(this, 'TR_0')" 
				       src="images/dtree/base.gif" align=absMiddle border=0>
				<A href="welcome.action" ><s:text name="frame.main"/></a></li></td>
			</tr>
			<TR class=bg1 id=TR_0_0  pid="TR_0">
			     <TD style="TEXT-INDENT: 20pt; TEXT-ALIGN: left"><IMG id=IMG_0_0 
			       style="CURSOR: hand" 
			       onclick="javascript:showHiddenNode(this, 'TR_0_0')" 
			       src="images/dtree/nolines_minus.gif" align=absMiddle border=0>
			       <img src="images/dtree/tree_open.gif">
			       <A href="address_init_ajax.action"><s:text name="frame.address"/>&nbsp;123</A>
			     </TD>
		   </TR>
		   <TR class=bg1 id=TR_0_1  pid="TR_0">
			     <TD style="TEXT-INDENT: 20pt; TEXT-ALIGN: left"><IMG id=IMG_0_0 
			       style="CURSOR: hand" 
			       onclick="javascript:showHiddenNode(this, 'TR_0_1')" 
			       src="images/dtree/nolines_minus.gif" align=absMiddle border=0>
			       <img src="images/dtree/tree_open.gif">
			       <A href="roles_list.action">System&nbsp;</A>
			     </TD>
		   </TR>
		   <TR class=bg1 id=TR_0_1_0 pid="TR_0_1">
          		<TD style="TEXT-INDENT: 40pt; TEXT-ALIGN: left">
	          	<A href="roles_list.action">Role&nbsp;</A>
	            </TD>
           </TR>
		   <TR class=bg1 id=TR_0_2  pid="TR_0">
			     <TD style="TEXT-INDENT: 20pt; TEXT-ALIGN: left"><IMG id=IMG_0_0 
			       style="CURSOR: hand" 
			       onclick="javascript:showHiddenNode(this, 'TR_0_2')" 
			       src="images/dtree/nolines_minus.gif" align=absMiddle border=0> 
			       <A href="logout.action"><s:text name="frame.logout"/>&nbsp;</A>
			     </TD>
			</TR>
		</table>
		</td>
		<td align="left" valign="top"><decorator:body /></td>
	</tr>
</table>
<%} else {%> <decorator:body /> <%}%>
<hr>
xxxx @xxx.com</div>
</body>
</html>

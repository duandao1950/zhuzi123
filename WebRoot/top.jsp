<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<%@ page import="com.struts.util.Constants"%>
<%@page import="com.hibernate.beans.Operator"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="welcome.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript">

function logout()
{
	if(confirm("Do you want to logout?")){
		parent.document.location.href = "logout.action";
	}
}
</script>
<style  type="text/css">
	.body1{
	background-image:url(images/Woa08.jpg);
	background-position: 1px 1px;
	background-repeat:no-repeat;
	padding-left:25px;
	height:23px;
	FONT-SIZE: 12px;
}
</style>
<body class="body1" bgcolor="#fcfcfc">

<form name="form1" action="logout.action" method="post">
<s:actionerror/>
<table align="center" width="98%" height="35%">
	<tr>
		<td align="left"><font color="#4b9898" size="5"><b>zhuzi123  System</b></font></td>
		<td><font color="#4b9898">
		<%
	Operator oper = (Operator)session.getAttribute(Constants.CURRENT_OPERINFO);
%>
<s:text name="top.page.logintime"/><%=(oper.getLoginTime()).toLocaleString()%>
&nbsp;&nbsp;&nbsp;&nbsp;
<s:text name="top.page.currentoper"/></font>
<b>
<%=oper.getOperName()%>
</b>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:logout()" ><s:text name="welcome.page.logout" /></a>
		</td>
	</tr>
</table>

</form>

</body>
</html>

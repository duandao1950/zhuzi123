<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="register.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<s:actionerror/>
<form name="form1" action="register_user.action" method="post" style="width: 500px; float: center; margin: 10px 0 30px 50px;">
<div style="border:1px solid #ccc;background-color:white;width:400px;padding:10px;">
<table width="400">
	<tr>
		<td colspan="2"><FONT color="#1133bb"><B><s:text name="register.page.title"/><B></FONT></td>
	</tr>
	<tr>
		<td><s:text name="register.page.username"/></td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td><s:text name="register.page.password1"/></td>
		<td><input type="password" name="password1"></td>
	</tr>
	<tr>
		<td><s:text name="register.page.password2"/></td>
		<td><input type="password" name="password2"></td>
	</tr>
	<tr>
		<td><s:text name="register.page.email"/></td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="submit"
			value='<s:text name="register.page.register"/>'> <a
			href="index.action"><s:text name="register.page.back"/></a></td>
	</tr>
</table>
</div>
</form>
</body>
</html>

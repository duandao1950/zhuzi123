<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.struts.util.Constants"%>
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

<title><s:text name="welcome.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<script type="text/javascript">
   function addToAdmin(){
       window.location.href = "logout.action";
   }
</script>
<body>

<form name="form1" action="logout.action" method="post">
<s:actionerror/>
<div style="border:1px solid #ccc;background-color:white;width:200px;padding:10px;">
<table width="200" class="listtablebody1">
	<tr>
		<td colspan="2"><s:text name="welcome.page.title"/></td>
		</tr>
	<tr>
		<td><s:text name="welcome.page.username"/></td>
		<td><%=(String) session.getAttribute(Constants.OPERATORSID_KEY)%></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" name="submit"
			value='<s:text name='welcome.page.logout'/>'></td>
	</tr>
</table>
</div>
</form>

</body>
</html>

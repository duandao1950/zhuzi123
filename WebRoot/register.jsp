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
<script type="text/javascript">
function submitAction(){
	var operId = document.getElementsByName("operId").value;
    if (operId == null){
    	alert(" the operator ID is required!");
	}
	
	var operName = document.getElementsByName("operName").value;
    if (operName == null){
    	alert(" the operator name is required!");
	}
	
	var password = document.getElementsByName("password").value;
    if (password == null){
    	alert(" the password is required!");
	}
	
	var prePassword = document.getElementsByName("prePassword").value;
    if (prePassword == null){
    	alert(" the prePassword is required!");
	}
	
	if (password != prePassword){
		alert(" the prePassword must be equals password!");
	}
	document.form[0].action="register_user.action";
}

</script>
</head>
<body>
<s:actionerror/>
<form name="form1" onsubmit="return submitAction();" method="post" style="width: 500px; float: center; margin: 10px 0 30px 50px;">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div style="border:1px solid #ccc;background-color:white;width:400px;padding:10px;">
<table width="400">
	<tr>
		<td colspan="2"><FONT color="#1133bb"><B><s:text name="register.page.title"/><B></FONT></td>
	</tr>
	<tr>
		<td><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorid"/></td>
		<td><input type="text" name="operId"></td>
	</tr>
	<tr>
		<td><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorname"/></td>
		<td><input type="text" name="operName"></td>
	</tr>
	<tr>
		<td><span style="color: red">*</span>&nbsp;<s:text name="register.page.password1"/></td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td><span style="color: red">*</span>&nbsp;<s:text name="register.page.password2"/></td>
		<td><input type="password" name="prePassword"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;Belong Team:</td>
		<td>
		<select name="belongTeam">
		    <option value='0'>实习 or 试用</option>
			<option value='1'>开发</option>
			<option value='2'>CRM</option>
			<option value='3'>KPNI</option>
			<option value='4'>维优</option>
			<option value='5'>测试</option>
		</select>
		</td>
	</tr>
	<tr>
		<td><span style="color: red">*</span>&nbsp;Mobile Phone:</td>
		<td>
		<input type="text" name="mobilePhone">
		</td>
	</tr>
	<tr>
		<td>&nbsp;First email:</td>
		<td>
		<input type="text" name="firstEmail">
		</td>
	</tr>
	<tr>
		<td>&nbsp;Second email:</td>
		<td>
		<input type="text" name="secondEmail">
		</td>
	</tr>
	<tr>
		<td>&nbsp;Notes ID:</td>
		<td>
		<input type="text" name="notesId">
		</td>
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

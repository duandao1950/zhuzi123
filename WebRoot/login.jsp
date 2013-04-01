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

<title><s:text name="login.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=1166443256" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<form name="form1" action="login.action" method="post" style="width: 500px; float: center; margin: 10px 0 30px 50px;">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<s:actionerror/>
<div style="border:1px solid #ccc;background-color:white;width:400px;padding:10px;">
	<table width="400">
	    <span align="left"><FONT color="#1133bb"><B><s:text name="login.page.title"/></B></FONT></span><br/>
		<tr>
			<td colspan="2"><span align="left" style="color:#4274A1;" ><s:text name="login.page.noticeinformation"/></span></td>
		</tr>
		<tr>
			<td><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorid"/></td>
			<td><input type="text" name="operId" value="admin"></td>
		</tr>
		<tr>
			<td><span style="color: red">*</span>&nbsp;<s:text name="login.page.password"/></td>
			<td><input type="password" name="password" value="admin"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit"
				value='<s:text name="login.page.login"/>'>
				<a href="register_init.action"><s:text name="login.page.register"/></a></td>
		</tr>
	</table>
</div>
<div id="wb_connect_btn" style="width:50em;height:180px;border:1px solid #bbb;background:#eee; padding:5px 2px;">登录按钮容器</div>
<script>
WB2.anyWhere(function(W){
	W.widget.connectButton({
		id: "wb_connect_btn",	
		type:'6,5',
		callback : {
			login:function(o){
				alert("login: "+o.screen_name)
			},
			logout:function(){
				alert('logout');
			}
		}
	});
});
</script>
</form>
</body>
</html>

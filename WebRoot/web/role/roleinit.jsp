<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/upload.tld" prefix="site"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="role.init.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="role.init.position"/></TD>
		<TD align="right"><!-- <a href="role_back.action"><s:text name="role.back"/></a> --></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="rolelist.action?method=list" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE border="0" width="78%">
	<TR>
		<TD class="tablebody"><s:text name="role.property.name"/>&nbsp;</TD>
		<TD><input type="text" name="roleName" maxlength="128" >
		&nbsp;<input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

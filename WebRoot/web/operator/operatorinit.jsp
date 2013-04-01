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

<title><s:text name="operator.init.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="operator.init.position"/></TD>
		<TD align="right"><!-- <a href="oper_back.action"><s:text name="operator.back"/></a> --></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="operlist.action?method=list" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE border="0" width="50%">
	<TR>
		<TD class="tablebody"><s:text name="operator.property.operid"/></TD>
		<TD><input type="text" name="operId" maxlength="10"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="operator.property.opername"/></TD>
		<TD><input type="text" name="operName" maxlength="10"></TD>
	</TR>	
	<TR>
        <td>&nbsp;</td>
		<TD align="left"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>

</TABLE>
<br>

</form>
</body>
</html>

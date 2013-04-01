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

<title><s:text name="performance.init.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>/js/calendar.js"></script>
</head>
<b><s:actionerror/></b>
<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="performance.init.position"/></TD>
		<TD align="right"><!-- <a href="oper_back.action"><s:text name="operator.back"/></a> --></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="performanceOpt_list?method=list" method="POST" enctype="multipart/form-data"/>

<TABLE border="0" width="50%">
	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.id"/></TD>
		<TD><input type="text" name="staffId" maxlength="10"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.name"/></TD>
		<TD><input type="text" name="staffName" maxlength="10"></TD>
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

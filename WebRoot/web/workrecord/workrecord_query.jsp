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

<title><s:text name="workrecord.query.page.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="workrecord.query.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>

<form action="workrecord_list.action?method=list" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>

<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.staff.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffId" maxlength="10"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.approve.staff.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="approveStaffId" maxlength="20"></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD></TD>
	</TR>
	<TR >
	    <TD></TD>
		<TD>
			<table border="0" width="100%">
			<tr>
				<td class="buttontable">
				<input type="submit"
				value="<s:text name='button.submit'/>">
				</td>
				<td width="57%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

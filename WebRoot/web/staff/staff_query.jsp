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
<title><s:text name="asset.query.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
<form action="staff_list.action?method=list" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="staff.query.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>
<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.id"/></TD>
		<TD><input type="text" name="staffId" maxlength="10"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.name"/></TD>
		<TD><input type="text" name="staffName" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.skill"/></TD>
		<TD><input type="text" name="skill" maxlength="10"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.status"/></TD>
		<TD>
		    <select name="statusId">
		        <option value="0">离职</option>
		        <option value="1">在职</option>
		        <option value="" selected="selected"></option>
		    </select>
        </TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel1"/></TD>
		<TD><input type="text" name="tel1" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel2"/></TD>
		<TD><input type="text" name="tel2" maxlength="20"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.email1"/></TD>
		<TD><input type="text" name="email1" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.email2"/></TD>
		<TD><input type="text" name="email2" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.enter.com.date"/></TD>
		<TD><input type="text" name="enterComDate" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.exit.com.date"/></TD>
		<TD><input type="text" name="exitComDate" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.group.name"/></TD>
		<TD><input type="text" name="groupName" maxlength="20" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.work.years"/></TD>
		<TD><input type="text" name="workYears" maxlength="20" ></TD>
	</TR>
	<TR>
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

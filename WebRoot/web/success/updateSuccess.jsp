<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>添加记录成功</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript">
function backTo(return_action)
{
    var return_action = document.forms[0].return_action.value;
    document.forms[0].action= return_action;
    document.forms[0].submit();
}
</script>
</head>
<body>
<form method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="message.update.success" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>
<input type="hidden" name="return_action" value="${return_action }">
<TABLE border="0" width="40%">

	<TR>
		<TD class="tablebody"><s:text name="message.return.result.code"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" value="${resultCode}">
		</TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="message.return.result"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" value="${result}"/>
		</TD>
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
				<input type="button" onclick="backTo()"
				value="<s:text name='button.return'/>">
				</td>
				<td width="48%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>
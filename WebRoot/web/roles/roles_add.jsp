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

<title><s:text name="roles_add.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function Back(){
       	window.location.href = "roles_back.action";
   	}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="roles_add.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="roles_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE border="0">
	<TR>
		<TD><s:text name="roles.page.roleName"/></TD>
		<TD><input type="text" name="roleName" maxlength="10" value="${roles.roleName}"></TD>
		<TD><s:text name="roles_add.page.description"/></TD>
		<TD><input type="text" name="description" maxlength="20" value="${roles.description}"></TD>
	</TR>
	<tr>
		<td><s:text name="roles.page.isValid"/></td>
		<td>
		<select name="isValid">
			<option value='1'>Yes</option>
			<option value='0'>No</option>
		</select>
		</td>
	</tr>
	<TR>
		<TD colspan="5" align="right"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

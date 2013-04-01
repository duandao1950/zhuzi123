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

<title><s:text name="address_add.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
function check()
{
	var rname = document.forms[0].roleName.value;
	if(null == rname || "" == rname)
	{
		alert("请输入角色名称！");
		return false;
	}	
	return true;
}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="role.add.position"/></TD>
		<TD align="right"><a href="role_back.action"><s:text name="role.back"/></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="insertrole.action?method=insert" method="POST" onsubmit="return check();" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="role.property.name"/></TD>
		<TD>
			<input type="text" name="roleName" maxlength="128" >
			<font color="#C10202">*</font>
		</TD>
	</TR>
	<TR>
		<TD><s:text name="role.property.description"/></TD>
		<TD>&nbsp;
			<s:textarea name="description" rows="4"></s:textarea>
		</TD>
	</TR>


	<TR>
		<TD colspan="2"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

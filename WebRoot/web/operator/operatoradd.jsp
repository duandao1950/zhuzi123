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

<title><s:text name="operator.add.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
function selectStaff()
{
    var url="staff_toqry.action?method=toQry";
    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].operId.value = submitValue;
    }
  
}
function check()
{
	var oper = document.forms[0].operId.value;
	if(null == oper || "" == oper)
	{
		alert("操作员ID不能为空！");
		return false;
	}
	return true;
}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="operator.add.position"/></TD>
		<TD align="right"><a href="oper_back.action"><s:text name="operator.back"/></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="insertoper.action?method=insert" onsubmit="return check();" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="operator.property.operid"/></TD>
		<TD><input type="text" name="operId" maxlength="10" readonly="readonly"><a href="javascript:selectStaff()">Lookup</a></TD>
	</TR>
	<TR>
		<TD><s:text name="operator.property.opername"/></TD>
		<TD><input type="text" name="operName" maxlength="128" ></TD>
	</TR>
	<TR>
		<TD><s:text name="operator.property.password"/></TD>
		<TD><input type="text" name="password" maxlength="128"></TD>
	</TR>
	<tr>
		<td><s:text name="operator.property.role"/></td>
		<td>
			<select name="roleId">
				<s:iterator var="r" value="roles">
					<option value="${r.roleId }">${r.roleName }</option>								
				</s:iterator>
			</select>
		</td>
	</tr>

	<TR>
		<TD >
			<input type="submit" value="<s:text name='button.submit'/>">
			<input type="reset" name="reset" value="<s:text name='button.reset'/>"/>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

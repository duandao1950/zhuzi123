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
<title><s:text name="operator.edit.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="operator.edit.position"/></TD>
		<TD align="right"><a href="oper_back.action"><s:text name="operator.back"/></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="operator_update.action" method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<TABLE border="0" width="45%">
	<TR>
		<TD class="tablebody"><s:text name="operator.property.operid"/></TD>
		<TD>
		<input type="text" name="operId" value="${operId}" maxlength="10" readonly="true"/>
		</TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="operator.property.opername"/></TD>
		<TD><input type="text" name="operName" value="${operName}" maxlength="128"/></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="operator.property.password"/></TD>
		<TD><input type="text" name="password" value="${password}" maxlength="128"/></TD>
	</TR>
	<tr>
		<td class="tablebody"><s:text name="operator.property.role"/></td>
		<td>
			<select name="roleId" style="width:153">
				<s:iterator var="r" value="roles">
					<option value="${r.roleId }"} ${operRol.roleId == r.roleId ? 'selected':''}>${r.roleName }</option>
				</s:iterator>
			</select>
		</td>
	</tr>
	<TR>
		<TD class="tablebody"><s:text name="operator.property.valid"/></TD>
		<TD>
			<select name="valid" style="width:153" >
				<option value="0" ${valid == 0 ? 'selected':'' }><s:text name="operator.invalid"/></option>
				<option value="1" ${valid == 1 ? 'selected':'' }><s:text name="operator.valid"/></option>
			</select>
		</TD>
	</TR>	
	<tr>
		<td class="tablebody"><s:text name="operator.property.lastlogintime"/></td>
		<td>
			<input type="text" name="logintime" value="${logintime }"/>
		</td>
	</tr>
	<TR >
		<TD colspan="2" align="center"><input type="submit" value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

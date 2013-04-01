<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><s:text name="operators_role_relation.page.position" />
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
			function Add(){
       			window.location.href = "operator_manage_add.action";
   			}
   			
   			function Back(){
		       	window.location.href = "operator_manage_back.action";
		   	}
		</script>
	</head>

	<body>
	<form action="operator_roles_relation_update.action" method="post" enctype="multipart/form-data">
		<TABLE border="0" width="100%" class="position">
			<TR>
				<TD>
					<s:text name="operators_role_relation.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<TD align="right">
				<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<tr>
				<td>
					<s:text name="operators.page.operId" />
				</td>
				<td>
					<input type="text" name="operId" value="${operators.operId}" disabled>
					<input type="hidden" name="operId" value="${operators.operId}">
				</td>
				<td>
				    <s:text name="operators.page.operName" />
				</td>
				<td>
					<input type="text" name="operName" value="${operators.operName}" disabled>
				</td>
				<td>
					<s:text name="operators.page.isValid" />
				</td>
				<td>
					<input type="text" name="isValid" value="${operators.isValid}" disabled>
				</td>
			</tr>
			
		</TABLE>
		<TABLE border="0" width="100%">
			<tr>
				 &nbsp;<s:text name="operator_manage.page.roleId" />
			    <s:checkboxlist name="rolesId" list="#request.roleList" listKey="roleId" listValue="roleName" value="#request.operatorRolesList"/>
			</tr>
			<TR>
				<TD colspan="6" align="right"><input type="submit"
					value="<s:text name='button.submit'/>"></TD>
			</TR>
		</TABLE>
		</form>
	</body>
</html>

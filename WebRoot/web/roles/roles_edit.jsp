<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/upload.tld" prefix="site"%>
<html:html locale = "true"/> 
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="roles_edit.page.title"/></title>

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
		<TD><s:text name="roles_edit.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="roles_update.action" method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<input type="hidden" name="roleId" value="${roles.roleId}">	
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="roles.page.roleId"/></TD>
		<TD><input type="text" name="roleId" value="${roles.roleId}" disabled/></TD>
		<TD><s:text name="roles.page.roleName"/></TD>
		<TD><input type="text" name="roleName" value="${roles.roleName}"/></TD>
		<TD></TD>
	</TR>
	<TR>
		<TD><s:text name="roles.page.isValid"/></TD>
		<TD>
			<select name="isValid">
			    <s:if test="roles.isValid==1">
			    	<option value='1' selected="selected">Yes</option>
			    	<option value='0'>No</option>
			    </s:if>
				<s:else>
				    <option value='1'>Yes</option>
					<option value='0' selected="selected">No</option>
				</s:else>
			</select>
		</TD>
		<TD><s:text name="roles.page.createTime"/></TD>
		<TD><input type="text" name="createTime" value="${roles.createTime}"/></TD>
	</TR>
	
	<TR>
		<TD><s:text name="roles.page.description"/></TD>
		<td colspan="5"><input type="textarea" name="description" value="${roles.description}" rows="10"/></TD>
	</TR>
	<TR>
		<TD colspan="6" align="right"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

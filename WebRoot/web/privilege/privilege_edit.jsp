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

<title><s:text name="privilege_edit.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function Back(){
       	window.location.href = "privilege_back.action";
   	}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="privilege_edit.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="privilege_update.action" method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<input type="hidden" name="privilegeId" value="${privilege.privilegeId}">	
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="privilege.page.name"/></TD>
		<TD><input type="text" name="privilegeName" value="${privilege.privilegeName}" maxlength="50"/></TD>
		<TD><s:text name="privilege.page.url"/></TD>
		<TD>
			<s:if test="privilege.privilegeLevel==0">
				<input type="text" name="url" value="${privilege.url}" maxlength="10" disabled/>
			</s:if>
			<s:else>
				<input type="text" name="url" value="${privilege.url}" maxlength="10"/>
			</s:else>
		</TD>
	</TR>
	<TR>
		<TD><s:text name="privilege.page.porder"/></TD>
		<TD><input type="text" name="porder" value="${privilege.porder}" maxlength="20"/></TD>
		<TD><s:text name="privilege.page.parentPorder"/></TD>
		<TD><input type="text" name="parentPorder" value="${privilege.parentPorder}" maxlength="50"/></TD>
	</TR>
	<TR>
		<TD><s:text name="privilege.page.privilegeLevel"/></TD>
		<TD><input type="text" name="privilegeLevel" value="${privilege.privilegeLevel}" maxlength="20"/></TD>
		<TD><s:text name="privilege.page.orderNumber"/></TD>
		<TD><input type="text" name="orderNumber" value="${privilege.orderNumber}" maxlength="100"/></TD>
	</TR>
	<TR>
		<TD><s:text name="privilege.page.description"/></TD>
		<TD><input type="text" name="description" value="${privilege.description}" maxlength="100"/></TD>
	</TR>
	<TR>
		<TD colspan="4" align="right"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

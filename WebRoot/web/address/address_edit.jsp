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

<title><s:text name="address_edit.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="address_edit.page.position"/></TD>
		<TD align="right"><a href="address_back.action"><s:text name="address_edit.page.back"/></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="address_update.action" method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<input type="hidden" name="id" value="${address_obj.id}">	
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="address.page.name"/></TD>
		<TD><input type="text" name="name" value="${address_obj.name}" maxlength="50"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.sex"/></TD>
		<TD><input type="text" name="sex" value="${address_obj.sex}" maxlength="10"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.mobile"/></TD>
		<TD><input type="text" name="mobile" value="${address_obj.mobile}" maxlength="20"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.email"/></TD>
		<TD><input type="text" name="email" value="${address_obj.email}" maxlength="50"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.qq"/></TD>
		<TD><input type="text" name="qq" value="${address_obj.qq}" maxlength="20"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.company"/></TD>
		<TD><input type="text" name="company" value="${address_obj.company}" maxlength="100"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.address"/></TD>
		<TD><input type="text" name="address" value="${address_obj.address}" maxlength="100"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.postcode"/></TD>
		<TD><input type="text" name="postcode" value="${address_obj.postcode}" maxlength="10"/></TD>
	</TR>
	<TR>
		<TD><s:text name="address.page.updateDate"/></TD>
		<TD><input type="text" name="updateDate" value="${address_obj.updateDate}" maxlength="10"/></TD>
	</TR>
	<%-- 上传标签 --%>
	<site:upload/>
	<TR>
		<TD colspan="2"><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

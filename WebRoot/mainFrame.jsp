<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title></title>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html;CHARSET=UTF-8">	
</head>
<frameset Rows = "48,*" frameborder=yes bordercolor="#000000" border="0">
	<frame src="top.jsp" name="top" SCROLLING="No" noresize>
	<frameset cols = "180,*" frameborder=yes bordercolor="#000000" border="0">
		<frame src="menulist.action" name="left">
		<frame SRC="welcome.action" NAME="main" SCROLLING="auto" noresize>
	</frameset>
</frameset>
</html>
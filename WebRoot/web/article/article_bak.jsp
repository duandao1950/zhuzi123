<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT type="text/javascript" src="<%=path%>/js/jquery-1.6.1.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/js/web/article/article.js"></script>
</head>
<body>
<form id="articleForm" method="post">
    <div>
		<TABLE border="0" width="100%">
			<TR>
				<TD>style</TD>
				<TD><input type="text" name="styleId" id="styleId" value="1"></TD>
				<TD>title</TD>
				<TD><input type="text" name="title" id="title" value="1"></TD>
				<TD>author name</TD>
				<TD><input type="text" name="authorId" id="authorId" value="1"></TD>
				<TD>content</TD>
				<TD><input type="text" name="content" id="content" value="1"></TD>
				<TD>content extend</TD>
				<TD><input type="text" name="contentExt" id="contentExt" value="1"></TD>
				<TD><input type="submit" id="add_article" name="add_article" value="Add"/></TD>
		    </TR>
		</TABLE>
		<span id="Tip"></span>
	</div>
</form>
</body>
</html>
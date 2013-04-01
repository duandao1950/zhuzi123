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
<title><s:text name="contract.project.add.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/calendar-blue.css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>

</head>

<body>

<form action="realproject_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="real.project.add.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>

<b><s:actionerror/></b>
<TABLE border="0" width="50%">
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.project.no" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectNo" maxlength="32" ></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.project.version" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectVersion" maxlength="32" ></TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.project.name" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectName" maxlength="32"></TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.project.version.name" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectVersionName" maxlength="32"></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.start.date" />&nbsp;&nbsp;</TD>
		<TD>
			<input type="text" readonly="readonly" class="backgroundDate" name="startDate" id="stime" value="">		 
		 	<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'startDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.end.date" />&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="endDate" id="etime" value="">
		 <img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'endDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.persons" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="persons" maxlength="4"></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="real.project.page.remark" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="remark" maxlength="128"></TD>
	</TR>
	
	<TR>
	    <TD></TD>
		<TD >
		<table border="0" width="100%">
			<tr>
				<td class="buttontable">
				<input type="submit"
				value="<s:text name='button.submit'/>">
				</td>
				<td width="53%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
	
</TABLE>
</form>
</body>
</html>

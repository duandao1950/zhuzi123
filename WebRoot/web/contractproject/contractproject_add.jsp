<%@ page contentType="text/html;charset=gbk" language="java"%>
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

<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link rel="stylesheet" type="text/css" href="css/calendar-blue.css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>

</head>

<body>

<form action="contractproject_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="contract.project.add.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>

<b><s:actionerror/></b>
<TABLE border="0" width="50%">
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.contract.no"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="contractNo" maxlength="32" ></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.project.no"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectNo" maxlength="32" ></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.project.name"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="projectName" maxlength="64"></TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.assign.date"/>&nbsp;&nbsp;</TD>
		<TD>
		 <input type="text" readonly="readonly" class="backgroundDate" name="assignDate" id="atime" value="">
		 <img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'assignDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.open.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="openDate" id="otime" value="">
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'openDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.plan.start.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="planStartDate" id="pstime" value="">
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'planStartDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.plan.end.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="planEndDate" id="petime" value="">
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'planEndDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.real.start.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="realStartDate" id="rstime" value="">
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'realStartDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.real.end.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="realEndDate" id="retime" value="">
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'realEndDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.our.intf.person"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="ourIntfPerson" maxlength="8"></TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.other.intf.person"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="otherIntfPerson" maxlength="8"></TD>
	</TR>
	<TR>
		<TD  class="tablebody"><s:text name="contract.project.page.contract.count.person"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="contractCountPerson" maxlength="4"></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD>
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

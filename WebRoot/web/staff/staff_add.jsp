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
<title><s:text name="asset.add.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/calendar-blue.css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>

<script type="text/javascript">
	function addStaff()
	{
	    var staffId = document.forms[0].staffId.value;
	    var staffName = document.forms[0].staffName.value;
	    var tel1 = document.forms[0].tel1.value;
	    var email1 = document.forms[0].email1.value;
	    var enterComDate = document.forms[0].enterComDate.value;
	    
	    if(null == staffId || "" == staffId)
	    {
	        alert("必须输入员工号！");
	        return null;
	    }
	    if(null == staffName || "" == staffName)
	    {
	        alert("必须输入员工姓名！");
	        return null;
	    }
	    if(null == tel1 || "" == tel1)
	    {
	        alert("必须输入第一联系方式！");
	        return null;
	    }
	    if(null == email1 || "" == email1)
	    {
	        alert("必须输入第一邮箱地址！");
	        return null;
	    }
	    if(null == enterComDate || "" == enterComDate)
	    {
	        alert("必须输入入职时间！");
	        return null;
	    }
		document.forms[0].action = "staff_insert.action?method=insert";
		document.forms[0].submit();
	}
	
	function text()
	{
		alert("staff2");
	}

</script>

</head>

<body>
<form action="staff_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
   </TR>
   <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="staff.add.page.position" /></b></TD>
   </TR>
   <TR height="2">
        <TD></TD>
   </TR>
</TABLE>
<TABLE border="0" width="60%">

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffId" maxlength="10">&nbsp;<font color="#C10202">*</font></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.name"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffName" maxlength="50" >&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.skill"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="skill" maxlength="128"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.status"/>&nbsp;&nbsp;</TD>
		<TD>
		    <select name="statusId">
		        <option value="0">离职</option>
		        <option value="1" selected="selected">在职</option>
		    </select>
        </TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel1"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="tel1" maxlength="16" >&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel2"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="tel2" maxlength="16"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.email1"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="email1" maxlength="64" >&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.email2"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="email2" maxlength="64" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.enter.com.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="enterComDate" id="enComtime" value="${staff_obj.enterComDate}" />
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'enterComDate','cn','dateTime','yyyy-MM-dd','right','down')">
		&nbsp;<font color="#C10202">*</font>
		</TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.exit.com.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="exitComDate" id="exComtime" value="${staff_obj.exitComDate}"/>
		<img src="/zhuzi123/images/button/calstyle3.gif" onClick="popUpCalendar(this,'exitComDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.group.name"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="groupName" maxlength="64" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.work.years"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="workYears" maxlength="2" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.remark"/>&nbsp;&nbsp;</TD>
		<TD>
		<textarea name="remark" rows="4" cols="50"></textarea>
		</TD>
	</TR>
	<TR>
	    <TD height="30px"></TD>
		<TD>
		<input type="button" value="<s:text name='button.submit'/>" onclick="addStaff()">
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

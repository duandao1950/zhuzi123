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
<title><s:text name="asset.edit.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/calendar-blue.css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script language="javascript" type="text/javascript" src="js/popcalendar.js"></script>
<script type="text/javascript">
	function editStaff()
	{
	    var staffId = document.forms[0].staffId.value;
	    var staffName = document.forms[0].staffName.value;
	    var tel1 = document.forms[0].tel1.value;
	    var email1 = document.forms[0].email1.value;
	    var enterComDate = document.forms[0].enterComDate.value;
	    if(null == staffId && "" == staffId)
	    {
	        alert("必须输入员工号！");
	        return；
	    }
	    if(null == staffName && "" == staffName)
	    {
	        alert("必须输入员工姓名！");
	        return；
	    }
	    if(null == tel1 && "" == tel1)
	    {
	        alert("必须输入第一联系方式！");
	        return；
	    }
	    if(null == email1 && "" == email1)
	    {
	        alert("必须输入第一邮箱地址！");
	        return；
	    }
	    if(null == enterComDate && "" == enterComDate)
	    {
	        alert("必须输入入职时间！");
	        return；
	    }
		document.forms[0].action = "staff_update.action?method=update";
		document.forms[0].submit();
	}

</script>
</head>

<body>
<form action="staff_update.action?method=update" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="staff.query.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>
<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffId" value="${staff_obj.staffId}" maxlength="10">&nbsp;<font color="#C10202">*</font></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.staff.name"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffName" value="${staff_obj.staffName}" maxlength="50" >&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.skill"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="skill" value="${staff_obj.skill}" maxlength="128"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.status"/>&nbsp;&nbsp;</TD>
		<TD>
		    <select name="statusId">
		        <option value="0" ${staff_obj.statusId == 0 ? 'selected':'' }>离职</option>
		        <option value="1" ${staff_obj.statusId == 1 ? 'selected':'' }>在职</option>
		    </select>
        </TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel1"/>&nbsp;&nbsp;&nbsp;<font color="#C10202">*</font></TD>
		<TD><input type="text" name="tel1" value="${staff_obj.tel1}" maxlength="16" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.tel2"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="tel2" value="${staff_obj.tel2}" maxlength="16"></TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="staff.page.email1"/>&nbsp;&nbsp;&nbsp;<font color="#C10202">*</font></TD>
		<TD><input type="text" name="email1" value="${staff_obj.email1}" maxlength="64" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.email2"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="email2" value="${staff_obj.email2}" maxlength="64" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.enter.com.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="enterComDate" id="enComtime" value="${staff_obj.enterComDate}" />
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'enterComDate','cn','dateTime','yyyy-MM-dd','right','down')">
		&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.exit.com.date"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" readonly="readonly" class="backgroundDate" name="exitComDate" id="exComtime" value="${staff_obj.exitComDate}"/>
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'exitComDate','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.group.name"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="groupName" value="${staff_obj.groupName}" maxlength="64" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.work.years"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="workYears" value="${staff_obj.workYears}" maxlength="2" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="staff.page.remark"/>&nbsp;&nbsp;</TD>
		<TD>
		<textarea name="remark" rows="4" cols="50">${staff_obj.remark}</textarea>
		</TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD>
            <table border="0" width="100%">
			<tr>
				<td class="buttontable">
				<input type="button" onclick="editStaff()"
				value="<s:text name='button.submit'/>">
				</td>
				<td width="57%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

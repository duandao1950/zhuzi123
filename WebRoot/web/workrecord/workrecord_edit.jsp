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

<title><s:text name="workrecord.edit.page.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<script language="javascript" type="text/javascript" src="js/popcalendar.js"></script>
<script type="text/javascript">

function display()
{
    alert('aaa');
	var workType = document.forms[0].workType.value;
	alert(workType);
	alert(document.getElementById("approve"));
	alert(document.getElementById("approve").style);
	alert(document.getElementById("approve").style.display);
	if('0' == workType)
	{
	      document.getElementById("approve").style.display="none";
	      document.getElementById("flag").style.display="none";
	      document.getElementById("reason").style.display="none";
	}

}


function selectApproveStaff()
{
    var url="staff_toqry.action?method=toQry";
    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].approveStaffId.value = submitValue;
    }
}

function addRecord()
{
    var workType = document.forms[0].workType.value;
	var approveStaffId = document.forms[0].approveStaffId.value;
	var workReason = document.forms[0].workReason.value;
	var startTime = document.forms[0].startTime.value;
	var endTime = document.forms[0].endTime.value;
	
	if("0" != workType && (null == approveStaffId || approveStaffId.length ==0 ))
	{
	    alert("必须选择审批员工号");
	    return;
	}
	if("1" == workType && (null == workReason || workReason.length == 0))
	{
	    alert("必须输入加班原因");
	    return;
	}
	if(null == startTime || startTime.length == 0)
	{
	    alert("必须输入上班时间");
	    return;
	}
	if(null == endTime || endTime.length == 0)
	{
	    alert("必须输入下班时间");
	    return;
	}
	if("0" == workType)
	{
	    document.forms[0].approveFlag.value="";
	}
	document.forms[0].action="workrecord_update.action?method=update";
	document.forms[0].submit();
	

}

</script>
</head>

<body >
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="workrecord.edit.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>

<form action="workrecord_update.action?method=update" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>

<TABLE border="0" width="50%">

    <TR>
		<TD class="tablebody"><s:text name="workrecord.page.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="id" value="${workrecord_obj.id}" maxlength="10" readonly="readonly"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.staff.id"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="staffId" value="${workrecord_obj.staffId}" maxlength="10" readonly="readonly" ></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.prog.team"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="progTeam" value="${workrecord_obj.progTeam}" maxlength="30" ></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.work.type"/>&nbsp;&nbsp;</TD>
		<TD>
		    <input type="hidden" name="workType" value="${workrecord_obj.workType}">
		    <select disabled="disabled">
				<option value="0" ${workrecord_obj.workType == '0' ? 'selected':'' }>正常上班</option>
				<option value="1" ${workrecord_obj.workType == '1' ? 'selected':'' }>加班</option>
				<option value="2" ${workrecord_obj.workType == '2' ? 'selected':'' }>调休</option>
				<option value="3" ${workrecord_obj.workType == '3' ? 'selected':'' }>请假</option>
				<option value="4" ${workrecord_obj.workType == '4' ? 'selected':'' }>年休</option>
			</select>
		</TD>
	</TR>
	
	<TR style="display:${approve }">
		<TD class="tablebody"><s:text name="workrecord.page.approve.staff.id" />&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" name="approveStaffId" value="${workrecord_obj.approveStaffId}"
		    maxlength="20" readonly="readonly">&nbsp;
		<a href="javascript:selectApproveStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR style="display:${approve }">
		<TD class="tablebody"><s:text name="workrecord.page.approve.flag"/>&nbsp;&nbsp;</TD>
		<TD>
			<select name="approveFlag">
			<option value="0" ${workrecord_obj.approveFlag == 0 ? 'selected':'' }>未审批</option>
			<option value="1" ${workrecord_obj.approveFlag == 1 ? 'selected':'' }>通过</option>
			<option value="2" ${workrecord_obj.approveFlag == 2 ? 'selected':'' }>未通过</option>
			</select>
		</TD>
	</TR>
	
	<TR style="display:${reason }">
		<TD class="tablebody"><s:text name="workrecord.page.work.reason"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="workReason" value="${workrecord_obj.workReason}" maxlength="20"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.start.time"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" name="startTime" maxlength="20" class="Wdate" value="${workrecord_obj.startTime}" readonly="readonly"/> 
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'startTime','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.end.time"/>&nbsp;&nbsp;</TD>
		<TD>
		<input type="text" name="endTime" maxlength="20" class="Wdate" value="${workrecord_obj.endTime}" readonly="readonly"/>
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'endTime','cn','dateTime','yyyy-MM-dd','right','down')">
		</TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.remark"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="remark" value="${workrecord_obj.remark}" maxlength="50"></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD>
		<table border="0" width="100%">
			<tr>
				<td class="buttontable">
				<input type="submit"
				value="<s:text name='button.submit'/>" onclick="addRecord()">
				</td>
				<td width="59%"></td>
			</tr>
		</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

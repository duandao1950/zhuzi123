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

<title><s:text name="workrecord.add.page.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">

<script language="javascript" type="text/javascript" src="js/popcalendar.js"></script>


<script type="text/javascript">
function selectStaff()
{
    var url="staff_toqry.action?method=toQry";
    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].staffId.value = submitValue;
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
	var staffId = document.forms[0].staffId.value;
	var workType = document.forms[0].workType.value;
	var approveStaffId = document.forms[0].approveStaffId.value;
	var workReason = document.forms[0].workReason.value;
	var startTime = document.forms[0].startTime.value;
	var endTime = document.forms[0].endTime.value;
	
	if(null == staffId || staffId.length == 0)
	{
	    alert("必须选择员工号");
	    return;
	}
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
	document.forms[0].action="workrecord_insert.action?method=insert";
	document.forms[0].submit();
	



}
function toDisplay()
{
var workType = document.forms[0].workType.value;
if('0' != workType)
{
    document.getElementById("approve").style.display="block";
    document.getElementById("flag").style.display="block";
}

if('1' == workType)
{
     document.getElementById("reason").style.display="block";
}
if('1' != workType)
{
     document.getElementById("reason").style.display="none";
}

if('0' == workType)
{
      document.getElementById("approve").style.display="none";
      document.getElementById("flag").style.display="none";
      document.getElementById("reason").style.display="none";
}



}


</script>

</head>

<body>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="workrecord.add.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>
		
<form action="workrecord_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>

<TABLE border="0" width="50%">
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.staff.id"/>&nbsp;&nbsp;</TD>
		<TD width="40%">
		<input type="text" name="staffId" maxlength="10" readonly="readonly">&nbsp;
		<a href="javascript:selectStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.prog.team"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="progTeam" maxlength="30" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.work.type"/>&nbsp;&nbsp;</TD>
		<TD>
		<select name="workType" onchange="toDisplay()">
		<option value="0">正常上班</option>
		<option value="1">加班</option>
		<option value="2">调休</option>
		<option value="3">请假</option>
		<option value="4">年休</option>
		</select>
		</TD>
	</TR>
	
	<TR id="approve" style="display:none;">
		<TD class="tablebody"><s:text name="workrecord.page.approve.staff.id" />&nbsp;&nbsp;</TD>
		<TD><input type="text" name="approveStaffId" maxlength="10" readonly="readonly">&nbsp;
		<a href="javascript:selectApproveStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR id="flag" style="display:none;">
		<TD class="tablebody"><s:text name="workrecord.page.approve.flag"/>&nbsp;&nbsp;</TD>
		<TD>
		<select name="approveFlag">
		<option value="0">未审批</option>
		<option value="1">通过</option>
		<option value="2">未通过</option>
		</select>
		</TD>
	</TR>
	
	<TR id="reason" style="display:none;">
		<TD class="tablebody"><s:text name="workrecord.page.work.reason"/>&nbsp;&nbsp;</TD>
		<TD>
		<textarea name="workReason" rows="4" cols="50"></textarea>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.start.time"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="startTime" maxlength="20" class="Wdate" readonly="readonly"/>
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'startTime','cn','dateTime','yyyy-MM-dd','right','down')">
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.end.time"/>&nbsp;&nbsp;</TD>
		<TD><input type="text" name="endTime" maxlength="20" class="Wdate" readonly="readonly"/>
		<img src="/EMG/images/button/calstyle3.gif" onClick="popUpCalendar(this,'endTime','cn','dateTime','yyyy-MM-dd','right','down')">
		
		</TD>
	</TR>

	<TR>
		<TD class="tablebody"><s:text name="workrecord.page.remark"/>&nbsp;&nbsp;</TD>
		<TD>
		<textarea name="remark" rows="4" cols="50"></textarea>
		</TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD></TD>
	</TR>
	<TR height="40">
	    <TD></TD>
		<TD class="buttontable">
		<input type="button" value="<s:text name='button.submit'/>" onclick="addRecord()"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

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


function addRecord()
{

}

</script>

</head>

<body>
<form action="perCRM_update.action?method=update" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
	<TR>
		<TD>
		<s:text name="performance.crm.add.page.position" />
		</TD>
	</TR>
</TABLE>
<table>
<tr>
<td></td>

</tr>
</table>
<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.staff.id"/></TD>
		<TD>
		<input type="text" name="staffId" maxlength="20" readonly="readonly" value="${perCRM_obj.staffId }">&nbsp;
		<a href="javascript:selectStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.staff.name"/></TD>
		<TD><input type="text" name="staffName" maxlength="30" value="${perCRM_obj.staffName }"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.requirment.analyze"/></TD>
		<TD><input type="text" name="requirmentAnalyze" maxlength="4" value="${perCRM_obj.requirmentAnalyze }"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.coding"/></TD>
		<TD><input type="text" name="coding" maxlength="4" value="${perCRM_obj.coding }"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.problem.counts"/></TD>
		<TD><input type="text" name="problemCounts" maxlength="4" value="${perCRM_obj.problemCounts }"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.check.code"/></TD>
		<TD><input type="text" name="checkCode" maxlength="4" value="${perCRM_obj.checkCode }"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.code.confirm"/></TD>
		<TD><input type="text" name="codeConfirm" maxlength="4" value="${perCRM_obj.codeConfirm }" ></TD>
	</TR>
	
	
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.work.attitude"/></TD>
		<TD><input type="text" name="workAttitude" maxlength="4" value="${perCRM_obj.workAttitude }" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.training"/></TD>
		<TD><input type="text" name="training" maxlength="4" value="${perCRM_obj.training }" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.team.contribute"/></TD>
		<TD><input type="text" name="teamContribute" maxlength="4" value="${perCRM_obj.teamContribute }" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.daily.work"/></TD>
		<TD><input type="text" name="dailyWork" maxlength="4" value="${perCRM_obj.dailyWork }" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.in.month"/></TD>
		<TD><input type="text" name="inMonth" maxlength="6" value="${perCRM_obj.inMonth }" ></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.other"/></TD>
		<TD><input type="text" name="other" maxlength="4" value="${perCRM_obj.other }" ></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD colspan="2" ><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

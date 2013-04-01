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
<title><s:text name="asset.query.page.position"/></title>
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
    var submitValue = window.open(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].staffId.value = submitValue;
    }
}

$(function() {
	$( "#dialog-form1" ).hide();
	$( "#create-user1" ).button().click(function() {
			$( "#dialog-form1" ).dialog( "open" );
	});
});


function addRecord()
{

}

</script>

</head>
<body>
<form action="perCRM_list.action?method=list" method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="asset.query.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>

<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.staff.id"/></TD>
		<TD>
		<input type="text" name="staffId" maxlength="20" readonly="readonly">&nbsp;
		<a href="javascript:selectStaff()">Lookup</a>
		<button id="create-user1">Add</button>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.staff.name"/></TD>
		<TD><input type="text" name="staffName" maxlength="20" ></TD>
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
				<td width="57%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

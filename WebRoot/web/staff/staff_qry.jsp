<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title><s:text name="workrecord.query.page.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">

<script type="text/javascript">
function toQuery()
{
	document.forms[0].target="search";
	document.forms[0].action="staff_show.action?method=toShow";
	document.forms[0].submit();
}
</script>

</head>

<body>
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
<form action="staff_show.action?method=toShow" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%">
    <TR>
        <TD width="20%"></TD>
        <TD>
        <TABLE border="0" width="100%">

	        <TR>
		        <TD class="tablebody"><s:text name="staff.page.staff.id"/>&nbsp;&nbsp;</TD>
		        <TD><input type="text" name="staffId" maxlength="10"></TD>
	        </TR>

	        <TR>
		        <TD class="tablebody"><s:text name="staff.page.staff.name"/>&nbsp;&nbsp;</TD>
		        <TD><input type="text" name="staffName" maxlength="20"></TD>
	        </TR>
	        <TR>
	            <TD></TD>
		         <TD colspan="2" ></TD>
	        </TR>
        </TABLE>
        </TD>
        <TD width="20%"></TD>
    
    </TR>
    <TR>
        <TD style="height:50px"></TD>
        <TD style="text-align:right;">
            <input type="button" value="<s:text name='button.submit'/>" onclick="toQuery();"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         
        </TD>
        <TD style="height:40px"></TD>
    </TR>
    <TR class="tablebody">
        <TD></TD>
        <TD></TD>
        <TD></TD>
    </TR>

</TABLE>

</form>
<TABLE width="100%">

      <TR>
        <TD></TD>
        <TD>
        <iframe name="search" frameborder="0" width="100%" height="450" scrolling="auto"></iframe>
        </TD>
        <TD ></TD>
    </TR>


</TABLE>
</body>
</html>

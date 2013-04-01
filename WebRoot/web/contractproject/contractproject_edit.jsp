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
<script type="text/javascript" src="js/calendar.js"></script>
</head>

<body>

<form action="contractproject_update.action?method=update" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
   <TR height="2">
        <TD></TD>
    </TR>
    <TR>
        <TD>&nbsp;&nbsp;<b><s:text name="contract.project.edit.page.position" /></b></TD>
    </TR>
     <TR height="2">
        <TD></TD>
    </TR>
</TABLE>
<b><s:actionerror/></b>
<TABLE border="0" width="50%">
    <TR>
		<TD class="tablebody"><s:text name="contract.project.page.id"/></TD>
		<TD><input type="text" name="id" value="${contractProject_obj.id}" maxlength="32" readonly="readonly"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.contract.no"/></TD>
		<TD><input type="text" name="contractNo" value="${contractProject_obj.contractNo}" maxlength="32" readonly="readonly"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.project.no"/></TD>
		<TD><input type="text" name="projectNo" value="${contractProject_obj.projectNo}" maxlength="64" readonly="readonly" ></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.project.name"/></TD>
		<TD><input type="text" name="projectName" maxlength="20" value="${contractProject_obj.projectName}"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.assign.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('atime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="assignDate" id="atime" value="${contractProject_obj.assignDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.open.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('otime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="openDate" id="otime" value="${contractProject_obj.openDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.plan.start.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('pstime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="planStartDate" id="pstime" value="${contractProject_obj.planStartDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.plan.end.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('petime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="planEndDate" id="petime" value="${contractProject_obj.planEndDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.real.start.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('rstime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="realStartDate" id="rstime" value="${contractProject_obj.realStartDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.real.end.date"/></TD>
		<TD>
		<input type="text" onclick="showCalendar('retime', 'y-mm-dd');$.xjreloadtrain();return false;" 
		 readonly="readonly" class="backgroundDate" name="realEndDate" id="retime" value="${contractProject_obj.realEndDate}">
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.our.intf.person"/></TD>
		<TD><input type="text" name="ourIntfPerson" maxlength="8" value="${contractProject_obj.ourIntfPerson}"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.other.intf.person"/></TD>
		<TD><input type="text" name="otherIntfPerson" maxlength="8" value="${contractProject_obj.otherIntfPerson}"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="contract.project.page.contract.count.person"/></TD>
		<TD><input type="text" name="contractCountPerson" maxlength="4" value="${contractProject_obj.contractCountPerson}"></TD>
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
				<td width="54%"></td>
			</tr>
			
			</table>
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>

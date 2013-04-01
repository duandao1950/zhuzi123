<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%@ taglib uri="/WEB-INF/emg-UI.tld" prefix="emg"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		
		<script type="text/javascript">
		
		function editWorkRecord(id)
		{
			document.forms[0].action="workrecord_edit.action?method=edit&id="+id;
			document.forms[0].submit();
		}
		
		function deleteWorkRecord(id)
		{
			if(!confirm("<s:text name="message.delete.confirm"/>"))
		  {
		      return;
		  }
		  document.forms[0].action="workrecord_delete.action?id="+id;
		  document.forms[0].submit();
		}

        </script>
		
	</head>

	<body>
	<form action="workrecord_list.action?method=list" method="POST" enctype="multipart/form-data"/>
		<TABLE border="0" width="100%" class="position">
			<TR>
				<TD height="25px">
					<s:text name="workrecord.list.page.position" />
				</TD>
				<TD align="right">
					<a href="workrecord_add.action"><s:text name="workrecord.page.add" />
					</a>
				</TD>
			</TR>
		</TABLE>
		<table>
		<tr>
		<td>
		</td>
		</tr>
		</table>
		<TABLE width="100%" style="text-align:center;">
			<TR class="listtablebody">
				<TD width="8%" >
					<s:text name="workrecord.page.staff.id" />
				</TD>
				<TD width="10%">
					<s:text name="workrecord.page.prog.team" />
				</TD>
				<TD width="8%" >
					<s:text name="workrecord.page.work.type" />
				</TD>
				<TD width="8%">
					<s:text name="workrecord.page.approve.staff.id" />
				</TD>
				<TD width="6%" >
					<s:text name="workrecord.page.approve.flag" />
				</TD>
				<TD width="17%">
					<s:text name="workrecord.page.work.reason" />
				</TD>
				<TD width="12%" >
					<s:text name="workrecord.page.start.time" />
				</TD>
				<TD width="12%">
					<s:text name="workrecord.page.end.time" />
				</TD>
				<TD width="11%" >
					<s:text name="workrecord.page.remark" />
				</TD>
				<TD width="8%">
				
				</TD>
				
			</TR>

			<s:iterator value="beanList">
				<tr>
					<td >
						<s:property value="staffId" />
					</td>
					<td>
						<s:property value="progTeam" />
					</td>
					<td >
					    <emg:textTag inf_name="WORK_TYPE" id="${workType}"></emg:textTag>
					</td>
					<td>
						<s:property value="approveStaffId" />
					</td>
					<td >
						<emg:textTag inf_name="APPROVE_FLAG" id="${approveFlag}"></emg:textTag>
					</td>
					<td>
						<s:property value="workReason" />
					</td>
					<td >
					    <s:date name="startTime" format="yyyy-MM-dd HH:ss:mm"/>
					</td>
					<td>
					   <s:date name="endTime" format="yyyy-MM-dd HH:ss:mm"/>
					</td>
					<td >
						<s:property value="remark" />
					</td>
					<td>
						<img src="./images/IcoBtn_Detail.gif" onclick="javascript:editWorkRecord(${id })"></img>
						<img src="./images/IcoBtn_Delete.gif" onclick="javascript:deleteWorkRecord(${id })"></img>
					</td>
				</tr>
				<TR class="listtablebody">
				<TD ></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD ></TD>
				</TR>
			</s:iterator>
			
			<%-- 分页 --%>
		    <site:page name="page" action="workrecord_list.action" />
		</TABLE>
    </form>
	</body>
</html>

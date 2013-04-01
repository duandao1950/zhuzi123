<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><s:text name="role.list.title" /></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="performance.list.position" />
				</TD>
				<TD align="right">
					<a href="performanceOpt_add.action"><s:text
							name="performance.list.add"></s:text> </a>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>

		<TABLE border="0" width="100%">
			<TR class="tableheader">
				<TD>
					<s:text name="staff.page.staff.id"></s:text>
				</TD>
				<TD>
					<s:text name="staff.page.staff.name"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.workscore"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.PBCscore"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.logwrite"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.meetingscore"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.optsite"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.standbysite"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.recordissue"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.resolveissue"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.devscore"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.praiseletter"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.custcomplain"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.sitecomplain"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.custappraise"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.trainscore"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.other"></s:text>
				</TD>
				<TD>
					<s:text name="performance.list.belongmon"></s:text>
				</TD>
			</TR>

			<s:iterator value="beanList" status="addressNo">
				<tr>
					<td>
						<s:property value="staffId" />
					</td>
					<td>
						<s:property value="staffName" />
					</td>
					<td>
						<s:property value="workAttendence" />
					</td>
					<td>
						<s:property value="layPBC" />
					</td>
					<td>
						<s:property value="writeLog" />
					</td>
					<td>
						<s:property value="regularMeeting" />
					</td>
					<td>
						<s:property value="site" />
					</td>
					<td>
						<s:property value="siteBak" />
					</td>
					<td>
						<s:property value="problemCounts" />
					</td>
					<td>
						<s:property value="problemSolve" />
					</td>
					<td>
						<s:property value="coding" />
					</td>
					<td>
						<s:property value="praiseLetter" />
					</td>
					<td>
						<FONT color="red"><s:property value="custComplain" />
						</FONT>
					</td>
					<td>
						<FONT color="red"><s:property value="siteComplain" />
						</FONT>
					</td>
					<td>
						<s:property value="custAppraise" />
					</td>
					<td>
						<s:property value="training" />
					</td>
					<td>
						<s:property value="other" />
					</td>
					<td>
						<s:property value="month" />
					</td>

					<td>
						<a
							href="performanceOpt_edit?staffId=<s:property value='staffId'/>&month=<s:property value='month'/>">
							<s:text name='button.edit' /> </a>
						<a
							href="performanceOpt_delete.action?staffId=<s:property value='staffId'/>&month=<s:property value='month'/>">
							<s:text name='button.delete' /> </a>
					</td>
				</tr>
				<TR class="listtablebody">
			     <TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				</TR>
			</s:iterator>
			<%-- 分页 --%>
			<site:page name="page"  export="true" action="performanceOpt_list.action" />
		</TABLE>
		<table>
			<tr>
				<TD>
					<s:actionerror />
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red" />
					</b>
				</TD>
			</tr>
		</table>
	</body>
</html>

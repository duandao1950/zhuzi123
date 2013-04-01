<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
		<title>真实合同
		</title>

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
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="real.project.list.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				
				<TD align="right">
					<a href="realproject_add.action"><s:text name="real.project.page.add" />
					</a>
				</TD>
				 
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<TABLE border="0" width="100%" style="text-align:center;">
			<TR class="listtablebody">
			
			     <TD width="5%">
					<s:text name="real.project.page.id" />
				</TD>
				<TD width="10%">
					<s:text name="real.project.page.project.no" />
				</TD>
				<TD width="14%">
					<s:text name="real.project.page.project.version" />
				</TD>
				<TD width="14%">
					<s:text name="real.project.page.project.name" />
				</TD>
				<TD width="10%">
					<s:text name="real.project.page.project.version.name" />
				</TD>
				<TD width="10%">
					<s:text name="real.project.page.start.date" />
				</TD>
				<TD width="10%">
					<s:text name="real.project.page.end.date" />
				</TD>
				<TD width="8%">
					<s:text name="real.project.page.persons" />
				</TD>
				<TD width="10%">
					<s:text name="real.project.page.remark" />
				</TD>
				<TD>
				</TD>
			</TR>

			<s:iterator value="beanList">
				<tr>
				    <td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="projectNo" />
					</td>
					<td>
						<s:property value="projectVersion" />
					</td>
					<td>
						<s:property value="projectName" />
					</td>
					<td>
						<s:property value="projectVersionName" />
					</td>
					<td>
						<s:date name="startDate" format="yyyy-mm-dd" />
					</td>
					<td>
						<s:date name="endDate"format="yyyy-mm-dd" />
					</td>
					<td>
						<s:property value="persons" />
					</td>
					<td>
						<s:property value="remark" />
					</td>
					<td>
						<a href="realproject_edit.action?id=<s:property value='id'/>"><s:text
								name='button.edit' />
						</a>
						<a href="realproject_delete.action?id=<s:property value='id'/>"><s:text
								name='button.delete' />
						</a>
				    
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
		    <site:page name="page" action="realproject_list.action" />
		</TABLE>
		
	</body>
</html>

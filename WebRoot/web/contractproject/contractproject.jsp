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
		<title>合同项目
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="contract.project.list.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				
				<TD align="right">
					<a href="contractproject_add.action"><s:text name="contract.project.page.add" />
					</a>
				</TD>
				 
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<TABLE border="0" width="100%">
			<TR class="listtablebody">
			     <TD>
					<s:text name="contract.project.page.id" />
				</TD>
				<TD>
					<s:text name="contract.project.page.contract.no" />
				</TD>
				<TD>
					<s:text name="contract.project.page.project.no" />
				</TD>
				<TD>
					<s:text name="contract.project.page.project.name" />
				</TD>
				<TD>
					<s:text name="contract.project.page.assign.date" />
				</TD>
				<TD>
					<s:text name="contract.project.page.open.date" />
				</TD>
				<TD>
					<s:text name="contract.project.page.plan.start.date" />
				</TD>
				<TD>
					<s:text name="contract.project.page.plan.end.date" />
				</TD>
				<TD>
					<s:text name="contract.project.page.real.start.date" />
				</TD>
				<TD>
				    <s:text name="contract.project.page.real.end.date" />
				</TD>
				<TD>
				    <s:text name="contract.project.page.our.intf.person" />
				</TD>
				<TD>
				    <s:text name="contract.project.page.other.intf.person" />
				</TD>
				<TD>
				    <s:text name="contract.project.page.contract.count.person" />
				</TD>
				<TD></TD>
			</TR>

			<s:iterator value="beanList">
				<tr>
				    <td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="contractNo" />
					</td>
					<td>
						<s:property value="projectNo" />
					</td>
					<td>
						<s:property value="projectName" />
					</td>
					<td>
					    <s:date name="assignDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="openDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="planStartDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="planEndDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="realStartDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="realEndDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:property value="ourIntfPerson" />
					</td>
					<td>
						<s:property value="otherIntfPerson" />
					</td>
					<td>
						<s:property value="contractCountPerson" />
					</td>
					<td>
					
						<a href="contractproject_edit.action?id=<s:property value='id'/>"><s:text
								name='button.edit' />
						</a>
						<a href="contractproject_delete.action?id=<s:property value='id'/>"><s:text
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
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
			</TR>
			</s:iterator>
			<%-- 分页 --%>
		    <site:page name="page" action="contractproject_list.action" />
		</TABLE>
		
	</body>
</html>

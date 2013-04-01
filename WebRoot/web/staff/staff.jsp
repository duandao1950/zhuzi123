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
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="staff.list.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				
				<TD align="right">
					<a href="staff_add.action"><s:text name="staff.page.add" />
					</a>
				</TD>
				 
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<TABLE border="0" width="100%" style="text-align:center;">
		    <TR class="listtablebody">
				<TD>
					<s:text name="staff.page.staff.id"/>
				</TD>
				<TD>
					<s:text name="staff.page.staff.name"/>
				</TD>
				<TD>
					<s:text name="staff.page.skill"/>
				</TD>
				<TD>
					<s:text name="staff.page.status"/>
				</TD>
				<TD>
					<s:text name="staff.page.tel1"/>
				</TD>
				<TD>
					<s:text name="staff.page.tel2"/>
				</TD>
				<TD>
					<s:text name="staff.page.email1"/>
				</TD>
				<TD>
					<s:text name="staff.page.email2"/>
				</TD>
				<TD>
					<s:text name="staff.page.enter.com.date"/>
				</TD>
				<TD>
					<s:text name="staff.page.exit.com.date"/>
				</TD>
				<TD>
					<s:text name="staff.page.group.name"/>
				</TD>
				<TD>
					<s:text name="staff.page.work.years"/>
				</TD>
				<TD>
					<s:text name="staff.page.remark"/>
				</TD>
				<TD></TD>
		    </TR>

			<s:iterator value="beanList">
				<tr>
				    <td>
						<s:property value="staffId" />
					</td>
					<td>
						<s:property value="staffName" />
					</td>
					<td>
						<s:property value="skill" />
					</td>
					<td>
						<emg:textTag inf_name="STAFF_STATUS" id="${statusId}"></emg:textTag>
					</td>
					<td>
						<s:property value="tel1" />
					</td>
					<td>
					    <s:property value="tel2" />
					</td>
					<td>
						<s:property value="email1" />
					</td>
					<td>
						<s:property value="email2" />
					</td>
					
					
					<td>
					    <s:property value="enterComDate" />
					</td>
					<td>
						<s:property value="exitComDate" />
					</td>
					<td>
						<s:property value="groupName" />
					</td>
					<td>
						<s:property value="workYears" />
					</td>
					<td>
						<s:property value="remark" />
					</td>
					<td>
					
						<a href="staff_edit.action?staffId=<s:property value='staffId'/>"><s:text
								name='button.edit' />
						</a>
						<a href="staff_delete.action?staffId=<s:property value='staffId'/>"><s:text
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
			</TR>
			</s:iterator>
			<%-- 分页 --%>
		    <site:page name="page" action="asset_list.action" />
		</TABLE>
		
	</body>
</html>

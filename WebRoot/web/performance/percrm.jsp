<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%@ taglib uri="/WEB-INF/emg-UI.tld" prefix="emg"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>CRM
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
					<s:text name="performance.crm.list.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				
				<TD align="right">
					<a href="perCRM_add.action"><s:text name="performance.crm.add.page.position" />
					</a>
				</TD>
				 
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<TABLE border="0" width="100%" style="text-align:center;">
		
			<TR class="listtablebody">
			    <TD>
			    	<s:text name="performance.crm.page.staff.id"/>
			    </TD>
				<TD>
					<s:text name="performance.crm.page.staff.name"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.requirment.analyze"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.coding"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.problem.counts"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.check.code"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.code.confirm"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.work.attitude"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.training"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.team.contribute"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.daily.work"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.in.month"/>
				</TD>
				<TD>
					<s:text name="performance.crm.page.other"/>
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
						<s:property value="requirmentAnalyze" />
					</td>
					<td>
						<s:property value="coding" />
					</td>
					<td>
						<s:property value="problemCounts" />
					</td>
					<td>
						<s:property value="checkCode" />
					</td>
					<td>
						<s:property value="codeConfirm" />
					</td>
					<td>
						<s:property value="workAttitude" />
					</td>
					<td>
						<s:property value="training" />
					</td>
					<td>
						<s:property value="teamContribute" />
					</td>
					<td>
						<s:property value="dailyWork" />
					</td>
					<td>
						<s:property value="inMonth" />
					</td>
					<td>
						<s:property value="other" />
					</td>
					
					<td>
					
						<a href="perCRM_edit.action?staffId=<s:property value='staffId'/>&inMonth=<s:property value='inMonth'/>">
						<s:text name='button.edit' />
						</a>
						<a href="perCRM_delete.action?staffId=<s:property value='staffId'/>&inMonth=<s:property value='inMonth'/>">
						<s:text name='button.delete' />
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
		    <site:page name="page" action="asset_list.action" />
		</TABLE>
		
	</body>
</html>

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
		<base href="<%=basePath%>">

		<title><s:text name="operators.page.title" />
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
			function Add(){
       			window.location.href = "operator_manage_add.action";
   			}
   			
   			function ManageRelation(id,operId){
       			window.location.href = "operator_roles_relation_edit.action?id="+id+"&operId="+operId;
   			}
   			
   			function Edit(id){
       			window.location.href = "operator_manage_edit.action?id="+id;
   			}
   			
   			function Delete(id){
       			window.location.href = "operator_manage_delete.action?id="+id;
   			}
		</script>
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="operators.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<TD align="right">
					<input icon='icon-add' type='button' value='<s:text name="operators.page.add" />' onclick="Add();"/>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<TR class="tableheader">
				<TD>
					<s:text name="operators.page.operId" />
				</TD>
				<TD>
					<s:text name="operators.page.operName" />
				</TD>
				<TD>
					<s:text name="operators.page.isValid" />
				</TD>
				<TD>
					<s:text name="operators.page.registerTime" />
				</TD>
				<TD>
					<s:text name="operators.page.loginTime" />
				</TD>
				<TD>
					<s:text name="operators.page.belongTeam" />
				</TD>
				<TD>
					<s:text name="operators.page.mobilePhone" />
				</TD>
				<TD>
					<s:text name="operators.page.firstEmail" />
				</TD>
				<TD>
					<s:text name="operators.page.secondEmail" />
				</TD>
				<TD>
					<s:text name="operators.page.notesId" />
				</TD>
				<TD>
					<s:text name="button.operation" />
				</TD>
			</TR>

			<s:iterator value="beanList" status="operatorsNo">
				<tr>
					<td>
						<s:property value="operId" />
					</td>
					<td>
						<s:property value="operName" />
					</td>
					<td>
						<s:if test="isValid=='10001'">
					    	<s:text name="pager.isValidYes"/>
					    </s:if>
					    <s:else>
					    	<s:text name="pager.isValidNo"/>
					    </s:else>
					</td>
					<td>
						<s:property value="registerTime" />
					</td>
					<td>
						<s:property value="loginTime" />
					</td>
					<td>
						<site:baseSelect id="belongTeam" property="belongTeam" tableName="DIC_BELONG_TEAM" defaultValue='${belongTeam}' disabled="true"/>
					</td>
					<td>
						<s:property value="mobilePhone" />
					</td>
					<td>
						<s:property value="firstEmail" />
					</td>
					<td>
						<s:property value="secondEmail" />
					</td>
					<td>
						<s:property value="notesId" />
					</td>
					<td>
						&nbsp;
						<img src="images/icons/pkg.gif" style="cursor: hand;" alt="Relation" onclick="ManageRelation('<s:property value='operCode'/>','<s:property value='operId'/>');">
						&nbsp;
						<img src="images/icons/edit.gif" style="cursor: hand;" alt="Edit" onclick="Edit('<s:property value='operCode'/>');">
						&nbsp;
						<img src="images/icons/delete.gif" style="cursor: hand;" alt="Delete" onclick="Delete('<s:property value='operCode'/>');">
						&nbsp;
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
		    <site:page name="page" export="false" action="operator_manage_list.action" />
		</TABLE>
		
	</body>
</html>

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

		<title><s:text name="roles.page.title" />
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
			function Add(){
       			window.location.href = "roles_add.action";
   			}
   			
   			function ManageRelation(id){
       			window.location.href = "roles_privilege_relation_edit.action?id="+id;
   			}
   			
   			function Edit(id){
       			window.location.href = "roles_edit.action?id="+id;
   			}
   			
   			function Delete(id){
       			window.location.href = "roles_delete.action?id="+id;
   			}
		</script>
	</head>
	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="roles.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<TD align="right">
					<input icon='icon-add' type='button' value='<s:text name="roles.page.add" />' onclick="Add();"/>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<TR class="tableheader">
				<TD>
					<s:text name="roles.page.roleId" />
				</TD>
				<TD>
					<s:text name="roles.page.roleName" />
				</TD>
				<TD>
					<s:text name="roles.page.description" />
				</TD>
				<TD>
					<s:text name="roles.page.createTime" />
				</TD>
				<TD>
					<s:text name="roles.page.isValid" />
				</TD>
				<TD>
					<s:text name="roles.page.orderNumber" />
				</TD>
				<TD>
					<s:text name="button.operation" />
				</TD>
			</TR>

			<s:iterator value="beanList" status="rolesNo">
				<tr>
					<td>
						<s:property value="roleId" />
					</td>
					<td>
						<s:property value="roleName" />
					</td>
					<td>
						<s:property value="description" />
					</td>
					<td>
						<s:property value="createTime" />
					</td>
					<td>
					    <s:if test="isValid='1'">
					    	<s:text name="pager.isValidYes"/>
					    </s:if>
					    <s:else>
					    	<s:text name="pager.isValidNo"/>
					    </s:else>
					</td>
					<td>
						<s:property value="orderNumber" />
					</td>
					<td>
						<s:if test="roleName=='Admin'">&nbsp;</s:if>
						<s:else>
						&nbsp;
						<img src="images/icons/pkg.gif" style="cursor: hand;" alt="Relation" onclick="ManageRelation('<s:property value='roleId'/>');">
						&nbsp;
						<img src="images/icons/edit.gif" style="cursor: hand;" alt="Edit" onclick="Edit('<s:property value='roleId'/>');">
						&nbsp;
						<img src="images/icons/delete.gif" style="cursor: hand;" alt="Delete" onclick="Delete('<s:property value='roleId'/>');">
						&nbsp;
						</s:else>
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
		    <site:page name="page" action="roles_list.action" />
		</TABLE>
	</body>
</html>

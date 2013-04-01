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

		<title><s:text name="privilege.page.title" />
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
			function Add(){
       			window.location.href = "privilege_add.action";
   			}
   			
   			function ManageRelation(id){
       			window.location.href = "roles_privilege_relation_edit.action?id="+id;
   			}
   			
   			function Edit(id){
       			window.location.href = "privilege_edit.action?id="+id;
   			}
   			
   			function Delete(id){
       			window.location.href = "privilege_delete.action?id="+id;
   			}
		</script>
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="privilege.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<!--  
				<TD align="right">
					<input icon='icon-add' type='button' value='<s:text name="privilege.page.add" />' onclick="Add();"/>
				</TD>-->
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<TR class="listtablebody">
				<TD>
					<s:text name="privilege.page.id" />
				</TD>
				<TD>
					<s:text name="privilege.page.name" />
				</TD>
				<TD>
					<s:text name="privilege.page.url" />
				</TD>
				<TD>
					<s:text name="privilege.page.porder" />
				</TD>
				<TD>
					<s:text name="privilege.page.parentPorder" />
				</TD>
				<TD>
					<s:text name="privilege.page.privilegeLevel" />
				</TD>
				<TD>
					<s:text name="privilege.page.orderNumber" />
				</TD>
				<TD>
					<s:text name="privilege.page.description" />
				</TD>
				<!--  
				<TD>
					<s:text name="button.operation" />
				</TD>
				-->
			</TR>

			<s:iterator value="beanList">
				<tr>
					<td>
						<s:property value="privilegeId" />
					</td>
					<td>
						<s:property value="privilegeName" />
					</td>
					<td>
						<s:property value="url" />
					</td>
					<td>
						<s:property value="porder" />
					</td>
					<td>
						<s:property value="parentPorder" />
					</td>
					<td>
						<s:property value="privilegeLevel" />
					</td>
					<td>
						<s:property value="orderNumber" />
					</td>
					<td>
						<s:property value="description" />
					</td>
					<!--  
					<td>
						&nbsp;
						<img src="images/icons/edit.gif" style="cursor: hand;" alt="Edit" onclick="Edit('<s:property value='privilegeId'/>');">
						&nbsp;
						<img src="images/icons/delete.gif" style="cursor: hand;" alt="Delete" onclick="Delete('<s:property value='privilegeId'/>');">
						&nbsp;
					</td>
					-->
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
		    <site:page name="page" action="privilege_list.action" />
		</TABLE>
		
	</body>
</html>

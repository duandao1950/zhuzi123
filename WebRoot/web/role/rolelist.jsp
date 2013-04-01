<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
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

		<title><s:text name="role.list.title"/>
		</title>
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
					<s:text name="role.list.position"/>
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<TD align="right">
					<a href="addrole.action"><s:text name="role.list.add"></s:text>
					</a>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<TR class="tableheader">
				<TD>
					<s:text name="role.property.id"></s:text>
				</TD>
				<TD>
					<s:text name="role.property.name"></s:text>
				</TD>
				<TD>
					<s:text name="role.property.description"></s:text>
				</TD>
				<TD>
					<s:text name="role.property.createtime"></s:text>
				</TD>
				<TD>
					<s:text name="role.property.createoper"></s:text>
				</TD>				

				<TD>
					<s:text name="button.operation" />
				</TD>
			</TR>

			<s:iterator value="beanList" status="addressNo">
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
						<s:date name="createTime" format="yyyy-MM-dd"/>					
					</td>
					<td>
						<s:property value="createOperId"/>
					</td>					

					<td>
						<a href="role_edit.action?roleId=<s:property value='roleId'/>">
						<s:text	name='button.edit' />
						</a>
						<a href="role_delete.action?roleId=<s:property value='roleId'/>">
						<s:text	name='button.delete' />
						</a>
					</td>
				</tr>
			</s:iterator>
			<%-- 分页 --%>
		    <site:page name="page" action="rolelist.action" />
		</TABLE>
		
	</body>
</html>

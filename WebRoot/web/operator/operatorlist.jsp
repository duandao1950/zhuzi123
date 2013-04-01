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

		<title><s:text name="operator.list.title"></s:text>
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<form action="oper_delete">
			<TABLE width="100%" class="position">
				<TR>
					<TD>
						<s:text name="operator.list.location"></s:text>
					</TD>
					<TD>
						<s:actionerror />
					</TD>
					<TD>
						<b><s:actionmessage cssStyle="color:red" /> </b>
					</TD>
					<TD align="right">
						<a href="addoper.action"><s:text name="operator.list.add"></s:text>
						</a>
					</TD>
					<TD width="20"></TD>
				</TR>
			</TABLE>

			<TABLE border="0" width="100%">
				<TR class="tableheader">
					<TD>
						<s:text name="operator.property.operid"></s:text>
					</TD>
					<TD>
						<s:text name="operator.property.opername"></s:text>
					</TD>
					<TD>
						<s:text name="operator.property.password"></s:text>
					</TD>
					<TD>
						<s:text name="operator.property.valid"></s:text>
					</TD>
					<TD>
						<s:text name="operator.property.role"></s:text>
					</TD>

					<TD>
						<s:text name="button.operation" />
					</TD>
				</TR>

				<s:iterator value="beanList" status="addressNo">
					<tr>
						<td>
							<s:property value="operId" />
						</td>
						<td>
							<s:property value="operName" />
						</td>
						<td>
							<s:property value="password" />
						</td>
						<td>
							<s:if test="valid == 1">
								<s:text name="operator.valid" />
							</s:if>
							<s:else>
								<s:text name="operator.invalid" />
							</s:else>
						</td>
						<td>
							${role.roleName }
						</td>

						<td>
							<a href="oper_edit.action?operId=<s:property value='operId'/>">
								<s:text name='button.edit' /> </a>
							<s:if test="operId == 0">
							</s:if>
							<s:else>
								<a href="oper_delete.action?operId=<s:property value='operId'/>">
									<FONT color="red"><s:text name='button.delete' /> </FONT> </a>
							</s:else>
						</td>
					</tr>
				</s:iterator>
				<%-- 分页 --%>
				<site:page name="page" action="operlist.action" />
			</TABLE>
		</form>
	</body>
</html>

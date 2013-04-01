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

		<title>
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
					<s:text name="address.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				<TD align="right">
					<a href="address_add.action"><s:text name="address.page.add" />
					</a>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		
		<TABLE border="0" width="100%">
			<TR class="tableheader">
				<TD>
					<s:text name="address.page.name" />
				</TD>
				<TD>
					<s:text name="address.page.sex" />
				</TD>
				<TD>
					<s:text name="address.page.mobile" />
				</TD>
				<TD>
					<s:text name="address.page.email" />
				</TD>
				<TD>
					<s:text name="address.page.qq" />
				</TD>
				<TD>
					<s:text name="address.page.company" />
				</TD>
				<TD>
					<s:text name="address.page.address" />
				</TD>
				<TD>
					<s:text name="address.page.postcode" />
				</TD>
				<TD>
					<s:text name="address.page.updateDate" />
				</TD>
				<TD>
					file Path
				</TD>
				<TD>
					<s:text name="button.operation" />
				</TD>
			</TR>

			<s:iterator value="beanList" status="addressNo">
				<tr>
					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="sex" />
					</td>
					<td>
						<s:property value="mobile" />
					</td>
					<td>
						<s:property value="email" />
					</td>
					<td>
						<s:property value="qq" />
					</td>
					<td>
						<s:property value="company" />
					</td>
					<td>
						<s:property value="address" />
					</td>
					<td>
						<s:property value="postcode" />
					</td>
					<td>
						<s:property value="updateDate" />
					</td>
					<td>
						<s:if test="filepath==null"> &nbsp;</s:if>
						<s:else>
						<!-- 下载文件链接内容为定义的下载Action -->
						<!-- 下载文件名作为链接参数fileName值，用OGNL表达式表达 -->
						<s:property value="filepath" />
						<a href="<s:url value='address_dowload.action'>                  
                        <s:param name='fileName' value='filepath'/></s:url>">下载</a>
						</s:else>
					</td>
					<td>
						<a href="address_edit.action?id=<s:property value='id'/>"><s:text
								name='button.edit' />
						</a>
						<a href="address_delete.action?id=<s:property value='id'/>"><s:text
								name='button.delete' />
						</a>
					</td>
				</tr>
			</s:iterator>
			<%-- 分页 --%>
		    <site:page name="page" action="address_list.action" />
		</TABLE>
		
	</body>
</html>

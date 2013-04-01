<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>ListAllCustomers</title>
</head>
<body>
	<table width="50%" border="1">
		<caption>列取所有客户资料</caption>
		<tr>
			<th>姓名</th>
			<th>销售量</th>
		</tr>
		<s:iterator value="customers">
			<tr>
				<td><s:property value="name"/></td>
				<td><s:property value="sales"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

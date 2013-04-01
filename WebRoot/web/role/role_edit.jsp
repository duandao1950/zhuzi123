<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/upload.tld" prefix="site"%>
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
		<title><s:text name="address_edit.page.title" />
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript">
function moveSelectMenu(from,to)
{
	//var selectable = document.getElementById("lselect");	
	//var selected = document.getElementById("rselect");
	var selectable = from;
	var selected = to;
	for(var i=0;i<selectable.length;i++)
	{
		var isExist = false;
		var onemenu = selectable.options[i];
		if(onemenu.selected)
		{
			if(selected.length>0)
			{
				for(var j=0;j<selected.length;j++)
				{
					if(onemenu.value == selected.options[j].value)
					{
						isExist = true;
					}
				}
			}
			if(!isExist)
			{
				newopt = document.createElement("option");
				newopt.text = selectable.options[i].text;
				newopt.value = selectable.options[i].value;			
				selected.add(newopt,i);
			}
		}
	}
	//remove selected item	
	for(var k = selectable.length - 1;k >= 0;k--)
	{
		if(selectable.options[k].selected)
		{
			selectable.options[k] = null;
		}
	}
}
function edit()
{
	var selected = document.getElementById("rselect");
	var menuIds = "";
	for(var i = 0; i < selected.length; i++)
	{	
		menuIds = menuIds + selected.options[i].value+",";		
	}
	document.forms[0].action = "role_update.action?menuIds="+menuIds;
	document.forms[0].submit();
}
</script>
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="role.edit.position" />
				</TD>
				<TD align="right">
					<a href="role_back.action"><s:text name="role.back" />
					</a>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<form action="role_update.action" method="post"
			enctype="multipart/form-data">
			<b><s:actionerror /></b>
			<TABLE  align="center" width="100%">
				<tr>
					<td>
						<table width="78%">
							<TR>
								<TD class="tablebody">
									<s:text name="role.property.id" />
								</TD>
								<TD>
									<input type="text" name="roleId" value="${roleId}" maxlength="8"
										readonly="true" />
								</TD>
							</tr>
							<tr>
								<TD class="tablebody">
									<s:text name="role.property.name" />
								</TD>
								<TD>
									<input type="text" name="roleName" value="${roleName}" maxlength="128"/>
								</TD>
								
							</TR>
							<tr>
								<td class="tablebody">
									<s:text name="role.property.createtime" />
								</td>
								<td>
									<input type="text" name="createTime" value="${createTime }"
								readonly="true">
								</td>
							</tr>
							<tr>
								<td class="tablebody">
									<s:text name="role.property.createoper" />
								</td>
								<td>
									<input type="text" name="createOperId" value="${createOperId }"
								readonly="true">
								</td>
							</tr>
							<tr>
								<TD class="tablebody">
									<s:text name="role.property.description" />
								</TD>
								<TD>
									<textarea name="description" rows="2" cols="30">${description}</textarea>
								</TD>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>
								<td bgcolor="#E5EEF7" align="left" >
										<s:text name="role.privilege.selectable" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<s:text name="role.privilege.selected" />
								</td>
							</tr>
							<tr>
								<td>
									<table width="32%">
										<tr>
											<td height="24" align="left" nowrap scope="row" valign="top">
												<select style="width: 160px" name="selectable" id="lselect"
													multiple="true" size="10">
													<s:iterator value="allMenus" id="menu">
															<option value="${menu.privilegeId }">
															${menu.privilegeName }
														</option>
													</s:iterator>
												</select>
											</td>
											<td height="29" align="center" valign="middle" nowrap>
												<table>
													<tr>
														<td>
															<input type="button" value=" >> "
																onclick="moveSelectMenu(document.forms[0].selectable,document.forms[0].selected);" />
														</td>
													</tr>
													<tr>
													</tr>
													<tr>
														<td>
															<input type="button" value=" << "
																onclick="moveSelectMenu(document.forms[0].selected,document.forms[0].selectable);" />
														</td>
													</tr>

												</table>
											</td>
											<td height="24" align="right" nowrap scope="row" valign="top">
												<select style="width: 160px" name="selected" id="rselect"
													multiple="true" size="10">
													<s:iterator value="#request.selectedM" id="ownmenu"
														status="menu_status">
														<option value="${ownmenu.privilegeId}">
															${ownmenu.privilegeName }
														</option>
													</s:iterator>
												</select>
											</td>
									</TR>
							</table>
						</td>
					</tr>
					</table>
				</TD>
			</tr>				
		</TABLE>
			<br>
			<table width="78%">
				<tr align="center">
					<td>
						<input type="button" value="<s:text name='button.submit'/>"
							onclick="edit();" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

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
		
			<script type="text/javascript">
		
		function editAsset(id)
		{
			document.forms[0].action="asset_edit.action?method=edit&id="+id;
			document.forms[0].submit();
		}
		
		function deleteAsset(id)
		{
			if(!confirm("<s:text name="message.delete.confirm"/>"))
		  {
		      return;
		  }
		  document.forms[0].action="asset_delete.action?id="+id;
		  document.forms[0].submit();
		}

        </script>
	</head>

	<body>
	<form action="asset_list.action?method=list" method="POST" enctype="multipart/form-data"/>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="asset.list.page.position" />
				</TD>
				<TD>
					<s:actionerror/>
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red"/></b>
				</TD>
				
				<TD align="right">
					<a href="asset_add.action"><s:text name="asset.page.add" />
					</a>
				</TD>
				 
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<TABLE border="0" width="100%" style="text-align:center;">
			<TR class="listtablebody">
			     <TD width="5%">
					<s:text name="asset.page.id" />
				</TD>
				<TD width="8%">
					<s:text name="asset.page.staff.id" />
				</TD>
				<TD width="15%">
					<s:text name="asset.page.device.no" />
				</TD>
				<TD width="15%">
					<s:text name="asset.page.com.display.no" />
				</TD>
				<TD width="15%">
					<s:text name="asset.page.com.host.no" />
				</TD>
				<TD width="5%">
					<s:text name="asset.page.status" />
				</TD>
				<TD width="8%">
					<s:text name="asset.page.ip.address" />
				</TD>
				<TD width="10%">
					<s:text name="asset.page.device.address" />
				</TD>
				<TD width="14%">
					<s:text name="asset.page.remark" />
				</TD>
				<TD width="5%">
				</TD>
			</TR>

			<s:iterator value="beanList">
				<tr>
				    <td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="staffId" />
					</td>
					<td>
						<s:property value="deviceNo" />
					</td>
					<td>
						<s:property value="comDisplayNo" />
					</td>
					<td>
						<s:property value="comHostNo" />
					</td>
					<td>
					<emg:textTag inf_name="ASSET_STATUS" id="${status}"></emg:textTag>
					</td>
					<td>
						<s:property value="ipAddress" />
					</td>
					<td>
						<s:property value="deviceAddress" />
					</td>
					<td>
						<s:property value="remark" />
					</td>
					<td>
					    <img src="./images/IcoBtn_Detail.gif" onclick="javascript:editAsset(${id })"></img>
						<img src="./images/IcoBtn_Delete.gif" onclick="javascript:deleteAsset(${id })"></img>
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
		
	</form>
	</body>
</html>

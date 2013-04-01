<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%@ taglib uri="/WEB-INF/emg-UI.tld" prefix="emg"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String defstaff = (String) request.getAttribute("defStaff");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>

		<title>
			<!--<s:text name="address.page.title" /> --></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/styles.css">

		<script type="text/javascript">
		function returnValue()
		{
            window.close();
		}
		
		function change(defValue)
		{
		    window.parent.returnValue = defValue.value;
		}
		</script>
	</head>

	<body>
		<form action="staff_show.action?method=toShow" method="POST"
			enctype="multipart/form-data" />
			<input type=hidden name="defStaffId" />

			<table width="100%">
				<tr>
					<td>
						<TABLE border="0" width="100%">
							<TR class="tablebody">
								<TD style="height: 30px; width: 20%;">
									<s:text name="staff.page.staff.id" />
								</TD>
								<TD>
									<s:text name="staff.page.staff.name" />
								</TD>
								<TD>
									<s:text name="staff.page.skill" />
								</TD>
								<TD>
									<s:text name="staff.page.status" />
								</TD>
								<TD>
									<s:text name="staff.page.group.name" />
								</TD>
							</TR>
							<s:iterator value="beanList" id="staff">
								<TR>
									<TD>
										<table>
											<tr>
												<s:radio list="#staff.staffId" name="staffRadio" value=""
													onclick="change(this)" />
											</tr>
										</table>
									</TD>
									<TD>
										<s:property value="staffName" />
									</TD>
									<TD>
										<s:property value="skill" />
									</TD>
									<TD>
										<emg:textTag inf_name="STAFF_STATUS" id="${statusId}"></emg:textTag>
									</TD>
									<TD>
										<s:property value="groupName" />
									</TD>
								</TR>
							</s:iterator>
						</TABLE>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="<s:text name='button.submit'/>"
							onclick="returnValue();" />
					</td>
				</tr>
			</table>

		</form>

	</body>
</html>


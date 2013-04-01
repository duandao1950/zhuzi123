<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
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

		<title><s:text name="role.list.title" /></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript">
			function check()
			{
				var staffid = document.forms[0].staffId.value;
				var month = document.forms[0].month.value;
				if(null == staffid || "" == staffid)
				{
					alert("员工号不能为空.");
					return false;
				}
				if(null == month || "" == month)
				{
					alert("所属月份不能为看.");
					return false;
				}
				return true;
			}
		</script>
	</head>

	<body>
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="performance.list.position" />
				</TD>
				<TD>
					<s:actionerror />
				</TD>
				<TD>
					<b><s:actionmessage cssStyle="color:red" /> </b>
				</TD>
				<TD align="right">
					<a href="performanceOpt_add.action"><s:text
							name="performance.list.add"></s:text> </a>
				</TD>
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<form action="performanceOpt_update.action" method="post"
			onsubmit="return check();" enctype="multipart/form-data">
			<TABLE border="0" width="100%">
				<TR>
					<TD class="tablebody">
						<s:text name="staff.page.staff.id"></s:text>
					</TD>
					<td>
						<input type="text" name="staffId" value="${staffId }"
							maxlength="20">
						<font color="#C10202">*</font>
					</td>
					<TD class="tablebody">
						<s:text name="staff.page.staff.name"></s:text>
					</TD>
					<td>
						<input type="text" name="staffName" value="${staffName }"
							maxlength="64"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.workscore"></s:text>
					</TD>
					<td>
						<input type="text" name="workAttendence"
							value="${workAttendence }" maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.PBCscore"></s:text>
					</TD>
					<td>
						<input type="text" name="layPBC" value="${layPBC }" maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.logwrite"></s:text>
					</TD>
					<td>
						<input type="text" name="writeLog" value="${writeLog }"
							maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.meetingscore"></s:text>
					</TD>
					<td>
						<input type="text" name="regularMeeting"
							value="${regularMeeting }" maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.optsite"></s:text>
					</TD>
					<td>
						<input type="text" name="site" value="${site }" maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.standbysite"></s:text>
					</TD>
					<td>
						<input type="text" name="siteBak" value="${siteBak }"
							maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.recordissue"></s:text>
					</TD>
					<td>
						<input type="text" name="problemCounts" value="${problemCounts }"
							maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.resolveissue"></s:text>
					</TD>
					<td>
						<input type="text" name="problemSolve" value="${problemSolve }"
							maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.devscore"></s:text>
					</TD>
					<td>
						<input type="text" name="coding" value="${coding }" maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.praiseletter"></s:text>
					</TD>
					<td>
						<input type="text" name="praiseLetter" value="${praiseLetter }"
							maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.custcomplain"></s:text>
					</TD>
					<td>
						<input type="text" name="custComplain" value="${custComplain }"
							maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.sitecomplain"></s:text>
					</TD>
					<td>
						<input type="text" name="siteComplain" value="${siteComplain }"
							maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.custappraise"></s:text>
					</TD>
					<td>
						<input type="text" name="custAppraise" value="${custAppraise }"
							maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.trainscore"></s:text>
					</TD>
					<td>
						<input type="text" name="training" value="${training }"
							maxlength="4"">
					</td>					
				</tr>
				<tr>
					<TD class="tablebody">
						<s:text name="performance.list.other"></s:text>
					</TD>
					<td>
						<input type="text" name="other" value="${other }" maxlength="4"">
					</td>
					<TD class="tablebody">
						<s:text name="performance.list.belongmon"></s:text>
					</TD>
					<td>
						<input type="text" name="month" value="${month }" maxlength="6"">
						<font color="#C10202">*</font>Tip:YYYYMM
					</td>					
				</tr>

				<TR>
					<TD></TD>
					<TD>
						<table border="0" width="100%">
							<tr>
								<td class="buttontable">
									<input type="submit" value="<s:text name='button.submit'/>">
								</td>
								<td width="59%"></td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</html>

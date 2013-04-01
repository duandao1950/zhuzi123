<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="operators_add.page.position"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function Back(){
       	window.location.href = "operator_manage_back.action";
   	}
   	
   	function doSubmit(){
   	    var operId = document.getElementsByName("operId").value;
   	    if (operId == null){
   	    	alert("编号不能为空!");
   	    	return false;
   	    }
   	    
   	    var operName = document.getElementsByName("operName").value;
   	    if (operName == null){
   	    	alert("名称不能为空!");
   	    	return false;
   	    }
   	    var password = document.getElementsByName("password").value;
   	    if (password == null){
   	    	alert("密码不能为空!");
   	    	return false;
   	    }
   	    var prePassword = document.getElementsByName("prePassword").value;
   	    if (prePassword == null){
   	    	alert("确认不能为空!");
   	    	return false;
   	    }
   	    
   	    if (prePassword != password){
   	    	alert("两次输入的密码不一致!");
   	    	return false;
   	    }
   	    
   	    var mobilePhone = document.getElementsByName("mobilePhone").value;
   	    if (operId == null){
   	    	alert("编号不能为空!");
   	    	return false;
   	    }

       	document.forms[0].action="operator_manage_insert.action";
        document.forms[0].submit();
   	}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="operators_add.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form method="POST" enctype="multipart/form-data"/>
<b><s:actionerror/></b>
<table width="100%">
	<tr>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorid"/></td>
		<td><input type="text" name="operId" value="${operators.operId}"></td>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorname"/></td>
		<td><input type="text" name="operName" value="${operators.operName}"></td>
		<td class="tablebody">&nbsp;&nbsp;&nbsp;Belong Team:</td>
		<td>
			<site:baseSelect property="belongTeam" tableName="DIC_BELONG_TEAM" defaultValue="${operators.belongTeam}"/>
		</td>
	</tr>
	<tr>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.password1"/></td>
		<td><input type="password" name="password" value="${operators.password}"></td>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.password2"/></td>
		<td><input type="password" name="prePassword"></td>
		
		<td class="tablebody"><span style="color: red">*</span>&nbsp;Mobile Phone:</td>
		<td>
		<input type="text" name="mobilePhone" value="${operators.mobilePhone}">
		</td>
	</tr>
	<tr>
		<td class="tablebody">&nbsp;First email:</td>
		<td>
		<input type="text" name="firstEmail" value="${operators.firstEmail}">
		</td>
		<td class="tablebody">&nbsp;Second email:</td>
		<td>
		<input type="text" name="secondEmail" value="${operators.secondEmail}">
		</td>
		<td class="tablebody">&nbsp;Notes ID:</td>
		<td>
		<input type="text" name="notesId" value="${operators.notesId}">
		</td>
	</tr>
	<tr>
		<td class="tablebody"><s:text name="operators.page.isValid"/></td>
		<td>
			<site:baseSelect property="isValid" tableName="DIC_IS_VALID" defaultValue="${operators.isValid}"/>
		</td>
		<TD colspan="5" align="right"><input icon='icon-add' type="button"
			value="<s:text name='button.submit'/>" onclick="doSubmit()"></TD>
	</tr>
</table>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<html:html locale = "true"/> 
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="operators_edit.page.title"/></title>

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
   	    var operId = document.getElementById("operId").value;
   	    if (operId == null || "" == operId){
   	    	alert("编号不能为空!");
   	    	return false;
   	    }
   	    
   	    var operName = document.getElementById("operName").value;
   	    if (operName == null || ""==operName){
   	    	alert("名称不能为空!");
   	    	return false;
   	    }
   	    var password = document.getElementById("password").value;
   	    if (password == null || ""==password){
   	    	alert("密码不能为空!");
   	    	return false;
   	    }
   	    var prePassword = document.getElementById("prePassword").value;
   	    if (prePassword == null || ""==prePassword){
   	    	alert("确认不能为空!");
   	    	return false;
   	    }
   	    
   	    if (prePassword != password){
   	    	alert("两次输入的密码不一致!");
   	    	return false;
   	    }
   	    
   	    var mobilePhone = document.getElementById("mobilePhone").value;
   	    if (mobilePhone == null || ""==mobilePhone){
   	    	alert("联系电话不能为空!");
   	    	return false;
   	    }

       	document.forms[0].action="operator_manage_update.action";
        document.forms[0].submit();
   	}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="operators_edit.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<table width="100%">
	<tr>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorid"/></td>
		<td><input type="text" id="operId" name="operId" value="${operators.operId}"></td>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.operatorname"/></td>
		<td><input type="text" id="operName" name="operName" value="${operators.operName}"></td>
		<td class="tablebody">&nbsp;&nbsp;&nbsp;Belong Team:</td>
		<td>
			<site:baseSelect id="belongTeam" property="belongTeam" tableName="DIC_BELONG_TEAM" defaultValue="${operators.belongTeam}"/>
		</td>
	</tr>
	<tr>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.password1"/></td>
		<td><input type="password" id="password" name="password"></td>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;<s:text name="register.page.password2"/></td>
		<td><input type="password" id="prePassword" name="prePassword"></td>
		<td class="tablebody"><span style="color: red">*</span>&nbsp;Mobile Phone:</td>
		<td>
		<input type="text" id="mobilePhone" name="mobilePhone" value="${operators.mobilePhone}">
		</td>
	</tr>
	<tr>
		<td class="tablebody">&nbsp;First email:</td>
		<td>
		<input type="text" id="firstEmail" name="firstEmail" value="${operators.firstEmail}">
		</td>
		<td class="tablebody">&nbsp;Second email:</td>
		<td>
		<input type="text" id="secondEmail" name="secondEmail" value="${operators.secondEmail}">
		</td>
		<td class="tablebody">&nbsp;Notes ID:</td>
		<td>
		<input type="text" id="notesId" name="notesId" value="${operators.notesId}">
		</td>
	</tr>
	<tr>
		<td class="tablebody"><s:text name="operators.page.isValid"/></td>
		<td>
			<site:baseSelect id="isValid" property="isValid" tableName="DIC_IS_VALID" defaultValue="${operators.isValid}"/>
		</td>
		<TD colspan="5" align="right"><input icon='icon-add' type="button"
			value="<s:text name='button.submit'/>" onclick="doSubmit()"></TD>
	</tr>
	<input type="hidden" name="operCode" value="${operators.operCode}">	
</table>
</form>
</body>
</html>

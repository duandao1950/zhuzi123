<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.ArrayList,java.util.List,java.lang.Boolean"%>
<%@ page import="com.hibernate.beans.Privilege"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/upload.tld" prefix="site"%>
<html:html locale = "true"/> 
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

<title><s:text name="roles_role_relation.page.title"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<SCRIPT src="js/jquery.min.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="dwr/interface/baseSpringBo.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>     
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="js/dwr.js"></script>
<script type="text/javascript">
	function Back(){
       	window.location.href = "roles_back.action";
   	}
</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="roles_role_relation.page.position"/></TD>
		<TD align="right">
		<input icon='icon-back' type='button' value='<s:text name="button.back"/>' onclick="Back();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form action="roles_privilege_relation_update.action" method="post" enctype="multipart/form-data">
<b><s:actionerror/></b>
<input type="hidden" name="roleId" value="${roles.roleId}">	
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="roles.page.roleId"/></TD>
		<TD><input type="text" name="roleId" value="${roles.roleId}" maxlength="50" disabled/></TD>
		<TD><s:text name="roles.page.roleName"/></TD>
		<TD><input type="text" name="roleName" value="${roles.roleName}" maxlength="10" disabled/></TD>
		<TD></TD>
	</TR>
	<TR>
		<TD><s:text name="roles.page.isValid"/></TD>
		<TD>
			<select name="isValid" disabled='true'>
			    <s:if test="roles.isValid==1">
			    	<option value='1' selected="selected">Yes</option>
			    	<option value='0'>No</option>
			    </s:if>
				<s:else>
				    <option value='1'>Yes</option>
					<option value='0' selected="selected">No</option>
				</s:else>
			</select>
		</TD>
		<TD></TD>
		<TD></TD>
	</TR>

	<TABLE border="0" width="100%">
		<tr>
		     Please select privilege:<input name="radioList" type="radio" onclick="selectAllCheckBox();">All select<input name="radioList"  type="radio" onclick="cleanAllCheckBox();">Cancel
		</tr>
		<%
			ArrayList<List<Privilege>> privilegeLevelList = (ArrayList<List<Privilege>>)request.getAttribute("privilegeLevelList");
			List rolePrivilegeList = (List)request.getAttribute("rolePrivilegeList");
			for (List<Privilege> priList : privilegeLevelList){
			    String parentPrivilegeId = "";
			    for (Privilege operPrivilege : priList){
		%>
						<tr>
						    <% 
						        String checked = "";
							    for (int i=0;i<rolePrivilegeList.size();i++){
							    	if (operPrivilege.getPrivilegeId().equals(rolePrivilegeList.get(i))){
							    		checked = "checked";
							    	}
							    }
							    if ("0".equals(operPrivilege.getPrivilegeLevel())){
							    parentPrivilegeId = operPrivilege.getPrivilegeId();
							    %>
							    	<td>
									<input type="checkbox" name="parentPrivilegeList" id="<%=operPrivilege.getPrivilegeId() %>" parentId="<%=parentPrivilegeId %>" value="<%=operPrivilege.getPrivilegeId() %>" onclick="checkParentNote(this.checked,this.parentId);" <%=checked %>/>
									<%=operPrivilege.getPrivilegeName()%>
									</td>
							    <%
							    }else{
							    %>
							    	<td>
							    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="privilegeList" id="<%=operPrivilege.getPrivilegeId() %>" parentId="<%=parentPrivilegeId %>" value="<%=operPrivilege.getPrivilegeId() %>" onclick="checkChildrenNote(this.parentId);" <%=checked %>/>
									<%=operPrivilege.getPrivilegeName()%>
									</td>
								<%
							    }
						    %>
						</tr>
					<%
				}
			}
		%>
		<TR>
			<TD colspan="6" align="right"><input type="submit"
				value="<s:text name='button.submit'/>"></TD>
		</TR>
	</TABLE>
</TABLE>
<script type="text/javascript">
	var priList = null;
	var parentPriList = null;
	window.onload = function(){
	    priList = document.getElementsByName("privilegeList");
	    parentPriList = document.getElementsByName("parentPrivilegeList");
	}
	
	function checkParentNote(checked,parentId){
	    for(var i = 0; i < priList.length; i++){
	        if (priList[i].parentId == parentId){
	        	priList[i].checked = checked;
	        }
	    }
	    cleanAllRadio();
	}
	
	function checkChildrenNote(parentId){
	    var checked = false;
	    for(var i = 0; i < priList.length; i++){
	        checked = (checked || priList[i].checked);
	        if(checked){
	            break;
	        }
	        priList[i].checked = checked;
	    }
		
		for(var i=0;i<parentPriList.length;i++){
		    if (parentPriList[i].value == parentId){
				parentPriList[i].checked = checked;
			}
		}
		cleanAllRadio();
	}

	var pList= document.getElementsByName("privilegeList");
	var radioList= document.getElementsByName("radioList");
	var parPriList = document.getElementsByName("parentPrivilegeList");
	function  changeCheckBox(){
	 	if (pList != null){
		 	for (var i=0; i<pList.length; i++){
		 		if (pList[i].checked){
		 		    if (pList[i].value == pList[i].parentId){
		 		    	pList[i].checked = true;
		 		    }
		 			var radioList= document.getElementsByName("radioList");
				 	for (var i=0; i<radioList.length; i++){
				 		radioList[i].checked = false;
				 	}
				 	break;
		 		}
		 	}
	 	}
	}
	
	function checkRadio(){
		var priListSize = 0;
		var parentPriListSize = 0;
		
		for (var i=0;i<priList.length;i++){
			if (priList[i].checked){
				priListSize ++;
			}
		}
		
		for (var i=0;i<parentPriList.length;i++){
			if (parentPriList[i].checked){
				parentPriListSize ++;
			}
		}
		
		if (priList.length == priListSize && parentPriList.length == parentPriListSize){
			selectAllRadio();
		}else{
			cleanAllRadio();
		}
	}
	
	function selectRadio(){
	 	for (var i=0; i<radioList.length; i++){
	 		if(radioList[i].checked){
	 			radioList[i].checked = true;
	 		}else{
	 			radioList[i].checked = false;
	 		}
	 	}
	}
	
	function cleanAllRadio(){
	 	for (var i=0; i<radioList.length; i++){
	 		radioList[i].checked = false;
	 	}
	}
	
	function cleanRadio(){
	 	for (var i=0; i<radioList.length; i++){
	 		if(radioList[i].checked){
	 			radioList[i].checked = false;
	 		}else{
	 			radioList[i].checked = true;
	 		}
	 	}
	}
	
	function selectAllRadio(){
	 	for (var i=0; i<radioList.length; i++){
	 		if(radioList[i].checked){
	 			radioList[i].checked = true;
	 		}else{
	 			radioList[i].checked = false;
	 		}
	 	}
	}
  
	//全选
	function selectAllCheckBox(){
		if (pList != null){
		 	for (var i=0; i<pList.length; i++){
		 		pList[i].checked = true;
		 	}
	 	}
	 	
	 	if (parPriList != null){
	 		for (var i=0; i<parPriList.length; i++){
		 		parPriList[i].checked = true;
		 	}
	 	}
	 	selectAllRadio();
	}

	//取消选择
	function cleanAllCheckBox(){
		if (pList != null){
			for (var j=0; j<pList.length; j++){
		 	    if (pList[j].checked){
		 	    	pList[j].checked = false;
		 	    }
	 		}
		}
		
		if (parPriList != null){
	 		for (var i=0; i<parPriList.length; i++){
		 		parPriList[i].checked = false;
		 	}
	 	}
	 	cleanRadio();
	} 
</script>
</form>
</body>
</html>

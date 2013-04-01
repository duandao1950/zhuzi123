<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link type="text/css" rel="stylesheet" href="css/jquery.alerts.css"/>
<link type="text/css" rel="stylesheet" href="css/bigpage.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT type="text/javascript" src="js/jquery-1.6.1.js" ></SCRIPT>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/common.valid.js"></script>
<script type="text/javascript" src="js/web/address.argument.js"></script>
<script type="text/javascript" src="js/jquery.bigpage.js"></script>
<script type="text/javascript" src="js/web/address.js"></script>
<script>
$(function(){
$("#tableAddress").bigPage({ajaxData:{url:"address_list_ajax.action",params:{},batch:true},pageSize:2,cssWidgets:["appendToTable","bgColor","eventColor"],callback:function(){
  		//alert("1");
 	}});
})
function search(){
	bigPage.trigger("update",{ajaxData:{url:"address_list_ajax.action",curentPageKey:$("#curentPageKey").val(),params:{keyword:"",name:$.trim($("#name").val())},batch:true}});
}	
</script>
</head>
<body>
<TABLE width="100%" class="position">
	<TR>
		<TD>
			<s:text name="address.page.position" />
		</TD>
		<TD>
			<b><s:actionmessage cssStyle="color:red"/></b>
		</TD>
		<TD align="right">
			<input id="name" type="text" value=""/>
			<input type="button" id="searchBn" value="查询" onclick="search()"/>123
			<input type="button" id="create-dialog" name="add" value="Add"/></div>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<div id="dialog-form" title="新增或修改通讯录" style='display: none'>
	<p class="validateTips">Please notices form fields are valided.</p>
	<form id="addressForm" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="id" id="id" value="">
		<fieldset>
			<TABLE border="0" width="100%">
				<TR>
					<TD><s:text name="address.page.name"/></TD>
					<TD><input type="text" name="name" id="name" value=""></TD>
					<TD><s:text name="address.page.sex"/></TD>
					<TD>
						<site:baseSelect property="sex" id="sex" tableName="DIC_SEX" defaultValue="S0001"/>
					</TD>
				</TR>
				<TR>
					<TD><s:text name="address.page.mobile"/></TD>
					<TD><input type="text" name="mobile" id="mobile" value=""></TD>
					<TD><s:text name="address.page.email"/></TD>
					<TD><input type="text" name="email" id="email" value=""></TD>
				</TR>
				<TR>
					<TD><s:text name="address.page.qq"/></TD>
					<TD><input type="text" name="qq" id="qq" value=""></TD>
					<TD><s:text name="address.page.company"/></TD>
					<TD><input type="text" name="company" id="company" value=""></TD>
				</TR>
				<TR>
					<TD><s:text name="address.page.address"/></TD>
					<TD><input type="text" name="address" id="address" value=""></TD>
					<TD><s:text name="address.page.postcode"/></TD>
					<TD><input type="text" name="postcode" id="postcode" value=""></TD>
				</TR>
				<TR>
					<TD><s:text name="address.page.updateDate"/></TD>
					<TD><input type="text" name="updateDate" id="updateDate" value=""></TD>
				</TR>
				<site:upload/>
			</TABLE>
		</fieldset>
	</form>
</div>

<div style="width: 100%" >
	<table id="tableAddress" style="width: 100%;">
		<thead>
			<TR class="tableheader">
				<th>
					<s:text name="page.id" />
				</th>
				<th>
					<s:text name="address.page.name" />
				</th>
				<th>
					<s:text name="address.page.sex" />
				</th>
				<th>
					<s:text name="address.page.mobile" />
				</th>
				<th>
					<s:text name="address.page.email" />
				</th>
				<th>
					<s:text name="address.page.qq" />
				</th>
				<th>
					<s:text name="address.page.company" />
				</th>
				<th>
					<s:text name="address.page.address" />
				</th>
				<th>
					<s:text name="address.page.updateDate" />
				</th>
				<th>
					<s:text name="address.page.postcode" />
				</th>
				<th>
					<s:text name="page.attachment.name" />
				</th>
				<th>
					<s:text name="button.operation" />
				</th>
			</TR>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>

<%-- ajax分页 <div id='error'></div>--%>
<site:ajaxpage export="true"/>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/upload.tld" prefix="site"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title><s:text name="asset.add.page.position"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript">
function selectStaff1()
{
    var url="staff_toqry.action?method=toQry";
    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].staffId.value = submitValue;
    }
  
}


function checkRecord()
{
	var staffId = document.forms[0].staffId.value;
	var deviceNo = document.forms[0].deviceNo.value;
	var comDisplayNo = document.forms[0].comDisplayNo.value;
	var comHostNo = document.forms[0].comHostNo.value;
	var deviceAddress = document.forms[0].deviceAddress.value;
	if(null == staffId || "" == staffId)
	{
		 alert("必须输入员工号！");
		 return false;
	}
	if(null == deviceNo || "" == deviceNo)
	{
		 alert("必须输入设备号！");
		 return false;
	}
	if(null == comDisplayNo || "" == comDisplayNo)
	{
		 alert("必须输入显示器编号！");
		 return false;
	}
	if(null == comHostNo || "" == comHostNo)
	{
		 alert("必须输入主机编号！");
		 return false;
	}
	if(null == deviceAddress || "" == deviceAddress)
	{
		 alert("必须输入设备存放地！");
		 return false;
	}
	
	return true;
	

}

$(function() {
	// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
	$( "#dialog:ui-dialog" ).dialog( "destroy" );
	
	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 500,
		width: 600,
		modal: true,
		buttons: {
			"提交": function() {
				$( this ).dialog( "close" );
			},
			"取消": function() {
			    document.getElementById("staffId").value = "";
				$( this ).dialog( "close" );
			}
		}
	});
  });

function selectStaff(){
	$.ajax({      
	    url :"staff_show_ajax.action",  //后台处理程序      
	    type:'post',    //数据发送方式      
	    dataType:'json',   //接受数据格式      
	    data:'',   //要传递的数据；就是上面序列化的值      
	    success:function(json){
	    	$( "#dialog-form" ).dialog( "open" );
	    	if (json != null){
	    	    //填充属性
	    	    var tab = $( "#staff" );
	    	    tab.empty();
	    	    var trStr = "";
	    	    for(var i=0;i<json.length;i++){
			    	trStr += "<tr>";
			    	trStr += "<td><table><tr><td><input type='radio' name='staffRadio' value="+json[i].id+" onclick='change(this)'></td></tr></table></td>";
			    	trStr += "<td>"+json[i].id+"</td><td>"+json[i].name+"</td>";
			    	trStr += "<td>"+json[i].skill+"</td><td>"+json[i].status+"</td>";
			    	trStr += "<td>"+json[i].groupname+"</td>";
			    	trStr += "</tr>";
		    	}
		    	tab.append(trStr);
	    	}
	    }
	});
}
	
function change(defValue){
   document.getElementById("staffId").value = defValue.value;
}
</script>

</head>

<body>
<form action="asset_insert.action?method=insert" method="POST" onsubmit="return checkRecord();"
	enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
	<TR>
		<TD>
		<s:text name="asset.add.page.position" />
		</TD>
	</TR>
</TABLE>
<table>
<tr>
<td></td>
</tr>
</table>
<TABLE border="0" width="50%">

	<TR>
		<TD class="tablebody"><s:text name="asset.page.staff.id"/></TD>
		<TD>
		<input type="text" id="staffId" name="staffId" maxlength="10" readonly="readonly">&nbsp;
		<a href="javascript:selectStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.device.no"/></TD>
		<TD><input type="text" name="deviceNo" maxlength="32" >&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.com.display.no"/></TD>
		<TD><input type="text" name="comDisplayNo" maxlength="32">&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.com.host.no"/></TD>
		<TD><input type="text" name="comHostNo" maxlength="32">&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.status"/></TD>
		<TD>
		    <select name="status">
				<option value="0">闲置</option>
				<option value="1">使用中</option>
			</select>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.ip.address"/></TD>
		<TD><input type="text" name="ipAddress" maxlength="32"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="asset.page.device.address"/></TD>
		<TD><input type="text" name="deviceAddress" maxlength="32">&nbsp;<font color="#C10202">*</font></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="asset.page.remark"/></TD>
		<TD><input type="text" name="remark" maxlength="128"></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD>
		<table border="0" width="100%">
		<tr>
		<td style="text-align:right">
				<input type="submit"
			value="<s:text name='button.submit'/>">
			<input type="reset" name="reset" value="<s:text name='button.reset'/>"/>
		
		</td>
		<td width="60%"></td>
		</tr>
		</table>
		</TD>
	</TR>
</TABLE>
</form>
<div id="dialog-form" title="新增或修改">
	<fieldset>
		<input type=hidden name="defStaffId" />
		<table width="100%">
			<tr>
				<td>
					<TABLE border="0" width="100%">
						<TR class="tablebody">
							<TD style="height: 30px; width: 5%;">
								&nbsp;
							</TD>
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
						<tbody id="staff" border="0" width="100%">
							
						</tbody>
					</TABLE>
				</td>
			</tr>
		</table>
	</fieldset>
</div>
</body>
</html>

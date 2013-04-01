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
	if(!isDigital())
	{
		alert("所属月份格式必须为:YYYYMM");
		return false;
	}
	//return true;
}

function isDigital() 
{
	var str = document.forms[0].month.value;
    var i;
    var len = str.length;
    var chkStr = "1234567890";
    if (len < 6) {
	  	return false;
	 }else {
	  	if ((chkStr.indexOf(str.charAt(0)) < 0))  return false;
	  	for (i = 1; i < len; i++) {
	   	if (chkStr.indexOf(str.charAt(i)) < 0)  return false;
	  }
    }
    return true;
}


function selectStaff1()
{
    var url="staff_toqry.action?method=toQry";
    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
    if((submitValue != null) && (submitValue.length != 0))
    {
        document.forms[0].staffId.value = submitValue;
    }
  
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
		<TABLE width="100%" class="position">
			<TR>
				<TD>
					<s:text name="performance.list.position" />
				</TD>

				<!-- 
			<TD align="right">
				<a href="performanceOpt_add.action"><s:text
						name="performance.list.add"></s:text> </a>
			</TD> -->
				<TD width="20"></TD>
			</TR>
		</TABLE>
		<form action="performanceOpt_insert.action" method="post"
			onsubmit="return check();" enctype="multipart/form-data">
			<TABLE border="0" width="100%">
				<TR>
					<TD class="tablebody">
						<s:text name="staff.page.staff.id"></s:text>
					</TD>
					<td>
						<input type="text" id="staffId" name="staffId" value=""
							maxlength="20" readonly="readonly">
						<font color="#C10202">*</font><a href="javascript:selectStaff()">Lookup</a>
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
						<input type="text" name="month" value="${month }" maxlength="6" />
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
									<input type="reset" name="reset"
										value="<s:text name='button.reset'/>" />
								</td>
								<td width="59%"></td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
			<table>
				<tr>
					<TD>
						<s:actionerror />
					</TD>
					<TD>
						<b><s:actionmessage cssStyle="color:red" /> </b>
					</TD>
				</tr>
			</table>
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

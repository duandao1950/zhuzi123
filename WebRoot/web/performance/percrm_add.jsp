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
		
		function selectStaff1()
		{
		    var url="staff_toqry.action?method=toQry";
		    var submitValue = window.showModalDialog(url,window,"scroll:0;status:0;help:1;resizable:1;dialogWidth:550px;dialogHeight:650px");
		    if((submitValue != null) && (submitValue.length != 0))
		    {
		        document.forms[0].staffId.value = submitValue;
		    }
		  
		}
		
		function addRecord()
		{
		
		}

</script>

</head>

<body>
<form action="perCRM_insert.action?method=insert" method="POST" enctype="multipart/form-data"/>
<TABLE width="100%" class="position">
	<TR>
		<TD>
		<s:text name="performance.crm.add.page.position" />
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
		<TD class="tablebody"><s:text name="performance.crm.page.staff.id"/></TD>
		<TD>
		<input type="text" name="staffId" maxlength="20" readonly="readonly">&nbsp;
		<a href="javascript:selectStaff()">Lookup</a>
		</TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.staff.name"/></TD>
		<TD><input type="text" name="staffName" maxlength="30" ></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.requirment.analyze"/></TD>
		<TD><input type="text" name="requirmentAnalyze" maxlength="4"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.coding"/></TD>
		<TD><input type="text" name="coding" maxlength="4"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.problem.counts"/></TD>
		<TD><input type="text" name="problemCounts" maxlength="4"></TD>
	</TR>
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.check.code"/></TD>
		<TD><input type="text" name="checkCode" maxlength="4"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.code.confirm"/></TD>
		<TD><input type="text" name="codeConfirm" maxlength="4"></TD>
	</TR>
	
	
	
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.work.attitude"/></TD>
		<TD><input type="text" name="workAttitude" maxlength="4"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.training"/></TD>
		<TD><input type="text" name="training" maxlength="4"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.team.contribute"/></TD>
		<TD><input type="text" name="teamContribute" maxlength="4"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.daily.work"/></TD>
		<TD><input type="text" name="dailyWork" maxlength="4"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.in.month"/></TD>
		<TD><input type="text" name="inMonth" maxlength="6"></TD>
	</TR>
	<TR>
		<TD class="tablebody"><s:text name="performance.crm.page.other"/></TD>
		<TD><input type="text" name="other" maxlength="4"></TD>
	</TR>
	<TR>
	    <TD></TD>
		<TD colspan="2" ><input type="submit"
			value="<s:text name='button.submit'/>"></TD>
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

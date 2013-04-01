<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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

		<title>CRM
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script>
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
		<form action="perCRM_list.action?method=list" method="POST" enctype="multipart/form-data"/>
		<b><s:actionerror/></b>
		<TABLE width="100%" class="position">
		   <TR height="2">
		        <TD></TD>
		    </TR>
		    <TR>
		        <TD>&nbsp;&nbsp;<b><s:text name="asset.query.page.position" /></b></TD>
		    </TR>
		     <TR height="2">
		        <TD></TD>
		    </TR>
		</TABLE>
		
		<TABLE border="0" width="50%">
		
			<TR>
				<TD class="tablebody"><s:text name="performance.crm.page.staff.id"/></TD>
				<TD>
				<input type="text" id="staffId" name="staffId" maxlength="20" readonly="readonly" value="">&nbsp;
				<a href="javascript:selectStaff()">Lookup</a>
				</TD>
			</TR>
			
			<TR>
				<TD class="tablebody"><s:text name="performance.crm.page.staff.name"/></TD>
				<TD><input type="text" name="staffName" maxlength="20" ></TD>
			</TR>
			<TR>
			    <TD></TD>
				<TD>
		            <table border="0" width="100%">
					<tr>
						<td class="buttontable">
						<input type="submit"
						value="<s:text name='button.submit'/>">
						</td>
						<td width="57%"></td>
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

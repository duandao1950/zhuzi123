<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.struts.util.Constants"%>
<%@ page import="java.util.*"%>
<%@page import="com.hibernate.beans.Menu;"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/dtree.css">
<script type="text/javascript" src="js/dtree.js"></script>
</head>
<body style="margin-top:0px; margin-left:0px; margin-bottom:0px; margin-right:0px;background: #E5EEF7;">
<script type="text/javascript">
function loadTree()
{
d = new dTree('d'); 
d.add ( 0 ,-1 ,'','welcome.action'); 

<%
	ArrayList menuList = (ArrayList)request.getAttribute(Constants.MENU_OF_OPER_ROOT);
	if(null != menuList && menuList.size() > 0){
		for(int i = 0; i < menuList.size(); i++){
		Menu tree = (Menu)menuList.get(i);
		String url = "";
		if((null != tree.getUrl()) && (!"null".equals(tree.getUrl()))){
			url = tree.getUrl();
		}
%>
d.add(<%=tree.getPrivilegeOrder()%>, <%=tree.getParentPOrder()%>,'<%=tree.getPrivilegeName()%>','<%=url%>');
<%
		}//end for
	}//end if
%>
<%
	ArrayList subList = (ArrayList)request.getAttribute(Constants.MENU_OF_OPERATOR);
	if(null != subList && subList.size() > 0)
	{
		for(int j = 0; j < subList.size(); j++)
		{
			Menu t = (Menu)subList.get(j);
%>
d.add(<%=t.getPrivilegeOrder()%>, <%=t.getParentPOrder()%>,'<%=t.getPrivilegeName()%>','<%=t.getUrl()%>');
<%
		}//end for
	}//end if
%>
document.write (d);
}
loadTree();
</script>

</body>
</html>
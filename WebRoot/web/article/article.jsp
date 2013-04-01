<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/business.tld" prefix="site"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=path%>/css/jquery.ui.all.css">
<SCRIPT type="text/javascript" src="<%=path%>/js/jquery-1.6.1.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.button.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.position.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqueryui/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.bigpage.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.valid.js"></script>
<script type="text/javascript" src="<%=path%>/js/web/article/article.js"></script>
<style>
	body { font-size: 62.5%; }
	label, input { display:block; }
	input.text { margin-bottom:12px; width:50%; padding: .4em; }
	fieldset { padding:0; border:0; margin-top:25px; }
	h1 { font-size: 1.2em; margin: .6em 0; }
	div#article-contain { width: 1000px; margin: 20px 0; }
	div#article-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	div#article-contain table th { border: 1px solid #eee; padding: .6em 1px; text-align: left; }
	div#article-contain table td { border: 1px solid #eee; padding: 0em 1px; text-align: left; }
	.ui-dialog .ui-state-error { padding: .3em; }
	.validateTips { border: 1px solid transparent; padding: 0.3em; }
	
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
		text-align: right;
	}
</style>

<script>
/*
function search(){
    try{
	$("#article_list").bigPage({ajaxData:{url:"article_list.action",params:{},batch:true},pageSize:7,cssWidgets:["appendToTable","bgColor","eventColor"],callback:function(){
            //   alert(1);
    }});
    }catch(e){
    alert(e);
    }
}*/
</script>
</head>
<body>

<div id="dialog-form" title="New article">
	<p class="validateTips">All form fields are required.</p>
	<form id="articleForm" method="post">
		<fieldset>
			<label for="style">style</label>
			<input type="text" name="styleId" id="styleId" value="" class="text ui-widget-content ui-corner-all" />
			<label for="title">title</label>
			<input type="text" name="title" id="title" value="" class="text ui-widget-content ui-corner-all" />
			<label for="authorName">author name</label>
			<input type="text" name="authorId" id="authorId" value="" class="text ui-widget-content ui-corner-all" />
			<label for="content">content</label>
			<input type="text" name="content" id="content" value="" class="text ui-widget-content ui-corner-all" />
			<label for="contentExtend">content extend</label>
			<input type="text" name="contentExt" id="contentExt" value="" class="text ui-widget-content ui-corner-all" />
		</fieldset>
	</form>
	<span id="Tip"></span>
</div>
<div id="article-contain" class="ui-widget">
    <div align="right">
     <button id="create-article">New article</button>
	 <button id="searchBn">Query</button>
    </div>
	<table id="article_list" class="ui-widget ui-widget-content">
		<thead>
			<tr class="ui-widget-header">
				<th>style</th>
				<th>title</th>
				<th>author name</th>
				<th>content</th>
				<th>content extend</th>
				<th>create time</th>
				<th>operator</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<input type="hidden" id="id" value=""/>
</body>
</html>
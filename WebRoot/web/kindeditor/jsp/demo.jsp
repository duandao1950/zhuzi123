<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="../themes/default/default.css" />
	<script src="../kindeditor-min.js" charset="utf-8">
	<script charset="utf-8" src="../kindeditor.js"></script>
	<script charset="utf-8" src="../lang/zh_CN.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="article_content"]', {
			    items : [
			        'source','undo','redo','cut','copy','paste','plainpaste','wordpaste',
					'justifyleft','justifycenter','justifyright','justifyfull',
					'bold','italic','underline','fontname','fontsize',
					'plug-align','plug-order','plug-indent',
					'subscript','superscript',
					'formatblock','lineheight','pagebreak','link','unlink','preview'
				],
				afterChange : function() {
				    var count = this.count();
				    if(count>=1000){
				    	alert("改动过大,请慎重!");
				    }
					K('.word_count1').html(this.count());
					K('.word_count2').html(this.count('text'));
				},
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['article'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['article'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<form name="article" method="post" action="demo.jsp">
	           标题:<input name="title" value=""/>&nbsp;
	           时期:<input name="title" value=""/>&nbsp;<p>
	           作者:<input name="title" value=""/>&nbsp;
	           类别:<input name="title" value=""/>&nbsp;<p>
		<textarea name="article_content" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br/>
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
		<p>
			您当前输入了 <span class="word_count1">0</span> 个文字。（字数统计包含HTML代码。）<br />
			您当前输入了 <span class="word_count2">0</span> 个文字。（字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字。）
		</p>
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
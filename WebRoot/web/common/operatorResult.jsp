<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>${action} records is successful</title>
<script type="text/javascript">
function closewindow(){
	window.location.href = ${actionForward};
}
function clock(){
	i = i -1;
	if(document.getElementById("info")){
		document.getElementById("info").innerHTML = "this window will auto colse after "+ i +" seconds";
	}
	if(i > 0)
		setTimeout("clock();",1000);
	else
		closewindow();
}

var i = 3;
clock();

</script>
</head>
<body>
<center>
	${action} records is successful！<p>
	<div id="info">this window will auto colse after two seconds</div>
	<input type="button" value="colse" onclick="closewindow();">
</center>
</body>
</html>
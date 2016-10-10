<%@include file="../header.jsp" %>
<script type="text/javascript">
function checkit(){
	var theForm;
	theForm = document.getElementById("form");
	if(theForm.username==""){
		alert("username must not be null!");
		return false;
	}
	if(theForm.password==""){
		alert("password must not be null!");
		return false;
	}
	theForm.submit();
}
</script>
<center>
	<b>Input the login username and password</b>
	<br><br><br><br><br>
	<form id="form" name="loginForm" action="<c:url value="/u/weblogin"/>" method="post">
	<table>
	<tr>
		<td>username</td>
		<td><input type="text" name="username" size=20></td>
	</tr>
	<tr>
		<td>password</td>
		<td><input type="password" name="password" size=20></td>
	</tr>
	</table>
	<p align="center"><input type="button" name="submit1" value="submit" onclick="checkit()"></p>
	</form>
</center>
</body>
</html>
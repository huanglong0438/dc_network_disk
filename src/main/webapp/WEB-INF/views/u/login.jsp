<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
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
<body>
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
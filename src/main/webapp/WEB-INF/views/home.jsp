<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String token = (String)request.getSession().getAttribute("token");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DC network disk home page</title>
</head>
<body>
	<b>Welcome!!!<br></b>
	welcome to Dc network disk home page.
	<div>you can test:</div>
	<div id = "login">
		<a href="<c:url value="/u/login"/> ">login</a>
	</div>
	<div id = "showfilelist">
		<a href="<c:url value="/file/sfl/<%=token%>"/>">show filelist</a>
	</div>
	<div id = "upload">
		<a href="<c:url value="/upload"/>">upload file to the Server</a>
	</div>
	<div id = "download">
		<a href="<c:url value="/download"/>">download file from the Server</a>
	</div>
</body>
</html>
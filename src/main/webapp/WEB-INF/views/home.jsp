<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DC network disk home page</title>
</head>
<body>
	<c:set var="token" value="${token}"></c:set>
	<b>Welcome!!!<br></b>
	welcome to Dc network disk home page.
	<div>you can test:</div>
	<div id = "login">
		<a href="<c:url value="/u/login"/> ">login</a>
	</div>
	<div id = "showfilelist">
		<a href="<c:url value="/file/sfl_web/${token}/%252f"/>">show filelist</a>
	</div>
	<div id = "upload">
		<a href="<c:url value="/file/upload"/>">upload file to the Server</a>
	</div>
	<div id = "download">
		<a href="<c:url value="/file/download/${token}/%252f/西安兼职.txt"/>">download file from the Server</a>
	</div>
</body>
</html>
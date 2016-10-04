<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UploadFile</title>
</head>
<body>
<c:set var="token" value="${token}"/>
<center>
	<div>
		<b>Select the file you'd like to upload.</b>
	</div>
	<div id = "upload_form">
		<c:url var="actionUrl" value="/file/upload/${token}/%252F"/>
		<form action="${actionUrl}" method="post" enctype="multipart/form-data">
			<p><label for="file">File</label></p>
			<p><input id="file" type="file" name="file"></p>
			<p><button type="submit">upload</button></p>
		</form>
	</div>	
</center>
</body>
</html>
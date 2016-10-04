<%@page import="com.dcnetworkdisk.file.model.DcFile"%>
<%@page import="java.io.File"%>
<%@page import="com.dcnetworkdisk.common.utils.URLEncoderUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show FileList Page</title>
</head>
<body>
	<p><b>FileList</b></p>
	<c:set var="token" value="${token}"/>
	<c:set var="sucess" value="${success}"></c:set>
	<c:if test="${sucess == true}">
		<c:forEach items="${filelist}" var="file">
			<c:set var="path" value="${file.filepath}"></c:set>
			<%
				String path = (String)pageContext.getAttribute("path");
				path = URLEncoderUtil.encode(path, "utf-8");
				pageContext.setAttribute("path", path);
				
				String filename = ((DcFile)pageContext.getAttribute("file")).getFilename();
				System.out.println(filename);
				pageContext.setAttribute("filename", filename);
			%>
			<p><a href='<c:url value="/file/download/${token}/${path}/${filename}"/>'>${file.filename}</a></p>
			<p>&emsp;File Size：${file.filesize} Bytes</p>
			<p>&emsp;Create Time：${file.create_date}</p>
			<p>&emsp;Modified Time：${file.create_date}</p>
		</c:forEach>
	</c:if>
	<c:if test="${sucess == false}">
		<c:out value="${errorMsg}"></c:out>
	</c:if>
</body>
</html>
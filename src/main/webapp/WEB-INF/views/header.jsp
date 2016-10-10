<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DC network disk home page</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href='<c:url value="/css/landing-page.min.css"/>' rel="stylesheet" id="theme-css"/>
<link href='<c:url value="/css/jcala-md.min.css"/>' rel="stylesheet"/>
<link href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand topnav" href='<c:url value="/"/>'>Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right myBar">
                <li>
                    <a href="/archives/1">Archives</a>
                </li>
                <li>
                    <a href="/tags">Tags</a>
                </li>
                <li>
                    <a href="/projects/1">Projects</a>
                </li>
                <li>
                    <a href="/about">About</a>
                </li>
                <li>
                    <a href="/admin/">Admin</a>
                </li>
                <li>
                    <a href='javascript:void(0)' onclick="day_night()"><i class="fa fa-moon-o" id="day-night"></i>
                        <span class="network-name" id="day-night-name">night</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lol website</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="/js/jquery-2.0.3.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    
    <style type="text/css">
        body {
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="container">

<div class="clearfix">
<h1 class="pull-left">So very not cool website</h1>

<div class="pull-right">
    
<c:choose>
    <c:when test="${user != null}">
        Logged in: <span id="email">${user.email}</span>
        <a href="#" onclick="document.form.submit();">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/login">Login</a>
    </c:otherwise>
</c:choose>
    <div>Create new <a href="/signup">account</a></div>
</div>
</div>

<a href="/">Home</a>

<form:form action="/logout" method="POST" name="form">
</form:form>

<hr/>

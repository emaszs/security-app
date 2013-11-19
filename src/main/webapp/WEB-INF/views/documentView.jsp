<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h3>Secret document: ${fn:escapeXml(doc.title)}</h3>
    
<hr>

<span id="content">${fn:escapeXml(doc.content)}</span>

<br/><br/>

<a href="/doc" class="btn">Back</a>

<%@include file="footer.jsp" %>
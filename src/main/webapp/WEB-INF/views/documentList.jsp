<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h3>Secret documents</h3>
    
<table class="table">
    <thead>
        <tr>
            <th>Title</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${documents}">
        <tr>
            <td><a href="/doc/${item.id}">${item.title}</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<a href="/doc/add" class="btn btn-primary">New...</a>

<%@include file="footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h3>SQL Injection</h3>

<form:form class="form-horizontal" method="get" action="/sql" >

    <div class="control-group">
        <input type="text" name="filter" id="filter" placeholder="enter email fragment" value="${filter}"/>
        <input type="submit" class="btn btn-primary"/>
    </div>
</form:form>    
<table class="table">
    <thead>
        <tr>
            <th>email</th>
            <th>first name</th>
            <th>last name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${users}">
        <tr>
            <td>${item.email}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td> 
        </tr>
        </c:forEach>
    </tbody>
</table>



<%@include file="footer.jsp" %>
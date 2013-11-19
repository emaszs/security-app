<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h3>Login</h3>

<c:if test="${param.error != null}">
    <div class="alert alert-error">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
</c:if>

<form:form cssClass="form-horizontal" method="POST" action="/login" >

    <div class="control-group">
        <input type="text" name="username" id="username" placeholder="username..."/>
        <input type="password" name="password" id="pasword" placeholder="password..."/>
        
        <input type="submit" class="btn btn-primary" value="Login"/>
    </div>

</form:form>

Signup <a href="/signup">here</a>.

<%@include file="footer.jsp" %>
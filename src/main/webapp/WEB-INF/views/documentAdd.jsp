<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h3>Add secret documents</h3>

<form:form action="/doc/add" method="POST" cssClass="form-horizontal" commandName="doc">

    <div class="control-group">
        <label for="title">Title:</label>
        <form:input path="title" placeholder="title" id="title"/>
        <form:errors path="title" class="help-inline"></form:errors>
    </div>
    
    <div class="control-group">
        <label for="recipient">Recipient:</label>
        <form:select path="ownerId">
            <form:options items="${users}" itemLabel="email" itemValue="id"/>
        </form:select>
    </div>


    <div class="control-group">
        <label for="content">Content:</label>
        <form:textarea path="content"/>
        <form:errors path="content" class="help-inline"></form:errors>
    </div>
    
    <form:button class="btn btn-primary">Create</form:button>
    <a href="/doc" class="btn">Back</a>
</form:form> 

<%@include file="footer.jsp" %>
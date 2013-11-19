<%@include file="header.jsp" %>

<h3>Signup</h3>

<form:form method="POST" commandName="account" cssClass="form-horizontal">
    <div class="control-group">
        <label for="email">Email:</label>
        <form:input path="email" id="email"/>
        <form:errors path="email" class="inline-help"/> 
    </div>
    <div class="control-group">
        <label for="firstName">First name:</label>
        <form:input path="firstName" id="firstName"/> 
    </div>
    <div class="control-group">
        <label for="lastName">Last name:</label>
        <form:input path="lastName" id="lastName"/> 
    </div>
    <div class="control-group">
        <label for="passwordHash">Password:</label>
        <form:password path="passwordHash" id="passwordHash"/>
        <form:errors path="passwordHash" class="inline-help"/>
    </div>
    <br/>
    <form:button class="btn btn-primary">Signup</form:button>
    <a href="/login" class="btn">Back</a>
</form:form>

<%@include file="footer.jsp" %>

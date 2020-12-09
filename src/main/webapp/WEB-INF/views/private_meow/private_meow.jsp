<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meow</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-white text-dark">

<table class="table table-striped">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Recipient</th>
        <th>Created</th>
    </tr>
    <tr>
        <td>${meow.title}</td>
        <td>${meow.author.username}</td>
        <td>${meow.recipient.username}</td>
        <td>${meow.created}</td>
    </tr>
</table>

<div class="p-3 mb-2 bg-light text-dark container col-6">
    <h4 class="text-center container col-6">${meow.message}</h4>
</div>

<%--<a class="btn btn-dark float-right" href="http://localhost:8080/comment/add/${meow.id}">Add new comment</a>--%>


</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>


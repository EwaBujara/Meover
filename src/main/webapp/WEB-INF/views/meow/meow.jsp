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
        <th>Created</th>
    </tr>
    <tr>
        <td>${meow.title}</td>
        <td>${meow.user.username}</td>
        <td>${meow.created}</td>
    </tr>
</table>

<div class="p-3 mb-2 bg-light text-dark container col-6">
    <h4 class="text-center container col-6">${meow.meowText}</h4>
</div>

<a class="btn btn-dark float-right" href="http://localhost:8080/comment/add/${meow.id}">Add new comment</a>
<h5>Comments (${comments.size()}):</h5>

<table class="table table-striped">
    <tr>
        <th>Author</th>
        <th>Created</th>
        <th>Comment</th>
    </tr>
    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.user.username}</td>
            <td>${comment.created}</td>
            <td>${comment.text}</td>
        </tr>
    </c:forEach>
</table>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

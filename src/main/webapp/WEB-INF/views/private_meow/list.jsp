<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Private Meows Box</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-white text-dark">

<a class="btn btn-danger" href="http://localhost:8080/private_meow/add">New Private Meow</a>
<a class="btn btn-dark" href="http://localhost:8080/private_meow/inBox">In</a>
<a class="btn btn-dark" href="http://localhost:8080/private_meow/out">Out</a>
<h3>Meow-box</h3>

<table class="table table-striped">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Recipient</th>
        <th>Created</th>
        <th>Meow</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${meows}" var="meow">

       <c:if test="${meow.status==true}"> <tr bgcolor="#db7093"> </c:if>
       <c:if test="${meow.status==false}"> <tr> </c:if>
        <td><c:if test="${meow.status==true}">NEW </c:if>${meow.title}</td>
            <td>${meow.author.username}</td>
            <td>${meow.recipient.username}</td>
            <td>${meow.created}</td>
            <td>${fn:substring(meow.message, 0, 40)}</td>
            <td><a class="btn btn-dark" href="http://localhost:8080/private_meow/show/${meow.id}">See more</a></td>
        </tr>

    </c:forEach>
</table>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

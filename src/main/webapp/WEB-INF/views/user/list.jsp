<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-white text-dark">

<c:if test="${currentUser == null}">
    <div class="p-3 mb-2 bg-light text-dark">
        <h3 class="text-center">You have no access!</h3>
        <p class="text-center">You must sign in</p>
    </div>
</c:if>

<c:if test="${currentUser != null}">

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Meows</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">

        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-dark" href="http://localhost:8080/meow/list/${user.id}">${user.meows.size()}</a></td>
                <c:if test="${currentUser.id != user.id}">
            <td><a class="btn btn-dark" href="http://localhost:8080/private_meow/add">Send Private Meow</a></td>
                </c:if>
            <c:if test="${currentUser.id == user.id}">
                <td><a class="btn btn-dark" href="http://localhost:8080/user/account">Your profile</a></td>
            </c:if>

        </tr>

    </c:forEach>
</table>
</c:if>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

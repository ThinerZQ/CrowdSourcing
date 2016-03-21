<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/header.js"></script>

    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>

<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div class="row">
    <div class="container">
        <table class="table table-bordered table-hover">
            <caption class="text-center">StateMachine Instances Management</caption>
            <thead>
            <tr>
                <td>ProcessID</td>
                <td>ProcessName</td>
                <td>ProcessState</td>
                <td>StartDate</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${processInstanceEntityArrayList }" var="processInstanceEntity">
                <tr>
                    <td><c:out value="${processInstanceEntity.processInstanceId}"></c:out></td>
                    <td><c:out value="${processInstanceEntity.processInstanceName}"></c:out></td>
                    <td><c:out value="${processInstanceEntity.processInstanceCurrentState}"></c:out></td>
                    <td><c:out value="${processInstanceEntity.processInstanceCreateTime}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

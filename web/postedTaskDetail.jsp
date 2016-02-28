<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/2/28
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/header.js"></script>
    <title>My Posted Task</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div class="container-fluid" style="background: url('images/bg-login-top.png') repeat #fff;">
    <div class="container">

        <div class="row">
            <div class="col-lg-3">
                TaskName
            </div>
            <div class="col-lg-9">
                <c:out value="${myPostedCrowdSourcingTask.taskName}"></c:out>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3">
                TaskDescription
            </div>
            <div class="col-lg-9">
                <c:out value="${myPostedCrowdSourcingTask.taskDescription}"></c:out>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3">
                TaskSolution
            </div>
            <div class="col-lg-9">
                <c:out value="${myPostedCrowdSourcingTask.taskSolution}"></c:out>
            </div>
        </div>

    </div>
</div>

<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

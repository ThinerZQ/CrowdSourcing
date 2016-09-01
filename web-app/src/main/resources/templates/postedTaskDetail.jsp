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
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-1.11.3.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/header.js"></script>
    <title>My Posted Task</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div class="container-fluid" style="background: url('../../static/images/bg-login-top.png') repeat #fff;">
    <div class="container">

        <div class="row">
            <table class="table table-bordered table-hover">
                <caption class="text-center">Solution</caption>
                <thead>
                <tr>
                    <td>Property</td>
                    <td>Content</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>TaskName</td>
                    <td><c:out value="${myPostedCrowdSourcingTask.taskName}"></c:out></td>

                </tr>
                <tr>
                    <td>TaskDescription</td>
                    <td><c:out value="${myPostedCrowdSourcingTask.taskDescription}"></c:out></td>

                </tr>
                <tr>

                    <td>TaskSolution</td>
                    <td><span>${myPostedCrowdSourcingTask.taskSolution}</span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

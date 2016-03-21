<%--
  Created by IntelliJ IDEA.
  User: ThinerZQ
  Date: 2016/1/16
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Task</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/header.js"></script>

</head>
<body>

<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div class="container-fluid" style="background: url('images/bg-login-top.png') repeat #fff;">

    <jsp:include page="carousel.jsp"></jsp:include>
    <jsp:include page="information.jsp"></jsp:include>
</div>

<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

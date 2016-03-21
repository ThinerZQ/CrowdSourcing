<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/18
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Success</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/header.js"></script>

</head>
<body>

<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div>
    ${sucessMessage}
</div>


<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

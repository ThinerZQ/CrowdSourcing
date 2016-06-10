<%--
  Created by IntelliJ IDEA.
  User: ThinerZQ
  Date: 2016/1/27
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Task Detail</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/header.js"></script>
    <script src="js/decompose.js"></script>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div class="container-fluid" style="background: url('images/bg-login-top.png') repeat #fff;">

    <jsp:include page="carousel.jsp"></jsp:include>


    <div class="row">
        <div class="container">
            <ul id="myTab" class="nav nav-tabs">
                <li>
                    <a href="${pageContext.request.contextPath}/Home.do">Home</a>
                </li>
                <li class="active"><a href="${pageContext.request.contextPath}/task.do">OriginalTask</a></li>
                <li><a href="${pageContext.request.contextPath}/judgeTask.do">JudgeTask</a></li>
                <li><a href="${pageContext.request.contextPath}/decomposeTask.do">DecomposeTask</a></li>
                <li><a href="${pageContext.request.contextPath}/solveTask.do">SolveTask</a></li>
                <li><a href="${pageContext.request.contextPath}/voteTask.do">VoteTask</a></li>
                <li><a href="${pageContext.request.contextPath}/mergeTask.do">MergeTask</a></li>
                <li class="dropdown">
                    <a href="#" id="myTabDrop1" class="dropdown-toggle"
                       data-toggle="dropdown">OtherTask
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                        <li><a href="#otherTask1" tabindex="-1" data-toggle="tab">其他任务1</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                    </ul>
                </li>
            </ul>
            ${pageContext.request.contextPath}/${userWorkItemEntity.itemFormEntity.formSrc }
            <jsp:include page="${userWorkItemEntity.itemFormEntity.formSrc }">
                <jsp:param name="userWorkItemEntity" value="${userWorkItemEntity}"></jsp:param>
                <jsp:param name="crowdSourcingTask" value="${crowdSourcingTask}"></jsp:param>
                <jsp:param name="decomposeTaskUserWorkflowMap" value="${decomposeTaskUserWorkflowMap }"></jsp:param>
                <jsp:param name="solveTaskUserWorkflowMap" value="${solveTaskUserWorkflowMap }"></jsp:param>


            </jsp:include>
        </div>
    </div>
</div>

<footer>

</footer>
</body>
</html>

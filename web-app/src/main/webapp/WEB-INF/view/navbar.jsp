<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="${pageContext.request.contextPath}/Home.do">Home</a>
    </li>
    <li><a href="${pageContext.request.contextPath}/judgeTask.do">JudgeTask</a></li>
    <li><a href="${pageContext.request.contextPath}/decomposeTask.do">DecomposeTask</a></li>
    <li><a href="${pageContext.request.contextPath}/decomposeVoteTask.do">DecomposeVoteTask</a></li>
    <li><a href="${pageContext.request.contextPath}/solveTask.do">SolveTask</a></li>
    <li><a href="${pageContext.request.contextPath}/solveVoteTask.do">SolveVoteTask</a></li>
    <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">Other
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <li><a href="#otherTask1" tabindex="-1" data-toggle="tab">OtherTask1</a></li>
            <li><a href="#ejb" tabindex="-1" data-toggle="tab">OtherTask2</a></li>
            <li><a href="#ejb" tabindex="-1" data-toggle="tab">OtherTask3</a></li>
            <li><a href="#ejb" tabindex="-1" data-toggle="tab">OtherTask4</a></li>
        </ul>
    </li>
</ul>
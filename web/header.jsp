<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/20
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse" style="margin-bottom: 0px">
    <div class="container">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">CrowdSourcing</a>
            </div>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search CrowdSourcing">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right" style="margin-top: 10px;">

                <c:choose>
                    <c:when test="${empty sessionScope.get('currentUserEntity')}">
                        <li>
                            <button type="button" class="btn btn-success" style="color: white;margin-right: 10px;"
                                    onclick="signUp()">sign up
                            </button>
                        </li>
                        <li>
                            <button type="button" class="btn btn-default" style="color: black" onclick="signIn()">
                                Sign in
                            </button>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li style="color: red;">
                            <c:set var="user" value="${sessionScope.get('currentUserEntity')}" scope="page"></c:set>
                            welcome : <c:out value="${user.userRealName}"></c:out>
                        </li>
                        <li style="color: red;">
                            <button type="button" class="btn btn-default" style="color: black">
                                Your Profile
                            </button>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>


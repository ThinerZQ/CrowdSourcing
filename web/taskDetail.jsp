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
    <title>任务详情</title>

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

    <div class="row">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active container">
                    <img src="images/slide1.png" alt="First slide">

                    <div class="carousel-caption">标题 1</div>
                </div>
                <div class="item container">
                    <img src="images/slide2.png" alt="Second slide">

                    <div class="carousel-caption">标题 2</div>
                </div>
                <div class="item container">
                    <img src="images/slide3.png" alt="Third slide">

                    <div class="carousel-caption">标题 3</div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>
    </div>


    <div class="row">
        <div class="container">
            <ul id="myTab" class="nav nav-tabs">
                <li>
                    <a href="${pageContext.request.contextPath}/Home.do">Home</a>
                </li>
                <li class="active"><a href="${pageContext.request.contextPath}/task.do">原始任务</a></li>
                <li><a href="${pageContext.request.contextPath}/judgeTask.do">判断任务</a></li>
                <li><a href="${pageContext.request.contextPath}/decomposeTask.do">分解任务</a></li>
                <li><a href="${pageContext.request.contextPath}/solveTask.do">解决任务</a></li>
                <li><a href="${pageContext.request.contextPath}/voteTask.do">投票任务</a></li>
                <li><a href="${pageContext.request.contextPath}/mergeTask.do">合并任务</a></li>
                <li class="dropdown">
                    <a href="#" id="myTabDrop1" class="dropdown-toggle"
                       data-toggle="dropdown">其他任务
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
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <c:if test="${null !=  userWorkItemEntity}">
                        <div class="panel panel-primary panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">任务名字：<c:out
                                        value="${userWorkItemEntity.itemName}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;任务发布时间：<c:out
                                            value="${userWorkItemEntity.itemCreateTime}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;责任人：<c:out
                                            value="${userEntity.userRealName}"></c:out>
                                </h3>
                        </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <!-- 输出当前任务所带的表单,感觉不好 -->
                                        <table>
                                            <c:forEach
                                                    items="${userWorkItemEntity.itemFormEntity.formItemEntityLinkedHashSet }"
                                                    var="formItem">
                                                <tr>
                                                    <td>
                                                        <c:out value="${formItem.formItemName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:if test="${formItem.formItemType eq 'output'}">
                                                            <input type="text" value="${formItem.formItemValue }"/>
                                                        </c:if>
                                                        <c:if test="${formItem.formItemType eq 'input'}">
                                                            <input type="text" value="${formItem.formItemValue }"
                                                                   disabled/>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>

                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <a href="${pageContext.request.contextPath}/complete.do?userWorkItemId=<c:out value="${userWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-group" role="button">完成</a>
                            </div>
                    </div>
                    </c:if>
                    <c:if test="${null !=  groupWorkItemEntity}">
                        <div class="panel panel-primary panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">任务名字：<c:out
                                        value="${userWorkItemEntity.itemName}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;任务发布时间：<c:out
                                            value="${userWorkItemEntity.itemCreateTime}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;责任人：<c:out
                                            value="${userEntity.userRealName}"></c:out>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        任务名：<c:out value="${groupWorkItemEntity.itemName}"></c:out>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <a href="${pageContext.request.contextPath}/signIn.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-group" role="button">签收</a>
                            </div>
                        </div>
                    </c:if>
                </div>

            </div>
        </div>
    </div>
</div>


</div>
</body>
</html>

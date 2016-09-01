<%--
  Created by IntelliJ IDEA.
  User: 强
  Date: 2016/2/5
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="container">

        <jsp:include page="navbar.jsp"></jsp:include>


        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="home">
                <c:choose>
                    <c:when test="${not empty HomeTaskEntityList}">

                        <c:forEach items="${HomeTaskEntityList }" var="taskEntity">

                            <div class="panel panel-primary panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><c:out value="${taskEntity.title}"></c:out></h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            发布者：<span><c:out
                                                value="${taskEntity.userEntity.userName}"></c:out></span>
                                        </div>
                                        <div class="col-lg-6 text-right">
                                            过期时间：
                                            <span><c:out value="${taskEntity.deadlineTime}"></c:out></span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <c:forEach items="${taskEntity.descriptionEntitySet}"
                                                       var="descriptionEntity">
                                                <c:out value="${descriptionEntity.description}"></c:out>
                                                </br>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 text-danger">
                                            资格要求
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer text-right">
                                    <span class="text-danger"><c:out value="${taskEntity.price}"></c:out>元</span>
                                    <a href="#" class="btn btn-success" role="button">详细</a>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-3">
                                <ul class="pagination pagination-lg container">
                                    <li><a href="#">&laquo;</a></li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li class="disabled"><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">6</a></li>
                                    <li><a href="#">7</a></li>
                                    <li><a href="#">8</a></li>
                                    <li><a href="#">9</a></li>
                                    <li><a href="#">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>

                    </c:when>
                    <c:otherwise>
                        <c:out value="no task"></c:out>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
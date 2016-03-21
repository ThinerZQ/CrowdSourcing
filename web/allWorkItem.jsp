<%--
  Created by IntelliJ IDEA.
  User: 强
  Date: 2016/2/5
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <c:choose>
            <c:when test="${not empty userWorkItemEntityList}">
                <span> User Task</span>
                <c:forEach items="${userWorkItemEntityList }" var="userWorkItemEntity">
                    <div class="panel panel-primary panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Process ID：<c:out
                                    value="${userWorkItemEntity.itemProcessId}"></c:out>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;State ：<c:out
                                        value="${userWorkItemEntity.itemStateId}"></c:out>
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    taskName：<c:out value="${userWorkItemEntity.itemName}"></c:out>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    releaseTime：<span><c:out
                                        value="${userWorkItemEntity.itemCreateTime }"></c:out></span>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <a href="${pageContext.request.contextPath}/userTaskDetail.do?userWorkItemId=<c:out value="${userWorkItemEntity.itemId}"></c:out>"
                               class="btn btn-success" role="button">Detail</a>
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
                </br>
            </c:when>
            <c:otherwise>
                <h3><c:out value="No User Task"></c:out></h3></br>
            </c:otherwise>

        </c:choose>
        <c:choose>
            <c:when test="${not empty groupWorkItemArrayListMap}">
                <h3>Group Task</h3></br>
                <c:forEach items="${groupWorkItemArrayListMap.keySet() }" var="groupEntity">

                    Current Group：<c:out value="${groupEntity.groupName}"></c:out>

                    <c:forEach items="${groupWorkItemArrayListMap.get(groupEntity) }"
                               var="groupWorkItemEntity">
                        <div class="panel panel-primary panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">Process ID：<c:out
                                        value="${groupWorkItemEntity.itemProcessId}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;State：<c:out
                                            value="${groupWorkItemEntity.itemStateId}"></c:out>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        Task Name：<c:out value="${groupWorkItemEntity.itemName}"></c:out>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        Relase Time：<span><c:out
                                            value="${groupWorkItemEntity.itemCreateTime }"></c:out></span>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <a href="${pageContext.request.contextPath}/signIn.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-group" role="button">Sign For It</a>
                                <a href="${pageContext.request.contextPath}/groupTaskDetail.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-success" role="button">Detail</a>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${not empty groupWorkItemArrayListMap.get(groupEntity)}">
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
                    </c:if>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:out value="no group task"></c:out>
            </c:otherwise>
        </c:choose>
    </div>
</div>
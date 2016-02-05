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
                <span> 用户自己任务</span>
                <c:forEach items="${userWorkItemEntityList }" var="userWorkItemEntity">
                    <div class="panel panel-primary panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">流程ID：<c:out
                                    value="${userWorkItemEntity.itemProcessId}"></c:out>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;任务所处状态：<c:out
                                        value="${userWorkItemEntity.itemStateId}"></c:out>
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    任务名：<c:out value="${userWorkItemEntity.itemName}"></c:out>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    发布时间：<span><c:out
                                        value="${userWorkItemEntity.itemCreateTime }"></c:out></span>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <a href="${pageContext.request.contextPath}/userTaskDetail.do?userWorkItemId=<c:out value="${userWorkItemEntity.itemId}"></c:out>"
                               class="btn btn-success" role="button">详细</a>
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
                <c:out value="no user task"></c:out>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${not empty groupWorkItemArrayListMap}">
                <span>用户所在组的任务</span>
                <c:forEach items="${groupWorkItemArrayListMap.keySet() }" var="groupEntity">

                    当前组：<c:out value="${groupEntity.groupName}"></c:out>

                    <c:forEach items="${groupWorkItemArrayListMap.get(groupEntity) }"
                               var="groupWorkItemEntity">
                        <div class="panel panel-primary panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">流程ID：<c:out
                                        value="${groupWorkItemEntity.itemProcessId}"></c:out>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;任务所处状态：<c:out
                                            value="${groupWorkItemEntity.itemStateId}"></c:out>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        任务名：<c:out value="${groupWorkItemEntity.itemName}"></c:out>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        发布时间：<span><c:out
                                            value="${groupWorkItemEntity.itemCreateTime }"></c:out></span>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <a href="${pageContext.request.contextPath}/signIn.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-group" role="button">签收</a>
                                <a href="${pageContext.request.contextPath}/groupTaskDetail.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                                   class="btn btn-success" role="button">详细</a>
                            </div>
                        </div>
                    </c:forEach>
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
                <c:out value="no group task"></c:out>
            </c:otherwise>
        </c:choose>
    </div>
</div>
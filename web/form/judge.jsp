<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <c:if test="${null !=  userWorkItemEntity}">
            <form action="${pageContext.request.contextPath}/completeJudgeTask.do" class="form-horizontal">
            <div class="panel panel-primary panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">WorkItemName：<c:out
                            value="${userWorkItemEntity.itemName}"></c:out>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WorkItemDeployDateTime：<c:out
                                value="${userWorkItemEntity.itemCreateTime}"></c:out>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;person in charge ：<c:out
                                value="${currentUserEntity.userRealName}"></c:out>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">

                            <table class="table table-bordered table-hover">
                                <caption class="bg-danger text-center">this task is simple or complex? please give you
                                    choice
                                </caption>

                                <tr class="info">
                                    <td>
                                        taskName
                                    </td>
                                    <td>
                                        <c:out value="${crowdSourcingTask.taskName}"></c:out>
                                    </td>
                                </tr>
                                <tr class="info">
                                    <td>
                                        taskDescription
                                    </td>
                                    <td>
                                        <c:out value="${crowdSourcingTask.taskDescription}"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Property
                                    </td>
                                    <td>
                                        <input type="radio" name="property" value="simple"/> Simple
                                        <input type="radio" name="property" value="complex"/> Complex
                                    </td>
                                </tr>

                            </table>
                            <input hidden="hidden" type="text"
                                   value="<c:out value='${userWorkItemEntity.itemId}'></c:out>" name="userWorkItemId">

                        </div>
                    </div>
                </div>
                <div class="panel-footer text-right">
                    <button class="btn-success btn btn-group" type="submit">Complete</button>
                </div>
            </div>
        </form>
    </div>
    </c:if>
    <c:if test="${null !=  groupWorkItemEntity}">
        <form>
            <div class="panel panel-primary panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">WorkItemName：<c:out
                            value="${userWorkItemEntity.itemName}"></c:out>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WorkItemDeployDateTime：<c:out
                                value="${userWorkItemEntity.itemCreateTime}"></c:out>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Responsible ：<c:out
                                value="${currentUserEntity.userRealName}"></c:out>
                    </h3>
                </div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">

                            <table class="table table-bordered table-hover">
                                <tr class="info">
                                    <td>
                                        taskName
                                    </td>
                                    <td>
                                        <c:out value="${crowdSourcingTask.taskName}"></c:out>
                                    </td>
                                </tr>
                                <tr class="info">
                                    <td>
                                        taskDescription
                                    </td>
                                    <td>
                                        <c:out value="${crowdSourcingTask.taskDescription}"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Property
                                    </td>
                                    <td>
                                        <input type="radio" name="property" value="simple"/> Simple
                                        <input type="radio" name="property" value="complex"/> Complex
                                    </td>
                                </tr>
                            </table>

                        </div>
                    </div>
                </div>
                <div class="panel-footer text-right">
                    <a href="${pageContext.request.contextPath}/signIn.do?groupWorkItemId=<c:out value="${groupWorkItemEntity.itemId}"></c:out>"
                       class="btn btn-group" role="button">SignIn</a>
                </div>
            </div>
        </form>
    </c:if>
</div>
















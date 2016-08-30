<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <c:if test="${null !=  userWorkItemEntity}">
            <form action="${pageContext.request.contextPath}/completeDecomposeTask.do" class="form-horizontal"
                  method="post">
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
                            <table class="table table-bordered table-hover" id="decomposeTable">
                                <caption class="bg-danger text-center">look up following task and give the decompose
                                    schema
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
                                        Steps
                                    </td>
                                    <td>
                                        <input list="steps" onchange="popupSteps()" id="stepInput" name="steps">
                                        <datalist id="steps">
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </datalist>
                                    </td>
                                </tr>
                                <tr class="hidden hidden1">
                                    <td>
                                        Step1<input hidden="hidden" type="text" name="order" value="1"/>
                                    </td>
                                    <td>
                                        <input type="text" name="stepName" value="" style="width:80%">
                                        <br/>
                                        <textarea cols="100" rows="4" name="stepDescription"></textarea>
                                    </td>
                                </tr>
                                <tr class="hidden hidden2">
                                    <td>
                                        Step2<input hidden="hidden" type="text" name="order" value="2"/>
                                    </td>
                                    <td>
                                        <input type="text" name="stepName" value="" style="width:80%">
                                        <br/>
                                        <textarea cols="100" rows="4" name="stepDescription"></textarea>
                                    </td>
                                </tr>
                                <tr class="hidden hidden3">
                                    <td>
                                        Step3<input hidden="hidden" type="text" name="order" value="3"/>
                                    </td>
                                    <td>
                                        <input type="text" name="stepName" value="" style="width:80%">
                                        <br/>
                                        <textarea cols="100" rows="4" name="stepDescription"></textarea>
                                    </td>
                                </tr>
                                <tr class="hidden hidden4">
                                    <td>
                                        Step4<input hidden="hidden" type="text" name="order" value="4"/>
                                    </td>
                                    <td>
                                        <input type="text" name="stepName" value="" style="width:80%">
                                        <br/>
                                        <textarea cols="100" rows="4" name="stepDescription"></textarea>
                                    </td>
                                </tr>
                                <tr class="hidden hidden5">
                                    <td>
                                        Step5<input hidden="hidden" type="text" name="order" value="5"/>
                                    </td>
                                    <td>
                                        <input type="text" name="stepName" value="" style="width:80%">
                                        <br/>
                                        <textarea cols="100" rows="4" name="stepDescription"></textarea>
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

















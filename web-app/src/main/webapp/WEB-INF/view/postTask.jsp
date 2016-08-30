<%--
  Created by IntelliJ IDEA.
  User: 强
  Date: 2015/9/1
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-1.11.3.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/header.js"></script>
    <script src="../../static/js/post.js"></script>
    <title>Post Task</title>

    <link rel="stylesheet" href="../../static/css/post.css"/>

</head>

<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div class="container-fluid" style="background: url('../../static/images/bg-login-top.png') repeat #fff;">
    <div class="container">
        <div class="row bg-danger" style="height: 50px;margin-bottom: 5px">
            <h3 style="margin-bottom: 10px" class="text-center">Assured Published</h3>
        </div>
        <div class="row">
            <div class="col-lg-8" style="padding-left: 0px">
                <form class="form" action="${pageContext.request.contextPath}/post.do">
                    <div class="form-group">
                        <label for="inputTitle" class="control-label">taskName：</label>

                        <div>
                            <input type="text" class="form-control" id="inputTitle" name="taskName"
                                   placeholder="describing your task by a phrase" style="width: 50%">
                        </div>
                    </div>


                    <%--
                    <div class="form-group">
                        <label for="inputPhoneNumber" class="control-label">请确认您的联系方式，我们才知道怎么联系您噢</label>

                        <div class="row">
                            <div class="col-lg-3 " style="padding-right: 0px">
                                <input type="tel" class="form-control" id="inputPhoneNumber" placeholder="请输入手机号码">
                            </div>
                            <div class="col-lg-4" style="padding-left: 0px">
                                <button type="button" class="btn btn-default">点我获取验证码</button>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputCheckCode" class="control-label sr-only">checkCode</label>

                        <div class="row">
                            <div class="col-lg-3" style="padding-right: 0px">
                                <input type="text" class="form-control " id="inputCheckCode"
                                       placeholder="请输入手机验证码">
                            </div>

                        </div>
                    </div>
--%>
                    <div class="form-group">
                        <label for="inputDetail" class="control-label">mission requirement detail </label>

                        <div>
                        <textarea class="form-control" id="inputDetail" placeholder="Specifically describe your task"
                                  name="taskDescription"
                                  style="width: 80%;height: 250px"></textarea>
                        </div>
                    </div>

                    <%--  <div class="form-group">
                          <label for="inputFile" class="control-label sr-only">file</label>

                          <div>
                              <a href="javascript:;" class="file">添加附件
                                  <input type="file" class="form-control" id="inputFile"
                                         multiple="multiple"></a><span style="padding-left: 10px">最多添加5个附件，每个大小不超过10M 上传遇到问题</span>
                          </div>
                      </div>--%>


                    <%-- <div class="form-group">
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="deadlineTime" class="control-label" style="display:inline">deadline</label>
                            </div>
                            <div class="col-lg-4">
                                <input type="date" class="form-control" id="deadlineTime" name="taskDeadlineTime"
                                       min="2015-09-09"></div>

                        </div>
                    </div> --%>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success col-lg-4">Post</button>
                    </div>
                </form>
            </div>
            <div class="col-lg-4">
            </div>
        </div>
        <div class="row">
            <table class="table table-bordered table-hover">
                <caption class="text-center"> My Posted Task</caption>
                <thead>
                <tr>
                    <td>ID</td>
                    <td>TaskName</td>
                    <td>TaskDescription</td>
                    <td>TaskSolution</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${myPostedCrowdSourcingTaskList }" var="tempCrowdSourcingTask">
                    <tr>
                        <td><c:out value="${tempCrowdSourcingTask.taskId}"></c:out></td>
                        <td><c:out value="${tempCrowdSourcingTask.taskName}"></c:out></td>
                        <td><c:out value="${tempCrowdSourcingTask.taskDescription}"></c:out></td>
                        <td>
                            <a href="myPostedTaskDetail.do?taskId=<c:out value="${tempCrowdSourcingTask.taskId}"></c:out>">Solution</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>


</div>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

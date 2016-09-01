<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/22
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<!-- saved from url=(0045)http://www.treemolabs.com/dashboard/login.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-1.11.3.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/header.js"></script>
    <script type="text/javascript" src="../../static/js/register.js"></script>
    <title>register</title>


<head>

<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>

</header>
<div class="container-fluid" style="background: url('../../static/images/bg-login-top.png') repeat #fff;">
    <div class="container" style="margin-top: 40px;margin-bottom:40px; clear:both;">
        <div class="row">
            <div class="col-lg-8">
                <h1>CrowdSourcing Anything </h1>

                <p>we are the best team </p>
            </div>
            <div class="col-lg-4">
                <form class="form-horizontal" method="post" id="regForm"
                      action="${pageContext.request.contextPath}/register/register.do" onsubmit="return validate()">
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-3 control-label">Email</label>

                        <div class="col-lg-9">
                            <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email"
                                   onchange="check('email')" required="required" data-toggle="popover"
                                   data-placement="top" data-title="请输入正确的地址" data-trigger="manual"
                                   data-content="正确的地址格式是；；；；">
                            <span class="sr-only" id="spanEmail"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-3 control-label">Password</label>

                        <div class="col-lg-9">
                            <input type="password" name="password" class="form-control" id="inputPassword"
                                   placeholder=" Password" onchange="check('password')" required data-toggle="popover"
                                   data-placement="top" data-title="请输入安全度合适的密码" data-trigger="manual"
                                   data-content="密码至少要6位吧">
                            <span class="sr-only" id="spanPassword"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword-Confirm" class="col-lg-3 control-label">Password</label>

                        <div class="col-lg-9">
                            <input type="password" class="form-control" id="inputPassword-Confirm" required="required"
                                   placeholder=" Confirm Password" onchange="check('confirm')" data-toggle="popover"
                                   data-placement="top" data-title="密码要一致" data-trigger="manual"
                                   data-content="请和上面的密码保持一致">
                            <span class="sr-only" id="spanConfirm"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCheckCode" class="col-lg-3 control-label">CheckCode</label>

                        <div class="col-lg-9">
                            <div class="input-group">
                                <input type="text" class="form-control" id="inputCheckCode"
                                       onchange="check('checkCode')" placeholder="CheckCode" required="required"
                                       data-toggle="popover" data-placement="top" data-title="验证码" data-trigger="manual"
                                       data-content="请检查验证码是否正确,点击图片刷新">
                                <span class="input-group-addon">
                                    <img src="${pageContext.request.contextPath}/code.do" id="checkCode" alt="checkCode"
                                         style="cursor: pointer;" onclick="changeImg()">
                                </span>
                                <span class="sr-only" id="spanCheckCode"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-lg-9">
                            <button type="submit" class="btn btn-success col-lg-12" id="submit">Sign up</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>

</html>

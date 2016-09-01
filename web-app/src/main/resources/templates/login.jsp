<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/7
  Time: 15:54
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
    <title>login</title>

    <script type="text/javascript" src="../../static/js/login.js"></script>

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
                <form class="form-horizontal" method="post" id="logForm"
                      action="${pageContext.request.contextPath}/login.do" onsubmit="return validate()">
                    <div class="form-group">

                        <label for="inputEmail" class="col-lg-3 control-label">Email</label>

                        <div class="col-lg-9">
                            <input type="email" name="userEmail" class="form-control" id="inputEmail"
                                   placeholder="Email"
                                   onchange="check('email')" required="required" data-toggle="popover"
                                   data-placement="top" data-title="请输入正确的地址" data-trigger="manual"
                                   data-content="正确的地址格式是；；；；">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-3 control-label">Password</label>

                        <div class="col-lg-9">
                            <input type="password" name="userPassword" class="form-control" id="inputPassword"
                                   placeholder=" Password" onchange="check('password')" required data-toggle="popover"
                                   data-placement="top" data-title="请输入安全度合适的密码" data-trigger="manual"
                                   data-content="密码至少要6位吧">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-lg-9">
                            <button type="submit" class="btn btn-success col-lg-12" id="submit">Sign in</button>
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

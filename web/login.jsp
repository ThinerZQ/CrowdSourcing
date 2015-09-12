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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>register</title>

    <script type="text/javascript">
        // $("[data-toggle='tooltip']").tooltip();
        $("[data-toggle='popover']").popover();
        //alert($("[data-toggle='popover']").state);
        var emailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        function changeImg() {
            var imgSrc = $("#checkCode");
            var src = imgSrc.attr("src");
            //alert(src)
            imgSrc.attr("src", chgUrl(src));
        }
        //时间戳
        //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
        function chgUrl(url) {
            //alert(url.indexOf("?"));
            var timestamp = (new Date()).valueOf();
            if ((url.indexOf("?") >= 0)) {

                url = url.substr(0, url.indexOf("?")) + "?timestamp=" + timestamp;
            } else {
                url = url + "?timestamp=" + timestamp;
            }
            return url;
        }
        function check(str) {
            //alert("sub");
            var input = $("#" + str);
            var flag = false;
            if (str == "email") {
                var emailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
                if (!emailReg.test($("#inputEmail").val())) {
                    // alert("请输入正确的邮箱格式");
                    $("#inputPassword").popover("hide");
                    $("#inputPassword-Confirm").popover("hide");
                    $("#inputCheckCode").popover("hide");
                    $("#inputEmail").popover("show");
                } else {
                    $("#inputEmail").popover("hide");
                    flag = true;
                }
            } else if (str == "password") {
                if ($("#inputPassword").val().length < 6) {
                    //alert(22);
                    $("#inputPassword-Confirm").popover("hide");
                    $("#inputCheckCode").popover("hide");
                    $("#inputEmail").popover("hide");
                    $("#inputPassword").popover("show");
                } else {
                    $("#inputPassword").popover("hide");
                    flag = true;
                }

            }
            return flag;
        }
        function validate() {
            var arr = ["email", "password"];
            var i = 0;
            submitOK = true;
            while (i <= 1) {
                if (!check(arr[i])) {
                    //alert(arr[i]+" wrong!");
                    submitOK = false;
                    break;
                }
                i++;
            }
            if (submitOK) {
                //alert("提交成功！");
                return true;
            }
            else {
                //alert("提交失败");
                return false;
            }
        }
        $(function () {

        })
    </script>

<head>

<body>
<header>
    <nav class="navbar navbar-inverse">
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
                    <a class="navbar-brand" href="#">CrowdSourcing</a>
                </div>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search CrowdSourcing">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right" style="margin-top: 10px;">
                    <li>
                        <button type="button" class="btn btn-success" style="color: white;margin-right: 10px;">Sign up
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default" style="color: black">Sign in</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container-fluid" style="background: url('images/bg-login-top.png') repeat #fff;">
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
                            <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email"
                                   onchange="check('email')" required="required" data-toggle="popover"
                                   data-placement="top" data-title="请输入正确的地址" data-trigger="manual"
                                   data-content="正确的地址格式是；；；；">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-3 control-label">Password</label>

                        <div class="col-lg-9">
                            <input type="password" name="password" class="form-control" id="inputPassword"
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
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: 强
  Date: 2015/9/1
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>发布工作</title>
</head>

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
    <div class="container">
        <div class="row bg-danger">
            我们郑重承诺;不收取您的任何佣金，请放心发布
        </div>
        <div class="row">
            <div class="col-lg-8">
                <form class="form">
                    <div class="form-group">
                        <label for="inputTitle" class="control-label">简单描述你的需求：</label>

                        <div>
                            <input type="email" class="form-control" id="inputTitle"
                                   placeholder="一句话描述你的需求，例如：写一篇关于众包的文章">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhoneNumber" class="control-label">请确认您的联系方式，我们才知道怎么联系您噢</label>

                        <div>
                            <input type="tel" class="form-control" id="inputPhoneNumber" placeholder="请输入手机号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCheckCode" class="control-label sr-only">checkCode</label>

                        <div>
                            <input type="number" class="form-control" id="inputCheckCode"
                                   placeholder="请输入你收到的手机验证码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDetail" class="control-label">说说您的具体要求</label>

                        <div>
                            <input class="form-control" id="inputDetail" placeholder="具体的描述一下">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-success">Sign up</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4">


            </div>
        </div>
    </div>
</div>
</body>
</html>

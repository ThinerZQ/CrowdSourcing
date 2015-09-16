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

    <style type="text/css">
        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }

        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }

        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }

    </style>

</head>

<body>
<header>
    <nav class="navbar navbar-inverse" style="margin-bottom: 0px">
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
        <div class="row bg-danger" style="height: 50px;margin-bottom: 5px">
            <h3 style="margin-bottom: 10px" class="text-center"> 我们郑重承诺;不收取您的任何佣金，请放心发布</h3>
        </div>
        <div class="row">
            <div class="col-lg-8" style="padding-left: 0px">
                <form class="form" action="${pageContext.request.contextPath}/post.do">
                    <div class="form-group">
                        <label for="inputTitle" class="control-label">简单描述你的需求：</label>

                        <div>
                            <input type="text" class="form-control" id="inputTitle" name="title"
                                   placeholder="一句话描述你的需求，例如：写一篇关于众包的文章" style="width: 50%">
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
                        <label for="inputDetail" class="control-label">说说您的具体要求</label>
                        <div>
                        <textarea class="form-control" id="inputDetail" placeholder="具体的描述一下"
                  name="descriptionsById"
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


                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="deadlineTime" class="control-label" style="display:inline">截止时间</label>
                            </div>
                            <div class="col-lg-4">
                                <input type="date" class="form-control" id="deadlineTime" name="deadlineTime"
                                       min="2015-09-09"></div>

                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success col-lg-4">Post</button>
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

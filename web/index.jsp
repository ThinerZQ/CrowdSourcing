<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/22
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!-- saved from url=(0045)http://www.treemolabs.com/dashboard/login.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>CrowdSourcing</title>
    <script>
        $(function () {
            $("#myCarousel").carousel();
        });
       function signUp(){
           window.location="register.jsp";
       }
        function signIn(){
            window.location="login.jsp";
        }
        function post(){
            window.location="post.jsp";
        }
    </script>


<head>

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

                    <c:choose>
                        <c:when test="${empty sessionScope.get('user')}">
                            <li>
                                <button type="button" class="btn btn-success" style="color: white;margin-right: 10px;" onclick="signUp()">sign up</button>
                            </li>
                            <li>
                                <button type="button" class="btn btn-default" style="color: black" onclick="signIn()">Sign in</button>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li style="color: red;">
                                    <c:set var="user" value="${sessionScope.get('user')}" scope="page"></c:set>
                                welcome : <c:out value="${user.userName}"></c:out>
                            </li>
                            <li style="color: red;">
                                <button type="button" class="btn btn-default" style="color: black" onclick="post()">Post</button>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container-fluid" style="background: url('images/bg-login-top.png') repeat #fff;">

    <div class="row">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active container">
                    <img src="images/slide1.png" alt="First slide">

                    <div class="carousel-caption">标题 1</div>
                </div>
                <div class="item container">
                    <img src="images/slide2.png" alt="Second slide">

                    <div class="carousel-caption">标题 2</div>
                </div>
                <div class="item container">
                    <img src="images/slide3.png" alt="Third slide">

                    <div class="carousel-caption">标题 3</div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <ul id="myTab" class="nav nav-tabs">
                <li class="active">
                    <a href="#home" data-toggle="tab">
                        Home
                    </a>
                </li>
                <li><a href="#orginTask" data-toggle="tab">原始任务</a></li>
                <li><a href="#judgeTask" data-toggle="tab">判断任务</a></li>
                <li><a href="#decomposeTask" data-toggle="tab">分解任务</a></li>
                <li><a href="#solveTask" data-toggle="tab">解决任务</a></li>
                <li><a href="#voteTask" data-toggle="tab">投票任务</a></li>
                <li><a href="#mergeTask" data-toggle="tab">合并任务</a></li>
                <li class="dropdown">
                    <a href="#" id="myTabDrop1" class="dropdown-toggle"
                       data-toggle="dropdown">其他任务
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                        <li><a href="#otherTask1" tabindex="-1" data-toggle="tab">其他任务1</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">其他任务2</a></li>
                    </ul>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <p>${allJudgeTask.get(0).task.title}</p>
                </div>
                <div class="tab-pane fade" id="orginTask">
                    <div class="panel panel-primary panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">写一篇关于众包的文章</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    发布者：<span>郑强</span>
                                </div>
                                <div class="col-lg-6 text-right">
                                    过期时间：
                                    <span> 2015-11-11</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    请写一篇关于众包的文章，不少于5000字。请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-danger">
                                    资格要求
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验必要要3年写作经验
                                </div>
                            </div>

                        </div>
                        <div class="panel-footer text-right">
                            <span class="text-danger">1000元</span>
                            <a href="#" class="btn btn-success" role="button">详细</a>
                        </div>
                    </div>
                    <div class="panel panel-primary panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">写一篇关于众包的文章</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    发布者：<span>郑强</span>
                                </div>
                                <div class="col-lg-6 text-right">
                                    过期时间：
                                    <span> 2015-11-11</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    请写一篇关于众包的文章，不少于5000字。请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字请写一篇关于众包的文章，不少于5000字
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <span class="text-danger">1000元</span>
                            <a href="#" class="btn btn-success" role="button">详细</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 container">
                            <ul class="pagination pagination-lg">
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
                </div>
                <div class="tab-pane fade" id="judgeTask">
                    <div class="panel panel-primary panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">写一篇关于众包的文章</h3>
                        </div>
                        <div class="panel-body">
                            描述
                        </div>
                        <div class="panel-footer">
                            0.5元
                        </div>
                    </div>

                </div>
                <div class="tab-pane fade" id="decomposeTask">
                    <p>decompose task</p>
                </div>
                <div class="tab-pane fade" id="solveTask">
                    <p>solve task
                    </p>
                </div>
                <div class="tab-pane fade" id="voteTask">
                    <p>vote task
                    </p>
                </div>
                <div class="tab-pane fade" id="mergeTask">
                    <p>merge task
                    </p>
                </div>
                <div class="tab-pane fade" id="otherTask1">
                    <p>other task1
                    </p>
                </div>
            </div>
        </div>
    </div>

</div>
</body>

</html>

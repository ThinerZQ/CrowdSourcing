<%--
  Created by IntelliJ IDEA.
  User: 强
  Date: 2016/2/5
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <img src="../../static/images/slide1.png" alt="First slide">

                <div class="carousel-caption">title 1</div>
            </div>
            <div class="item container">
                <img src="../../static/images/slide2.png" alt="Second slide">

                <div class="carousel-caption">title 2</div>
            </div>
            <div class="item container">
                <img src="../../static/images/slide3.png" alt="Third slide">

                <div class="carousel-caption">title 3</div>
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;</a>
    </div>
</div>
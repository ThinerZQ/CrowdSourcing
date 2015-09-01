<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/21
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!-- saved from url=(0045)http://www.treemolabs.com/dashboard/login.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>ZhengShouZi</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            if (!($.browser.safari || $.browser.mozilla)) {
                $("form").hide();
            }
        });
    </script>

    <style type="text/css">
        * {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        }

        body {
            margin: 0;
            pading: 0;
            color: #fff;
            background: url('images/bg-login.png') repeat #1b1b1b;
            font-size: 14px;
            text-shadow: #050505 0 -1px 0;
            font-weight: bold;
        }

        li {
            list-style: none;
        }

        #dummy {
            position: absolute;
            top: 0;
            left: 0;
            border-bottom: solid 3px #777973;
            height: 250px;
            width: 100%;
            background: url('images/bg-login-top.png') repeat #fff;
            z-index: 1;
        }

        #dummy2 {
            position: absolute;
            top: 0;
            left: 0;
            border-bottom: solid 2px #545551;
            height: 252px;
            width: 100%;
            background: transparent;
            z-index: 2;
        }

        #login-wrapper {
            margin: 0 0 0 -160px;
            width: 320px;
            text-align: center;
            z-index: 99;
            position: absolute;
            top: 0;
            left: 50%;
        }

        #login-top {
            height: 120px;
            padding-top: 140px;
            text-align: center;
        }

        label {
            width: 70px;
            float: left;
            padding: 8px;
            line-height: 14px;
            margin-top: -4px;
        }

        input.text-input {
            width: 200px;
            float: right;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            background: #fff;
            border: solid 1px transparent;
            color: #555;
            padding: 8px;
            font-size: 13px;
        }

        input.button {
            float: right;
            padding: 6px 10px;
            color: #fff;
            font-size: 14px;
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#a4d04a), to(#459300));
            text-shadow: #050505 0 -1px 0;
            background-color: #459300;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            border: solid 1px transparent;
            font-weight: bold;
            cursor: pointer;
            letter-spacing: 1px;
        }

        input.button:hover {
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#a4d04a), to(#a4d04a), color-stop(80%, #76b226));
            text-shadow: #050505 0 -1px 2px;
            background-color: #a4d04a;
            color: #fff;
        }

        div.error {
            padding: 8px;
            background: rgba(52, 4, 0, 0.4);
            -moz-border-radius: 8px;
            -webkit-border-radius: 8px;
            border-radius: 8px;
            border: solid 1px transparent;
            margin: 6px 0;
        }
    </style>
</head>

<body id="login">

<div id="login-wrapper" class="png_bg">
    <div id="login-top">
        <img src="images/logo.png" alt="Treemo Labs Dashboard" title="Powered By Treemo Labs">
    </div>

    <div id="login-content">
        <form method="post" action="/register/register.do">
            <p>
                <label>Username</label>
                <input value="" name="username" class="text-input" type="text">
            </p>
            <br style="clear: both;">

            <p>
                <label>Password</label>
                <input name="password" class="text-input" type="password">
            </p>
            <br style="clear: both;">

            <p>
                <input class="button" type="submit" value="Sign In">
                <input class="button" type="button" value="Sign Up" style="float:left;"
                       onclick="location.href='register.jsp'">
            </p>

        </form>
    </div>
</div>
<div id="dummy"></div>
<div id="dummy2"></div>


</body>
</html>

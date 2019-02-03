<%--
  Created by IntelliJ IDEA.
  User: lsz09
  Date: 2018/6/10
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <title>绝地求生</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-pubg.css"/>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>
<body>

<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.html" class="navbar-brand">PUBG</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav  navbar-right">
                <li><a href="index.html">绝地首页</a></li>
                <li><a href="strategy.html">游戏攻略</a></li>
                <li><a href="news.html">新闻中心</a></li>
                <li><a href="index.html#course">精彩视频</a></li>
                <li><a href="login.html">用户登陆</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->
<!--home-->
<section id="home">
    <div class="lvjing">
        <div class="container">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-10">
                    <h1>绝地求生</h1>
                    <p>
                        100人同时抢夺资源 只为成为最后的生存者<br/>
                        究竟谁能大吉大利 今晚吃鸡
                    </p>
                </div>
                <div class="col-md-1">
                </div>
            </div>
        </div>
    </div>
</section>
<!--导航-->
<!--文章显示-->
<section id="page">
    <div class="container">
        <div class="row">
            <div class="col-md-12" style="text-align: center">
                <h1>${article.title}</h1>
            </div>
            <br/>
            <div class="col-md-12 center-block" style="text-align: center">
                <div class="col-md-5">
                    <h4>${article.username}</h4>
                </div>
                <div class="col-md-6">
                    <h4>${article.time.substring(0,16)}</h4>
                </div>
            </div>
            <hr/>
            <div class="col-md-12">
                ${article.content}
            </div>
        </div>
    </div>
</section>
<!--文章显示-->
<!--footer-->
<footer>
    <div class="container footer">
        <div class="row">
            <div class="col-md-12">
                <p>岭南师范学院&nbsp;|&nbsp;©2018&nbsp;KADIMA</p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->
</body>
</html>
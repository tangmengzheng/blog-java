<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="content-type">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <meta name="baidu-site-verification" content="mBejpWqLCn" />
        <title><%= title %></title>

        <link href="/public/css/bootstrap.min.css" rel="stylesheet">
        <link href="/public/css/fancybox/jquery.fancybox-1.3.1.css" rel="stylesheet">
        <script type = "text/javascript" src = "/public/js/jquery/jquery.min.js"></script>
        <script type = "text/javascript" src = "/public/js/validation/jquery.validate.min.js"></script>
        <script type = "text/javascript" src = "/public/js/fancybox/jquery.fancybox-1.3.1.js"></script>
        <script type = "text/javascript" src = "/public/js/global.js"></script>
    </head>
    <body  style="">
        <div class="container">
            <div class = "row">
                <div class = "col-sm-1"></div>

                <div class = "col-sm-10">
                    <div>
                        <ul class="nav nav-tabs" style = "font-size:20px">
                            <li> <a href='/index'>主页</a></li>
                            <li><a href='/about'>关于</a></li>
                            <li style = "margin-right:10px"><a href="/article/writeArticle" >写博客</a></li>
                            <li style = "margin-right:10px"><a href="/logout" > 退出</a></li>
                            <li style = "margin-right:10px"><a href="/login" >登录</a></li>
                        </ul>
                    </div>





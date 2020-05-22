<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="minimal-ui,width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <title>404</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .container{
            width: 100%;
            height: 100%;
            background-color: #f5f6fb;
            position: relative;
        }
        .container>*{
            position: absolute;
        }
        .frame1{
            width: 240px;
            height: 240px;
            background-color: #ffffff;
            top: 10%;
            left: 50%;
            margin-left: -120px;
            box-shadow: 30px 30px 25px #e7eaf3;
        }
        .frame2{
            width: 220px;
            height: 220px;
            top: 10%;
            left: 50%;
            margin-left: -110px;
            margin-top: 10px;
            background: linear-gradient(to bottom right, #b7bfcc, #ffffff);
        }
        .frame3{
            width: 180px;
            background-color: #f1f4f9;
            top: 10%;
            left: 50%;
            margin-left: -90px;
            margin-top: 30px;
            color: #d7dbe4;
            text-align: center;
            font-size: 70px;
            font-weight: bolder;
        }
        .frame3>.left{
            float: left;
        }
        .frame3>.right{
            float: right;
        }
        .btn{
            display: block;
            width: 120px;
            bottom: 40px;
            left: 50%;
            margin-left: -60px;
            border-radius: 25px;
            color: #ffffff;
            background-color: #6891f2;
            height: 50px;
            line-height: 50px;
            text-align: center;
            text-decoration: none;
        }
        .text1,.text2{
            width: 100%;
            text-align: center;
        }
        .text1{
            bottom: 160px;
            color: #3e3d3f;
            font-size: 20px;
        }
        .text2{
            bottom: 130px;
            color: #7f7f7f;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="frame1"></div>
        <div class="frame2"></div>
        <div class="frame3">
            <span class="left">4</span>
            <span class="center">0</span>
            <span class="right">4</span>
        </div>
        <div class="text1">页面没了</div>
        <div class="text2">找不到了，可能被遗忘在哪了</div>
        <a class="btn" href="${pageContext.request.contextPath}/">
            首页
        </a>
    </div>
</body>
</html>

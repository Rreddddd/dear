<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>祝我最爱的人20岁生日快乐</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/birthday/twenty/view.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/alert.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/view.js?n=<%=Math.random()%>"></script>
</head>
<body>
<div class="wrapper">
    <div class="bg-img">
        <div class="velas">
            <div class="fuego"></div>
            <div class="fuego"></div>
            <div class="fuego"></div>
            <div class="fuego"></div>
            <div class="fuego"></div>
        </div>
        <div style="width: 195px;margin: 0 auto;">
            <img src="${pageContext.request.contextPath}/image/srkl.gif?n=<%=Math.random()%>"/>
        </div>
    </div>
    <div class="happy">
        <img src="${pageContext.request.contextPath}/image/HappyBirthday.png"/>
    </div>
    <div class="button-style1 pike" data-type="true">
        <a href="javascript:void(0)" class="lk1">
            <div class="link1">
                <div class="bt1">
                    我很喜欢
                </div>
            </div>
        </a>
    </div>
    <div class="button-style2 pike" data-type="false">
        <a class="lk2">
            <div class="link2">
                <div class="bt1">
                    我不喜欢
                </div>
            </div>
        </a>
    </div>
    <ul class="bg">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
    <audio src="${pageContext.request.contextPath}/music/birthday.mp3" autoplay loop>
        您的浏览器不支持 audio 标签。
    </audio>
</div>
</body>
</html>
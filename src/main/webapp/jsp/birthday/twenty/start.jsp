<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>祝我最爱的人20岁生日快乐</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/birthday/twenty/start.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/alert.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/start.js"></script>
</head>
<body>
    <%if(Calendar.getInstance().get(Calendar.DATE)<2){%>
    <div class="wait">
        <span class="time">00:00:00</span>
        <br/>
        <span class="desc">来早了还没到呢</span>
    </div>
    <%}%>
    <div class="wrapper">
        <div class="container">
            <h1>生日快乐</h1>
            <form>
                <input id="userName" name="userName" type="text" placeholder="代号" value="我的宝贝"/>
                <input id="password" name="password" type="password" placeholder="密码"/>
                <button type="button" id="login">进入</button>
            </form>
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
    </div>
</body>
</html>
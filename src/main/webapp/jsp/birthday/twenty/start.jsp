<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>宝贝你一定要好好的</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/elf.css?n=<%=Math.random()%>"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/birthday/twenty/start.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/alert.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/elf.js?n=<%=Math.random()%>"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/birthday/twenty/start.js"></script>
</head>
<body>
    <div class="wait">
        <span class="time">我好怕好怕没有你我好迷茫你我之间那么多的叮嘱还一个没有实现你给我打的那么多预防针我都还没有机会表现我都还没有和你表白还没有牵过你的手你怎能如此对我</span>
    </div>
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
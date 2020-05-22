<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="minimal-ui,width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <title>在线</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font/iconfont.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/im/index.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/websocket.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/im/index.js"></script>
</head>
<body>
    <div class="container">
        <div class="wrapper">
            <div class="chat-list">
                <div class="chat-list-wrapper">
                    <div>

                    </div>
                </div>
            </div>
            <div class="chat-tools">
                <div class="chat-tools-wrapper">
                    <div class="chat-tools-toggle voice">
                        <i class="dear-font setting1"></i>
                    </div>
                    <div class="chat-tools-content">
                        <input type="text" placeholder="想好了再说，不可撤回"/>
                    </div>
                    <div class="chat-tools-emoji">
                        <i class="dear-font im-emoji1"></i>
                    </div>
                    <div class="chat-tools-send">
                        <i class="dear-font im-send"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

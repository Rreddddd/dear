<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>荣荣的个人博客</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css?n=<%=Math.random()%>"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/elf-scroll.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
    <header class="init">
        <div class="header-wrapper">
            <a class="logo" href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/image/header_log.png" alt="图片没了"/>
                <span>荣荣的个人博客</span>
            </a>
            <ul class="nav">
                <li><a class="active" href="${pageContext.request.contextPath}/">网站首页</a></li>
            </ul>
        </div>
    </header>
    <article>
        <div class="article-container">
            <div class="article-gallery">
                <div class="article-gallery-list"></div>
                <div class="article-gallery-sorter"></div>
            </div>
            <div class="article-wrapper">
                <div class="article-wrapper-left">
                    <div class="portal shortcut"></div>
                </div>
                <div class="article-wrapper-right">
                    <div class="portal links">
                        <div class="title">
                            <div>友情链接</div>
                        </div>
                        <div class="wrapper">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="link-tag">
                                                <a>百度一下</a>
                                                <div class="circle"></div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="link-tag">
                                                <a>腾讯游戏</a>
                                                <div class="circle"></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div class="link-tag">
                                                <a>荣荣的个人博客</a>
                                                <div class="circle"></div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </article>
    <footer>
        <div class="footer-wrapper">
            <div class="service">
                <div class="service-left">
                    <div class="logo">
                        <span>欣欣向</span>荣
                    </div>
                    <ul class="wxInfo clearFloat">
                        <li>
                            <img src="${pageContext.request.contextPath}/image/qr_default.jpg" alt="图片不见了"/>
                            <span>微信公众号(暂无)</span>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/image/qr_wx_member.png" alt="图片不见了"/>
                            <span>我的微信</span>
                        </li>
                    </ul>
                </div>
                <div class="service-right">
                    <div class="service-right-list">
                        <h5>子项目集</h5>
                        <ul>
                            <li><a>荣荣的生日项目</a></li>
                            <li><a>占个位置</a></li>
                            <li><a>。。。。</a></li>
                            <li><a>。。。。</a></li>
                            <li><a>。。。。</a></li>
                        </ul>
                    </div>
                    <div class="service-right-list">
                        <h5>关于我们</h5>
                        <ul>
                            <li><a>网站简介</a></li>
                            <li><a>友情链接</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <ul class="links clearFloat">
                    <li>博客日记</li>
                    <li><a>网站举报</a></li>
                    <li><a>链接一</a></li>
                    <li><a>链接二</a></li>
                </ul>
                <div class="description">
                    Copyright © www.0512.red 荣荣的监护人 All Rights Reserved. 备案号：<a href="http://www.beian.miit.gov.cn" target="_blank">渝ICP备18013191号-1</a>
                </div>
            </div>
        </div>
    </footer>

</body>
</html>

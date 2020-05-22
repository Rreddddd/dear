<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<%
    Calendar calendar=Calendar.getInstance();
    if(calendar.get(Calendar.MONTH)+1==5 && calendar.get(Calendar.DATE)+1==20){
        request.getRequestDispatcher("/jsp/birthday/twenty/start_520.jsp").forward(request,response);
        return;
    }
%>
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
    <style>
        .wait{
            padding: 20px 22px 120px 22px;
            text-align: left;
            overflow: auto;
        }
        .chuoyichuo{
            position: fixed;
            bottom: 60px;
            z-index: 555;
            color: red;
            padding: 0 100px;
            font-size: 14px;
            width: 100%;
            text-align: center;
        }
        .chuoyichuo>div{
            padding: 10px 0;
            background-color: #ffffff;
            border-radius: 5px;
            position: relative;
            box-shadow: 0 0 10px #eeeeee;
        }
        .chuoyichuo>div:active{
            box-shadow: 0 0 10px #dddddd;
        }
        .chuoyichuo>div>img{
            position: absolute;
            width: 40px;
            height: 20px;
        }
        .infos{
            position: fixed;
            z-index: 555;
            bottom: 10px;
            font-weight: bolder;
            right: 10px;
            text-align: right;
            color: red;
        }
        .number{
            position: fixed;
            top: 5px;
            left: 5px;
            z-index: 1111111111;
            color: #cd856c;
        }
    </style>
    <script type="application/javascript">
        $(function(){
            var clickState=false;
            $(".chuoyichuo>div").on("click",function(){
                if(!clickState){
                    clickState=true;
                    $.ajax({
                        type : "post",
                        url : "/message/leave/",
                        data : {
                            content : "dear戳了戳"
                        },
                        dataType : "json",
                        success : function(msg){
                            if(msg.errorCode===0){
                                $.alert({
                                    title : "消息",
                                    content : "知道你还健在我也能稍微安心一点了",
                                    btn : "",
                                    closeMil : 2000
                                });
                            }else{
                                $.alert({
                                    title : "消息",
                                    content : "天意如此，服务器问题没收到",
                                    btn : "再戳一戳"
                                });
                            }
                            clickState=false;
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
<div class="wait">
    <%--        <span class="time">我好怕好怕没有你我好迷茫你我之间那么多的叮嘱还一个没有实现你给我打的那么多预防针我都还没有机会表现我都还没有和你表白还没有牵过你的手你怎能如此对我</span>--%>
    <%--        <span class="time">--%>
    <%--            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;不知道你看不看得见又不知道你微信号是不是本人如果你看见这个了给我回个信或者留个言--%>
    <%--            好让我知道你还在，我知道前段时间对你打击有点大当我知道情况后我是真怕你有什么事，--%>
    <%--            我要求不高只要你还健在，我每天关灯睡觉时很怕在黑夜中遇到你我不想在那个场景见到你，--%>
    <%--            我可以透支一切只希望你好好的，不管多久我都能等，如果你再也看不见这段话了我会很难过--%>
    <%--            我也不记得上次是什么时候哭过了至少也有个十多年了吧可能我真的是没心的人--%>
    <%--            我都感觉我以另类的方式见你都不一定能哭出来，我再也做不到视你不见的那种胸怀了--%>
    <%--            这也是我应得的就应该以其人之道不然对不起你那么多年的心意，不知道说什么了也没人倾诉--%>
    <%--            可能你都忘记这个地方了不过我想你明年快生日的应该时候会来这里时间过得真慢如果明年还没答复--%>
    <%--            我也就明白了，你最好提前给我个消息不然我没心思给你21岁的生日准备。--%>
    <%--            <br/>--%>
    <%--            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果不想和我说话点一点戳一戳也行就当是为了让我睡得安心。--%>
    <%--            对了签到和签退都先欠着不然对面是个陌生人我觉得怪怪的。--%>
    <%--        </span>--%>
    <div class="time">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这是第三次给你写了也不知道你前面两次有没有看见如果看见了连动一动手指都不愿意吗，
        你是不是想学我那套悄无声息的退出如果是的话不就等于变相肯定了此种做法，有时候我在想我要不要学
        别人那样死皮赖脸软磨硬泡的让你改变主意，你不得不相信命就是这样缘分不够，我也不想信这个可是这确实
        是目前最能让我信服的解释，我也不要什么缘分不缘分了你安然无恙就可以了，这么多年也没让你开心过几天
        大部分都是一些不好的回忆每每想到这里我都很后悔何德何能让你如此委屈。
        <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;也不知道你现在如何过得怎样，也不知道你有没有平复下来，也不知道你现在是个什么心态，
        不管你做出什么决定我都认了我也不想让你烦心了你承受的够多了不必再照顾我的心情了，说了这么多不是想表达
        我已经看开了而是我在慢慢适应。每次想给你写东西都是准备写个千八百字的长文可是心有余而力不足，有些话现在
        给你说又怕你更心烦，不知道要说什么了可能我还会给你再写几次，我就不要求你反馈给我了因为每天期待你能看见并且
        回信确实太累了还不如就当你看不见，就当是我在倾诉，如果你真的看见了以后还来找我说话的话也要装成没看过一样。
        <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最后不管怎样希望你能开心每天，不要熬夜不要熬夜不要熬夜，按时吃东西不要吃泡面了不要吃辣，
        我最担心你的胃你一定要忌口你这么大个人了要学会照顾好自己。
    </div>
</div>
<%--    <div class="chuoyichuo">--%>
<%--        <div>--%>
<%--            戳一戳--%>
<%--            <img src="${pageContext.request.contextPath}/image/chuoyichuo.gif" alt="图片没了"/>--%>
<%--        </div>--%>
<%--    </div>--%>
<div class="infos">
    2020-04-01 10:44 AM
    <br/>
    lccccccccc
</div>
<div class="number">
    No.3
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
$(function(){
    $.openElf();
    var userName=$("#userName");
    var password=$("#password");
    $("#login").on("click",function(){
        var userName_val=userName.val().trim();
        if(!userName_val){
            $.alert({
                title : "笨",
                content : "连名字都懒得输入吗?我的宝贝"
            });
            return;
        }
        var password_val=password.val().trim();
        if(!password_val){
            $.alert({
                title : "笨",
                content : "连密码都懒得输入吗?没有提示回去再想，不要来问我我睡着了"
            });
            return;
        }
        $.ajax({
            type : "post",
            url : "/dear/birthday/twenty/check/",
            data : {
                userName : userName_val,
                password : password_val
            },
            dataType : "json",
            success : function(msg){
                if(msg.code===0){
                    if(msg.errorCount===0){
                        $.alert({
                            title : "可以呀",
                            content : "很聪明!",
                            btn : "我很意外"
                        });
                    }else{
                        $.alert({
                            title : "运气不错",
                            content : "你以为我会夸奖你吗!",
                            btn : "醒一醒"
                        });
                    }
                    setTimeout(function(){
                        window.location.href="/dear/birthday/twenty/pageIn/";
                    },2000);
                }else if(msg.code===1){
                    if(msg.errorCount===1){
                        $.alert({
                            title : "回答错误",
                            content : "第一次选择原谅你，提示：全是汉语拼音"
                        });
                    }else if(msg.errorCount===2){
                        $.alert({
                            title : "再次回答错误",
                            content : "第二次喽！你的每次选择我都记录在数据库里等下我就去看！哼哼哼，提示：基本每天都在说"
                        });
                    }else if(msg.errorCount===3){
                        $.alert({
                            title : "还是回答错误",
                            content : "第三次了！太让我失望了！！！！！给你换一个简单的密码，提示：我要求你叫我什么，要是再答错的话。。。。。。。。"
                        });
                    }
                }else if(msg.code===2){
                    if(msg.errorCount===4){
                        $.alert({
                            title : "哎哎哎",
                            content : "你没救了，提示：已经换了钥匙了现在是两个汉字的拼音"
                        });
                    }else if(msg.errorCount===5){
                        $.alert({
                            title : "拜拜",
                            content : "不想再理你了"
                        });
                    }else if(msg.errorCount===6){
                        $.alert({
                            title : "再见",
                            content : "还在点"
                        });
                    }else if(msg.errorCount===7){
                        $.alert({
                            title : "无奈",
                            content : "算了,我高估你了，不考验你了！",
                            btn : "耻辱进入",
                            onConfirm : function(){
                                window.location.href="/dear/birthday/twenty/pageIn/";
                            }
                        });
                    }
                }
            }
        });
    });
    var wait=$(".wait");
    if(wait.length>0){
        var waitTime=wait.find(">.time");
        var waitDesc=wait.find(">.desc");
        var now,birthday=1616256000000,minus;
        var day,hour,min,sec;
        var interval=setInterval(function(){
            now=new Date().getTime();
            minus=birthday-now;
            sec=parseInt(minus/1000);
            if(sec>=60){
                min=parseInt(sec/60);
                hour=parseInt(min/60);
                day=parseInt(hour/24);
                waitTime.text("距离下次开启还有："+day+"天 "+addZero(hour%24)+":"+addZero(min%60)+":"+addZero(sec%60));
            }else{
                waitTime.hide();
                waitDesc.text("倒计时 "+sec+" 秒");
                if(sec<=0){
                    wait.hide();
                    clearInterval(interval);
                }
            }
        },1000);
    }
});

function addZero(num){
    if(num<10){
        return "0"+num;
    }
    return num;
}
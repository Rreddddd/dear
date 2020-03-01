$(function(){
    $.alert({
        title : "温馨提示",
        content : "如果没有音乐请检查是否静音如果没有就是因为技术原因只能委屈您随便点击任何地方一下播放音乐",
        btn : "吾很惭愧"
    });
    var audio = $("audio").on("canplay",function(){
        $.alert.close();
    })[0];
    document.ontouchend = function() {
        audio.play();
    };
    $(".pike").on("click",function(){
        var type=$(this).data("type");
        $.ajax({
            type : "post",
            url : "/dear/birthday/twenty/pick/",
            data : {
                type : type
            },
            dataType : "json",
            success : function(msg){
                if(type){
                    if(msg.dontCount===0){
                        $.alert({
                            title : "消息",
                            content : "吾很欣慰",
                            btn : "很好"
                        });
                    }else{
                        $.alert({
                            title : "消息",
                            content : "我已经知道你点过不喜欢了！哼",
                            btn : "还算识相"
                        });
                    }
                    setTimeout(function(){
                        window.location.href="/dear/birthday/twenty/pageIn/";
                    },2000);
                }else{
                    if(msg.dontCount===1){
                        $.alert({
                            title : "消息",
                            content : "再给你一次选择的机会",
                            btn : "给我好好想想"
                        });
                    }else if(msg.dontCount===2){
                        $.alert({
                            title : "消息",
                            content : "很好，故意的是吧",
                            btn : "再给我好好想想"
                        });
                    }else{
                        $.alert({
                            title : "消息",
                            content : "不理你了",
                            btn : "拜拜"
                        });
                    }
                }
            }
        });
    });
});
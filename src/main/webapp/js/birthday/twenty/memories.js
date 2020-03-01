$(function(){
    $.alert({
        title : "温馨提示",
        content : "如果没有音乐请检查是否静音如果没有就是因为技术原因只能委屈您随便点击任何地方一下播放音乐",
        btn : "吾很惭愧"
    });
    var audio = $("audio").on("playing",function(){
        $.alert.close();
    })[0];
    document.ontouchend = function() {
        audio.play();
    };
    $('#dowebok').fullpage({
        'navigation': true,
        'navigationPosition':"left",
        'navigationColor':['#fff'],
    });
    setTimeout(function(){
        $(".lazy").addClass("success");
    },15000);
});
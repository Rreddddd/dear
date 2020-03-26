
$(function(){
    var menuList=$(".menu-list");
    var menuButton=$(".menu-button").on("click",function(){
        var state=menuButton.data("state");
        if(state){
            menuButton.removeClass("active");
            menuList.removeClass("active");
        }else{
            menuButton.addClass("active");
            menuList.addClass("active");
        }
        menuButton.data("state",!state);
    }).data("state",false);
    $(".menu-list>li").on("click",function(){
        menuButton.click();
        switch ($(this).data("type")) {
            case "goHome":
                break;
            case "dearDomain":
                break;
            case "about":
                break;
            case "contract":
                break;
        }
    });
    var $window=$(window);
    $("article").height($window.height()-80);
});
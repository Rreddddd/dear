$(function(){
    var header=$("header");
    var activeScrollTop=0;
    var $window=$(window).on("scroll",function(){
        activeScrollTop=$window.scrollTop();
        if(activeScrollTop>20){
            header.removeClass("init");
        }else{
            header.addClass("init");
        }
    });
    initGallery();
});

function initGallery(){
    var urls=["/image/gallery/1.jpg","/image/gallery/2.jpg","/image/gallery/3.jpg","/image/gallery/4.jpg","/image/gallery/5.jpg"];
    var list=$(".article-gallery-list");
    var sorter=$(".article-gallery-sorter");
    var len=urls.length;
    for(var i=0;i<len;i++){
        list.append('<div class="article-gallery-item">' +
                        '<img src="'+urls[i]+'" alt="图片没了"/>' +
                    '</div>');
        if(i+1===len){
            sorter.append('<div class="article-gallery-sorter-number sorter-end" data-index="'+i+'">' +
                '<span>'+(i+1)+'</span>' +
                '</div>');
        }else{
            sorter.append('<div class="article-gallery-sorter-number" data-index="'+i+'">' +
                '<span>'+(i+1)+'</span>' +
                '</div>');
        }
    }
    var activeIndex;
    var items=list.find(">.article-gallery-item");
    var numbers=sorter.find(">.article-gallery-sorter-number").on("click",function(){
        sliderTo($(this).data("index"));
    });
    var sliderTo=function(index){
        var slider=numbers.eq(index);
        if(!slider.hasClass("active")){
            list.addClass("switching");
            setTimeout(function(){
                list.removeClass("switching");
            },300);
            sorter.find(">.active").removeClass("active");
            slider.addClass("active");
            list.find(">.active").removeClass("active");
            activeIndex=index;
            items.eq(activeIndex).addClass("active");
            reAuto();
        }
    };
    var reAuto=function(){
        if(interval!==undefined){
            clearInterval(interval);
            interval=undefined;
        }
        interval=setInterval(function(){
            if(activeIndex+1>=len){
                sliderTo(0);
            }else{
                sliderTo(activeIndex+1);
            }
        },5000);
    },interval;
    sliderTo(0);
}
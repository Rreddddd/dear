
!function($){

    var template={
        container : $('<div class="reader-container">' +
                        '<div class="reader-wrapper">' +
                            '<div class="cover">' +
                                '<div class="inner1">' +
                                    '<div class="inner2"></div>'+
                                '</div>'+
                                '<div class="temp"></div>'+
                            '</div>'+
                            '<div class="content">' +
                                '的撒大苏打大苏打撒旦卡你的卡萨斯看到了看到了的卡拉大苏打实打实大苏打撒旦打算大苏打实打实打算'+
                            '</div>'+
                        '</div>'+
                    '</div>')
    },$window=$(window);

    var Reader=function(option){
        var self=this;
        self.option=$.extend({},self.defaultOption,option);
        self.jqElement={
            container : template.container.clone()
        };
        self.jqElement.wrapper=self.jqElement.container.find(">.reader-wrapper");
        self.jqElement.cover=self.jqElement.wrapper.find(">.cover");
        self.jqElement.content=self.jqElement.wrapper.find(">.content");
        self.init();
    };

    Reader.prototype={
        init : function(){
            var self=this;
            self.jqElement.container.on("click",function(){
                if(self.jqElement.container.hasClass("opened")){
                    self.jqElement.container.removeClass("opened");
                }else{
                    self.jqElement.container.addClass("opened")
                }
            });
            self.jqElement.content.css({
                "width" : $window.width()-76+"px",
                "height" : $window.height()-76+"px"
            });
            self.jqElement.container.css({
                "width" : self.option.initWidth+"px",
                "height" : self.option.initHeight+"px",
                "left" : self.option.initLeft+"px",
                "top" : self.option.initTop+"px"
            }).appendTo($('body'));
        },
        defaultOption : {
            initWidth : 96,
            initHeight : 128,
            initLeft : 200,
            initTop : 200
        }
    };

    $.extend({
        reader : function(option){
            return new Reader(option);
        }
    });

    $(function(){
        $.reader();
    });
}(jQuery);
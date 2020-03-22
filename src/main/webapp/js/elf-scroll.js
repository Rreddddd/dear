
!function($){

    var Elf=function(){
        var self=this;
        self.jqElement={
            container : $('<div class="elf-scroll">' +
                            '<span>^</span>'+
                        '</div>')
        };
        self.activeScrollTop=0;
        self.clickState=false;
        self.init();
    };

    Elf.prototype={
        init : function(){
            var self=this;
            var $window=$(window).on("scroll.elf_scroll",function(){
                self.activeScrollTop=$window.scrollTop();
                if(self.activeScrollTop<20){
                    self.jqElement.container.removeClass("open");
                }else{
                    self.jqElement.container.addClass("open");
                }
            });
            self.jqElement.container.on("click",function(){
                if(!self.clickState && self.activeScrollTop>0){
                    self.clickState=true;
                    var avg=Math.ceil(self.activeScrollTop/20);
                    var interval=setInterval(function(){
                        self.activeScrollTop-=avg;
                        $window.scrollTop(self.activeScrollTop);
                        if(self.activeScrollTop<=0){
                            self.activeScrollTop=0;
                            self.clickState=false;
                            clearInterval(interval);
                        }
                    },10);
                }
            }).appendTo($('body'));
        }
    };

    $(function(){
        new Elf();
    });
}(jQuery);
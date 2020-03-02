!function($,$alert){

    var template={
        container : $('<div class="elf">' +
                        '<div class="lfr"></div>'+
                    '</div>'),
        message : $('<div class="message-board">' +
                        '<textarea placeholder="想说点什么"></textarea>'+
                        '<button>留言</button>'+
                    '</div>')
    },
    $window=$(window),
    instance;

    var Elf=function(option){
        var self=this;
        self.option=$.extend({},self.defaultOption,option);
        self.option.avg=self.option.size/2;
        self.jqElement={
            container : template.container.clone(),
            message : template.message.clone()
        };
        self.jqElement.lfr=self.jqElement.container.find(">.lfr");
        self.jqElement.messageContent=self.jqElement.message.find(">textarea");
        self.state={
            touchStart : false,
            touchMove : false,
            prepareExpand : false,
            expand : false
        };
        self.offset={
            left : -self.option.avg,
            top : 100
        };
        self.windowInfo={
            height : $window.height(),
            width : $window.width()
        };
        self.windowInfo.vBoundary=self.windowInfo.width/2;
        self.windowInfo.vEdge=self.windowInfo.width-self.option.size;
        self.windowInfo.hEdge=self.windowInfo.height-self.option.size;
        self.init();
    };

    Elf.prototype={
        init : function(){
            var self=this;
            self.jqElement.container.css({
                "width" : self.option.size+"px",
                "height" : self.option.size+"px",
                "border-radius" : self.option.size/2+"px"
            }).on("touchstart",function(event){
                event.preventDefault();
                event.stopPropagation();
                if(self.state.expand){
                    self.homing();
                }else{
                    self.state.touchStart=true;
                    self.state.prepareExpand=true;
                    setTimeout(function(){
                        if(!self.state.touchMove){
                            self.expand();
                        }
                        self.state.prepareExpand=false;
                    },600);
                }
            });
            $(window.document).off("touchmove.elf").off("touchend.elf").on({
                "touchmove.elf" : function(event){
                    if(self.state.touchStart){
                        self.state.touchMove=true;
                        event.preventDefault();
                        event.stopPropagation();
                        self.jqElement.lfr.removeClass("homingLeft").removeClass("homingRight");
                        var touch=event.originalEvent.touches[0];
                        self.offset.left=touch.pageX-self.option.avg;
                        if(self.offset.left<0){
                            self.offset.left=0;
                        }else if(self.offset.left>self.windowInfo.vEdge){
                            self.offset.left=self.windowInfo.vEdge;
                        }
                        self.offset.top=touch.pageY-self.option.avg;
                        if(self.offset.top<0){
                            self.offset.top=0;
                        }else if(self.offset.top>self.windowInfo.hEdge){
                            self.offset.top=self.windowInfo.hEdge;
                        }
                        self.move(false);
                    }
                },
                "touchend.elf" : function(){
                    if(self.state.touchStart){
                        self.state.touchMove=false;
                        if(!self.state.prepareExpand){
                            self.homing();
                        }
                    }
                }
            });
            var messageCommitState=false;
            self.jqElement.message.find("button").on("click",function(){
                if(!messageCommitState){
                    messageCommitState=true;
                    var content=self.jqElement.messageContent.val().trim();
                    if(!content){
                        $alert({
                            title : "提示",
                            content :"不和我说点什么吗",
                            btn : "确定"
                        });
                        messageCommitState=false;
                        return;
                    }
                    $.ajax({
                        type : "post",
                        url : "/message/leave/",
                        data : {
                            content : content
                        },
                        dataType : "json",
                        success : function(msg){
                            if(msg.errorCode===0){
                                $alert({
                                    title : "提示",
                                    content :"吾已收到",
                                    btn : "",
                                    closeMil : 1000
                                });
                                self.homing();
                            }else{
                                $alert({
                                    title : "提示",
                                    content :"留言失败，我也不知道为什么不能留言",
                                    btn : "确定"
                                });
                            }
                            messageCommitState=false;
                        }
                    });
                }
            });
            $('body').append(self.jqElement.container).append(self.jqElement.message);
            self.move();
            instance=self;
        },
        move : function(animation,callback){
            var self=this;
            if(animation){
                self.jqElement.container.addClass("animation");
                setTimeout(function(){
                    self.jqElement.container.removeClass("animation");
                    if($.isFunction(callback)){
                        callback.apply(self);
                    }
                },500);
            }else{
                if($.isFunction(callback)){
                    callback.apply(self);
                }
            }
            self.jqElement.container.css({
                "left" : self.offset.left+"px",
                "top" : self.offset.top+"px"
            });
        },
        expand : function(){
            var self=this;
            self.state.expand=true;
            self.state.touchStart=false;
            self.state.touchMove=false;
            if(self.offset.left<0){
                self.offset.left=0;
            }else if(self.offset.left>self.windowInfo.vEdge){
                self.offset.left=self.windowInfo.vEdge;
            }
            self.offset.left=self.windowInfo.vBoundary-self.option.avg;
            self.move(true,function(){
                self.offset.top=self.windowInfo.height-self.option.avg-200;
                self.move(true);
            });
            self.jqElement.message.addClass("expand");
            self.jqElement.lfr.removeClass("homingLeft").removeClass("homingRight").addClass("expand");
        },
        homing : function(){
            var self=this,state;
            if(self.offset.left<=self.windowInfo.vBoundary){
                self.offset.left=-self.option.avg;
                state=true;
            }else{
                state=false;
                self.offset.left=self.windowInfo.vEdge+self.option.avg;
            }
            self.jqElement.message.removeClass("expand");
            setTimeout(function(){
                self.move(true,function(){
                    if(state){
                        self.jqElement.lfr.addClass("homingLeft");
                    }else{
                        self.jqElement.lfr.addClass("homingRight");
                    }
                });
                self.jqElement.lfr.removeClass("expand");
            },500);
            self.state.expand=false;
            self.state.touchStart=false;
        },
        close : function(){
            this.jqElement.container.remove();
        },
        defaultOption : {
            size : 60
        }
    };

    $.extend({
        openElf : function(option){
            if(!instance){
                new Elf(option);
            }
        },
        closeElf : function(){
            if(instance){
                instance.close();
            }
        }
    });
}(jQuery,jQuery.alert);
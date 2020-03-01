!function($){
    var template={
        mask : $('<div class="mask" style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;;z-index: 111;background-color: rgba(210,210,210,0.3);"/>'),
        dialog : $('<div class="dialog" style="width: 200px;position: absolute;z-index: 112;' +
            'left: 50%;top: 50%;margin-left: -100px;background-color: #ee9ca7;border-radius: 5px;opacity: 0;transition: all 500ms ease 0s;">' +
                '<div class="title" style="padding: 5px 10px;font-size: 14px;border-bottom: 1px solid;"></div>'+
                '<div class="content" style="font-size: 13px;padding: 2px 10px;min-height:50px;"></div>'+
                '<div class="btn" style="padding: 5px;text-align: center;">我已知错</div>'+
            '</div>')
    },instances=[];

    var Alert=function(option){
        var self=this;
        self.option=$.extend({},self.defaultOption,option);
        self.jqElement={
            mask : template.mask.clone(),
            dialog : template.dialog.clone()
        };
        self.jqElement.dialogTitle=self.jqElement.dialog.find(".title");
        self.jqElement.dialogContent=self.jqElement.dialog.find(".content");
        self.jqElement.dialogBtn=self.jqElement.dialog.find(".btn");
        self.init();
    };

    Alert.prototype={
        init : function(){
            var self=this;
            self.jqElement.dialogTitle.text(self.option.title);
            self.jqElement.dialogContent.text(self.option.content);
            self.jqElement.dialogBtn.text(self.option.btn);
            self.jqElement.dialogBtn.on("click",function(){
                self.close();
            });
            self.jqElement.mask.on("click",function(){
                self.jqElement.dialog.css("transition","100ms");
                self.jqElement.dialog.css("left","52%");
                setTimeout(function(){
                    self.jqElement.dialog.css("left","48%");
                    setTimeout(function(){
                        self.jqElement.dialog.css("left","50%");
                        setTimeout(function(){
                            self.jqElement.dialog.css("transition","500ms");
                        },100);
                    },100);
                },100);
            });
            $("body")
                .append(self.jqElement.mask)
                .append(self.jqElement.dialog);
            instances.push(self);
            setTimeout(function(){
                self.open();
            },100);
        },
        open : function(){
            var self=this;
            self.jqElement.dialog.css({
                "opacity" : "1",
                "margin-top" : -(self.jqElement.dialog.height()/2)+"px"
            });
        },
        close : function(){
            var self=this;
            self.jqElement.dialog.css({
                "opacity" : "0",
                "margin-top" : "0"
            });
            self.jqElement.mask.remove();
            setTimeout(function(){
                self.jqElement.dialog.remove();
            },600);
        },
        defaultOption : {
            title : "消息",
            content : "不想理你",
            btn : "我已知错"
        }
    };

    $.extend({
        alert : function(option){
            new Alert(option);
        }
    });

    $.alert.close=function(){
        if(instances.length>0){
            instances.pop().close();
        }
    };
}(jQuery);
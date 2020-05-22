!function(){

    var webSockets=[];
    var webSocketCount=0;
    var WebSocket=window.WebSocket;
    var urlPrefix="ws://";

    var MyWebSocket=function(option){
        var self=this;
        self.option=option;
        self.webSocket=undefined;
        self.index=webSocketCount++;
        webSockets.push(self);
        if(option.initOpen!==false){
            self.open();
        }
    };

    MyWebSocket.prototype={
        open : function(option){
            var self=this;
            self.close();
            option=$.extend(self.option,option);
            if(self.webSocket===undefined){
                self.webSocket=new WebSocket(urlPrefix+document.location.host+option.url);
            }else{
                self.webSocket.url=urlPrefix+document.location.host+option.url;
            }
            self.webSocket.onopen=option.onOpen;
            self.webSocket.onclose=option.onClose;
            self.webSocket.onerror=option.onError;
            self.webSocket.onmessage=option.onMessage;
        },
        close : function(){
            var self=this;
            if(self.webSocket!==undefined){
                self.webSocket.close();
            }
        },
        send : function(data){
            var self=this;
            if(self.webSocket!==undefined){
                self.webSocket.send(data);
            }
        }
    };

    window.onbeforeunload=function(){
        if(webSocketCount>0){
            for(var i=0;i<webSocketCount;i++){
                if(webSockets[i]){
                    webSockets[i].close();
                }
            }
        }
    };

    window.establishWebSocket=function(option){
        option=option || {
            onError : function(){
                alert("建立websocket失败");
            }
        };
        if(!WebSocket){
            if(typeof option.onError==="function"){
                option.onError.apply();
            }
        }else{
            return new MyWebSocket(option);
        }
    };
}();
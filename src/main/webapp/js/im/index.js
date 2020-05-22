var websocket,listWrapper,username="test";
$(function(){
    username=localStorage.getItem("dear_is_admin")==="1"?"admin":"test";
    if(username==="admin"){
        $(".chat-tools-toggle>i").attr("class","dear-font setting");
    }
    listWrapper=$(".chat-list-wrapper>div");
    websocket=establishWebSocket({
        url : "/webSocket/"+username,
        onOpen : function(){
            console.log("建立webSocket成功");
        },
        onClose : function(){
            console.log("关闭webSocket");
        },
        onMessage : function(event){
            console.log("--------------------------------------");
            console.log("得到消息");
            console.log(event);
            var data=event.data;
            if(data){
                addRecord(JSON.parse(event.data));
            }
            console.log("--------------------------------------");
        },
        onError : function(){
            console.error("建立webSocket错误");
        }
    });
    var text=$(".chat-tools-content>input"),value;
    $(".chat-tools-send").on("click",function(){
        value=text.val().trim();
        if(value==="adminadminadmin"){
            localStorage.setItem("dear_is_admin","1");
            username="admin";
            text.val("");
            $(".chat-tools-toggle>i").attr("class","dear-font setting");
            return;
        }
        if(value){
            websocket.send(text.val());
            text.val("");
        }
    });
});

function addRecord(item){
    var items;
    if($.isArray(item)){
        items=item;
    }else{
        items=[item];
    }
    var itemData;
    for(var i=0;i<items.length;i++){
        itemData=items[i];
        if(itemData.msgType===1){
            listWrapper.append('<div class="chat-item item-left">' +
                                    '<div class="item-img"></div>' +
                                    '<div class="item-content">'+itemData.msgText+'</div>' +
                                '</div>');
        }else if(itemData.msgType===2){
            listWrapper.append('<div class="chat-item item-right">' +
                                    '<div class="item-img"></div>' +
                                    '<div class="item-content">'+itemData.msgText+'</div>' +
                                '</div>');
        }else{
            listWrapper.append('<div class="item-time">'+
                                    '<span>'+formatTime(itemData.time)+'</span>'+
                                '</div>');
        }
    }
}

/**
 * @return {string}
 */
function S4() {
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}

function guid() {
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
}

function formatTime(time){
    var date=new Date(time);
    var year=date.getFullYear();
    var month=date.getMonth()+1;
    var day=date.getDate();
    var hour=date.getHours();
    var minute=date.getMinutes();
    var now=new Date();
    var _year=now.getFullYear();
    var _month=now.getMonth()+1;
    var _day=now.getDate();
    if(year===_year && month===month && day===_day){
        return addZero(hour)+":"+addZero(minute);
    }else{
        var minus=new Date(_year,_month-1,_day).getTime()-new Date(year,month-1,day).getTime();
        var days=minus/(1000*60*60*24);
        if(days===1){
            return "昨天 "+addZero(hour)+":"+addZero(minute);
        }
    }
    return addZero(year)+"年"+addZero(month)+"月"+addZero(day)+"日 "+addZero(hour)+":"+addZero(minute);
}

function addZero(num){
    if(num<10){
        return "0"+num;
    }
    return num;
}
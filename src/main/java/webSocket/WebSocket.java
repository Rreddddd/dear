package webSocket;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.IMRecordEntity;
import service.impl.IMRecordServiceImpl;
import util.SpringBeanTools;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/{username}")
public class WebSocket {

    private static int onlineCount=0;
    private static Map<String,WebSocket> clients=new ConcurrentHashMap<String,WebSocket>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username,Session session){
        this.session=session;
        this.username=username;
        addOnlineCount();
        clients.put(username,this);
        System.out.println("----------------------------------------------------");
        System.out.println("websocket连接成功;onlineCount="+onlineCount+",username="+username);
        System.out.println("----------------------------------------------------");
        Map<String,Object> result=new HashMap<String,Object>();
        List<IMRecordEntity> results = SpringBeanTools.getBeanByClassType(IMRecordServiceImpl.class).getRecord();
        if(results!=null){
            result.put("type",1);
            result.put("items",results);
            sendMessageTo(JSONObject.toJSONString(result),username);
        }
    }

    @OnClose
    public void onClose(){
        clients.remove(username);
        subOnlineCount();
        System.out.println("----------------------------------------------------");
        System.out.println("websocket断开连接;onlineCount="+onlineCount+",username="+username);
        System.out.println("----------------------------------------------------");
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("----------------------------------------------------");
        System.out.println("websocket消息："+message);
        System.out.println("----------------------------------------------------");
        Map<String,Object> result=new HashMap<String,Object>();
        if(message.equals("writing")){
            result.put("type",2);
        }else{
            result.put("type",1);
            List<IMRecordEntity> results = SpringBeanTools.getBeanByClassType(IMRecordServiceImpl.class).addRecord(message, username.equals("admin") ? 1 : 2);
            if(results!=null){
                result.put("items",results);
                sendMessageTo(JSONObject.toJSONString(result),username);
            }
        }
    }

    @OnError
    public void OnError(Session session,Throwable error){
        System.out.println("----------------------------------------------------");
        System.out.println("websocket出错");
        error.printStackTrace();
        System.out.println("----------------------------------------------------");
    }

    public void sendMessageTo(String message,String to){
        WebSocket webSocket = clients.get(to);
        if(webSocket!=null){
            webSocket.session.getAsyncRemote().sendText(message);
        }
    }

    public void addOnlineCount(){
        onlineCount++;
    }

    public void subOnlineCount(){
        onlineCount--;
    }

    public static int getOnlineCount(){
        return onlineCount;
    }
}

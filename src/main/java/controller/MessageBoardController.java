package controller;

import entity.MessageBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MessageBoardService;
import util.ApiTools;
import util.IpConfig;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/message")
@Controller("controller.MessageBoardController")
public class MessageBoardController {

    private MessageBoardService messageBoardService;

    @Autowired
    public MessageBoardController(MessageBoardService messageBoardService){
        this.messageBoardService=messageBoardService;
    }

    @ResponseBody
    @RequestMapping("/leave")
    public Map<String,Object> leave(HttpServletRequest request){
        Map<String,Object> result=new HashMap<String, Object>();
        try {
            MessageBoardEntity messageBoard=new MessageBoardEntity();
            messageBoard.setIp(IpConfig.getIpAddr(request));
            messageBoard.setLocation(ApiTools.getIpLocate(messageBoard.getIp()));
            messageBoard.setContent(request.getParameter("content"));
            messageBoard.setTime(new Timestamp(System.currentTimeMillis()));
            messageBoardService.save(messageBoard);
            result.put("errorCode",0);
        }catch (Exception e){
            e.printStackTrace();
            result.put("errorCode",1);
        }
        return result;
    }
}

package service.impl;

import dao.MessageBoardDao;
import entity.MessageBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MessageBoardService;
import util.MailTools;

@Service("service.impl.MessageBoardImplService")
public class MessageBoardImplService implements MessageBoardService {

    private MessageBoardDao messageBoardDao;

    @Autowired
    public MessageBoardImplService(MessageBoardDao messageBoardDao){
        this.messageBoardDao=messageBoardDao;
    }

    public void save(MessageBoardEntity entity) {
        messageBoardDao.save(entity);
        MailTools.sendMessages("来自dear的新留言",
                "地址："+entity.getLocation()+
                        "<br>内容："+entity.getContent());
    }
}

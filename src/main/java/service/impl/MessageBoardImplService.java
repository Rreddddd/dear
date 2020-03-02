package service.impl;

import dao.MessageBoardDao;
import entity.MessageBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MessageBoardService;

@Service("service.impl.MessageBoardImplService")
public class MessageBoardImplService implements MessageBoardService {

    private MessageBoardDao messageBoardDao;

    @Autowired
    public MessageBoardImplService(MessageBoardDao messageBoardDao){
        this.messageBoardDao=messageBoardDao;
    }

    public void save(MessageBoardEntity entity) {
        messageBoardDao.save(entity);
    }
}

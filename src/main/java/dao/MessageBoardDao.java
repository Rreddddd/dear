package dao;

import entity.MessageBoardEntity;
import org.springframework.stereotype.Repository;

@Repository("dao.MessageBoardDao")
public interface MessageBoardDao {

    void save(MessageBoardEntity entity);
}

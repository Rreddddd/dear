package dao;

import entity.BirthdayTwentyStartEntity;
import org.springframework.stereotype.Repository;

@Repository("dao.BirthdayTwentyStartDao")
public interface BirthdayTwentyStartDao {

    void save(BirthdayTwentyStartEntity entity);

    int getSuccessCount();

    int getErrorCount();

    void removeAll();
}

package dao;

import entity.BirthdayTwentyViewEntity;
import org.springframework.stereotype.Repository;

@Repository("dao.BirthdayTwentyViewDao")
public interface BirthdayTwentyViewDao {

    void save(BirthdayTwentyViewEntity entity);

    int getLikeCount();

    int getDontLikeCount();

    void removeAll();
}

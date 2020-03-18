package dao;

import entity.AccessRecordEntity;
import org.springframework.stereotype.Repository;

@Repository("dao.AccessRecordDao")
public interface AccessRecordDao {

    void save(AccessRecordEntity entity);
}

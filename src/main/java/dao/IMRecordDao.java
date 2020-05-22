package dao;

import entity.IMRecordEntity;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("dao.IMRecordDao")
public interface IMRecordDao {

    void save(IMRecordEntity entity);

    Timestamp getLastTime();

    List<IMRecordEntity> getRecord();
}

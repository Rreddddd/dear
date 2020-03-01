package service.impl;

import dao.BirthdayTwentyViewDao;
import entity.BirthdayTwentyViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BirthdayTwentyViewService;

import java.sql.Timestamp;

@Service("service.impl.BirthdayTwentyViewImplService")
public class BirthdayTwentyViewImplService implements BirthdayTwentyViewService {

    private BirthdayTwentyViewDao birthdayTwentyViewDao;

    @Autowired
    public BirthdayTwentyViewImplService(BirthdayTwentyViewDao birthdayTwentyViewDao){
        this.birthdayTwentyViewDao=birthdayTwentyViewDao;
    }

    public void save(BirthdayTwentyViewEntity entity) {
        birthdayTwentyViewDao.save(entity);
    }

    public void save(boolean state) {
        BirthdayTwentyViewEntity entity=new BirthdayTwentyViewEntity();
        entity.setState(state);
        entity.setTime(new Timestamp(System.currentTimeMillis()));
        save(entity);
    }

    public boolean getLikeState() {
        return birthdayTwentyViewDao.getLikeCount()>0;
    }

    public int getDontLikeCount() {
        return birthdayTwentyViewDao.getDontLikeCount();
    }

    public void removeAll() {
        birthdayTwentyViewDao.removeAll();
    }
}

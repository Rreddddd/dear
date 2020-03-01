package service.impl;

import dao.BirthdayTwentyStartDao;
import entity.BirthdayTwentyStartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BirthdayTwentyStartService;

import java.sql.Timestamp;

@Service("service.impl.BirthdayTwentyStartImplService")
public class BirthdayTwentyStartImplService implements BirthdayTwentyStartService {

    private BirthdayTwentyStartDao birthdayTwentyStartDao;

    @Autowired
    public BirthdayTwentyStartImplService(BirthdayTwentyStartDao birthdayTwentyStartDao){
        this.birthdayTwentyStartDao=birthdayTwentyStartDao;
    }

    public void save(BirthdayTwentyStartEntity entity) {
        birthdayTwentyStartDao.save(entity);
    }

    public void save(String userName,String password,boolean valid){
        BirthdayTwentyStartEntity entity=new BirthdayTwentyStartEntity();
        entity.setUserName(userName);
        entity.setPassword(password);
        entity.setValid(valid);
        entity.setTime(new Timestamp(System.currentTimeMillis()));
        save(entity);
    }

    public boolean getSuccessState() {
        return birthdayTwentyStartDao.getSuccessCount()>0;
    }

    public int getErrorCount() {
        return birthdayTwentyStartDao.getErrorCount();
    }

    public void removeAll() {
        birthdayTwentyStartDao.removeAll();
    }
}

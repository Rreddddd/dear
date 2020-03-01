package service;

import entity.BirthdayTwentyStartEntity;

public interface BirthdayTwentyStartService{

    void save(BirthdayTwentyStartEntity entity);

    void save(String userName,String password,boolean valid);

    boolean getSuccessState();

    int getErrorCount();

    void removeAll();
}

package service;

import entity.BirthdayTwentyViewEntity;

public interface BirthdayTwentyViewService {

    void save(BirthdayTwentyViewEntity entity);

    void save(boolean state);

    boolean getLikeState();

    int getDontLikeCount();

    void removeAll();
}

package service.impl;

import dao.IMRecordDao;
import entity.IMRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IMRecordService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("service.impl.IMRecordServiceImpl")
public class IMRecordServiceImpl implements IMRecordService {

    private IMRecordDao imRecordDao;

    @Autowired
    public IMRecordServiceImpl(IMRecordDao imRecordDao){
        this.imRecordDao=imRecordDao;
    }

    public List<IMRecordEntity> addRecord(String text, int type){
        List<IMRecordEntity> result=new ArrayList<IMRecordEntity>();
        if(text!=null){
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Timestamp lastTime = imRecordDao.getLastTime();
            if(lastTime==null || (now.getTime()-lastTime.getTime())>180000){
                IMRecordEntity imRecordEntity=new IMRecordEntity();
                imRecordEntity.setMsgType(0);
                imRecordEntity.setMsgText("");
                imRecordEntity.setTime(now);
                result.add(imRecordEntity);
                imRecordDao.save(imRecordEntity);
            }
            IMRecordEntity imRecordEntity=new IMRecordEntity();
            imRecordEntity.setMsgType(type);
            imRecordEntity.setMsgText(text);
            imRecordEntity.setTime(now);
            result.add(imRecordEntity);
            imRecordDao.save(imRecordEntity);
        }
        return result;
    }

    public List<IMRecordEntity> getRecord() {
        return imRecordDao.getRecord();
    }
}

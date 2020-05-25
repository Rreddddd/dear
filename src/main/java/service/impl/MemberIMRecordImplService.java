package service.impl;

import dao.MemberIMRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MemberIMRecordService;

@Service("service.impl.MemberIMRecordImplService")
public class MemberIMRecordImplService implements MemberIMRecordService {

    private MemberIMRecordDao memberIMRecordDao;

    @Autowired
    public MemberIMRecordImplService(MemberIMRecordDao memberIMRecordDao){
        this.memberIMRecordDao=memberIMRecordDao;
    }
}

package service.impl;

import dao.MemberLoginInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MemberLoginInfoService;

@Service("service.impl.MemberLoginInfoImplService")
public class MemberLoginInfoImplService implements MemberLoginInfoService {

    private MemberLoginInfoDao memberLoginInfoDao;

    @Autowired
    public MemberLoginInfoImplService(MemberLoginInfoDao memberLoginInfoDao){
        this.memberLoginInfoDao=memberLoginInfoDao;
    }

}

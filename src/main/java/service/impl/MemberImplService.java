package service.impl;

import dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MemberService;

@Service("service.impl.MemberImplService")
public class MemberImplService implements MemberService {

    private MemberDao memberDao;

    @Autowired
    public MemberImplService(MemberDao memberDao){
        this.memberDao=memberDao;
    }
}

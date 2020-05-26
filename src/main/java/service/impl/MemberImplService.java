package service.impl;

import dao.MemberDao;
import entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MemberService;

import java.util.UUID;

@Service("service.impl.MemberImplService")
public class MemberImplService implements MemberService {

    private MemberDao memberDao;

    @Autowired
    public MemberImplService(MemberDao memberDao){
        this.memberDao=memberDao;
    }

    @Override
    public void mergeMember(MemberEntity member) {
        String guid = member.getGuid();
        if(guid==null){
            guid=UUID.randomUUID().toString();
        }
        MemberEntity _member=memberDao.findByGuid(guid);
        if(_member==null){
            memberDao.save(member);
        }else{
            memberDao.update(member);
        }
    }

    @Override
    public MemberEntity syncWXMember(MemberEntity wxMember) {
        if(wxMember==null){
            wxMember=new MemberEntity();
        }
        String wxOpenId = wxMember.getWxOpenId();
        if(wxOpenId==null){
            return wxMember;
        }
        MemberEntity member=memberDao.findByWXOpenId(wxOpenId);
        boolean newMember=false;
        if(member==null){
            newMember=true;
            member=new MemberEntity();
            member.setGuid(UUID.randomUUID().toString());
            member.setWxOpenId(wxOpenId);
        }
        member.setName(wxMember.getName());
        member.setHeadImgUrl(wxMember.getHeadImgUrl());
        mergeMember(member);
        if(newMember){
            member=memberDao.findByGuid(member.getGuid());
        }
        return member;
    }
}

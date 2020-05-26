package service;

import entity.MemberEntity;

public interface MemberService {

    void mergeMember(MemberEntity member);

    MemberEntity syncWXMember(MemberEntity wxMember);
}

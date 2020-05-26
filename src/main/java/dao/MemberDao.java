package dao;

import entity.MemberEntity;
import org.springframework.stereotype.Repository;

@Repository("dao.MemberDao")
public interface MemberDao {

    void save(MemberEntity member);

    void update(MemberEntity member);

    MemberEntity findByGuid(String guid);

    MemberEntity findByWXOpenId(String wxOpenId);
}

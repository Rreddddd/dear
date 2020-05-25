package entity;

import org.springframework.util.DigestUtils;

import java.util.Objects;

public class MemberEntity {

    private int id;
    private String guid;
    private String name;
    private String headImgUrl;
    private String wxOpenId;

    public static String mergeGuid(String guid1,String guid2){
        if(Objects.hash(guid1)<=Objects.hash(guid2)){
            return DigestUtils.md5DigestAsHex((guid1+"_"+guid2).getBytes());
        }else{
            return DigestUtils.md5DigestAsHex((guid2+"_"+guid1).getBytes());
        }
    }

    public String mergeGuid(String guid){
        return MemberEntity.mergeGuid(this.guid,guid);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }
}

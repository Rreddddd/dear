package entity;

import java.util.Date;

public class MemberIMRecordEntity {

    private int id;
    private String mergeMemberId;
    private String fromMemberId;
    private String toMemberId;
    private String content;
    private Date time;
    private boolean read;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMergeMemberId() {
        return mergeMemberId;
    }

    public void setMergeMemberId(String mergeMemberId) {
        this.mergeMemberId = mergeMemberId;
    }

    public String getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(String fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public String getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(String toMemberId) {
        this.toMemberId = toMemberId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

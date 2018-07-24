package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

public class UserGroup {
    private Long id;

    private String groupName;

    private String uid;

    private Byte state;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public UserGroup(Long id, String groupName, String uid, Byte state, LocalDateTime gmtCreate, LocalDateTime gmtModified) {
        this.id = id;
        this.groupName = groupName;
        this.uid = uid;
        this.state = state;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UserGroup() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
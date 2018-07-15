package com.monster.auth.pojo.po;

import java.util.Date;

public class RbacRole {
    private Long id;

    private String name;

    private Long updatePersonId;

    private Date gmtCreate;

    private Date gmtModified;

    public RbacRole(Long id, String name, Long updatePersonId, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.updatePersonId = updatePersonId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public RbacRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(Long updatePersonId) {
        this.updatePersonId = updatePersonId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class RbacRole {
    private Long id;

    private String name;

    private Long updatePersonId;

    //一般用于入参时候绑定，比如dto中,待测试一下
    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    public RbacRole(Long id, String name, Long updatePersonId, LocalDateTime gmtCreate, LocalDateTime gmtModified) {
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
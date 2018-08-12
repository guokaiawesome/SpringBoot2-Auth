package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

public class RbacRoleGroup {
    private Long id;

    private Long roleId;

    private Long groupId;

    private Byte whetherDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Byte getWhetherDeleted() {
		return whetherDeleted;
	}

	public void setWhetherDeleted(Byte whetherDeleted) {
		this.whetherDeleted = whetherDeleted;
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
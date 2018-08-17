package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

public class UserBaseInfo {
    private Long id;

    private String uid;

    private String realName;

    private String nickName;

    private Byte state;

    private Byte whetherFrozen;

    private Byte whetherDeleted;
    
    private Byte whetherInternalTest;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getWhetherFrozen() {
		return whetherFrozen;
	}

	public void setWhetherFrozen(Byte whetherFrozen) {
		this.whetherFrozen = whetherFrozen;
	}

	public Byte getWhetherDeleted() {
		return whetherDeleted;
	}

	public void setWhetherDeleted(Byte whetherDeleted) {
		this.whetherDeleted = whetherDeleted;
	}
	
	public Byte getWhetherInternalTest() {
		return whetherInternalTest;
	}

	public void setWhetherInternalTest(Byte whetherInternalTest) {
		this.whetherInternalTest = whetherInternalTest;
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

	@Override
	public String toString() {
		return "UserBaseInfo [id=" + id + ", uid=" + uid + ", realName=" + realName + ", nickName=" + nickName
				+ ", state=" + state + ", whetherFrozen=" + whetherFrozen + ", whetherDeleted=" + whetherDeleted
				+ ", whetherInternalTest=" + whetherInternalTest + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
	}


    
    
    
}
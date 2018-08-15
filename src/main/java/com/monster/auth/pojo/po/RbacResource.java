package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

public class RbacResource {
    private Long id;

    private String category;

    private String uri;

    private String httpVerb;

    private Long updatePersonId;

    private Byte whetherDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHttpVerb() {
        return httpVerb;
    }

    public void setHttpVerb(String httpVerb) {
        this.httpVerb = httpVerb;
    }

    public Long getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(Long updatePersonId) {
        this.updatePersonId = updatePersonId;
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

	@Override
	public String toString() {
		return "RbacResource [id=" + id + ", category=" + category + ", uri=" + uri + ", httpVerb=" + httpVerb
				+ ", updatePersonId=" + updatePersonId + ", whetherDeleted=" + whetherDeleted + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
    
    
}
package com.monster.auth.pojo.po;

import java.time.LocalDateTime;

public class RbacResource {
    private Long id;
    
    //资源名称，比如：用户管理-添加，用户管理-删除，用户管理-更新等
    private String name;

    //类别，也就是类似资源所属资源组(类别)，方便页面授权时候直接对这一个类别进行全选(或者树形展示)进行授权
    private String category;

    private String uri;

    private String httpVerb;

    private Long updatePersonId;

    private Byte whetherDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
		return "RbacResource [id=" + id + ", name=" + name + ", category=" + category + ", uri=" + uri + ", httpVerb="
				+ httpVerb + ", updatePersonId=" + updatePersonId + ", whetherDeleted=" + whetherDeleted
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}


    
    
    
}
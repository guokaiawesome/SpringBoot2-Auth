package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacRoleResource;

public interface RbacRoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacRoleResource record);

    int insertSelective(RbacRoleResource record);

    RbacRoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacRoleResource record);

    int updateByPrimaryKey(RbacRoleResource record);
}
package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacUserGroup;

public interface RbacUserGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacUserGroup record);

    int insertSelective(RbacUserGroup record);

    RbacUserGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacUserGroup record);

    int updateByPrimaryKey(RbacUserGroup record);
}
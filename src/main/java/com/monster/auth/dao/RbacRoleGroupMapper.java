package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacRoleGroup;

public interface RbacRoleGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacRoleGroup record);

    int insertSelective(RbacRoleGroup record);

    RbacRoleGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacRoleGroup record);

    int updateByPrimaryKey(RbacRoleGroup record);
}
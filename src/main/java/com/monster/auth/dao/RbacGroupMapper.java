package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacGroup;

public interface RbacGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacGroup record);

    int insertSelective(RbacGroup record);

    RbacGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacGroup record);

    int updateByPrimaryKey(RbacGroup record);
}
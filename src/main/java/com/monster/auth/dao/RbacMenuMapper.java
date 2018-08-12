package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacMenu;

public interface RbacMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacMenu record);

    int insertSelective(RbacMenu record);

    RbacMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacMenu record);

    int updateByPrimaryKey(RbacMenu record);
}
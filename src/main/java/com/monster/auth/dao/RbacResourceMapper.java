package com.monster.auth.dao;

import com.monster.auth.pojo.po.RbacResource;

public interface RbacResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RbacResource record);

    int insertSelective(RbacResource record);

    RbacResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RbacResource record);

    int updateByPrimaryKey(RbacResource record);
}
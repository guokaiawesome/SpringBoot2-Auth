package com.monster.auth.dao;

import com.monster.auth.pojo.po.Oauth2ClientInfo;

public interface Oauth2ClientInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Oauth2ClientInfo record);

    int insertSelective(Oauth2ClientInfo record);

    Oauth2ClientInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Oauth2ClientInfo record);

    int updateByPrimaryKey(Oauth2ClientInfo record);
}
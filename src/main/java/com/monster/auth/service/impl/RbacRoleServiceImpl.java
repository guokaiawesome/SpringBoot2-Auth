package com.monster.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.auth.dao.RbacRoleMapper;
import com.monster.auth.pojo.po.RbacRole;
import com.monster.auth.service.RbacRoleService;

@Service
public class RbacRoleServiceImpl implements RbacRoleService{
	
	@Autowired
	RbacRoleMapper rbacRoleMapper;

	@Override
	public RbacRole selectByPrimaryKey(Long id) {
		return rbacRoleMapper.selectByPrimaryKey(id);
	}

}

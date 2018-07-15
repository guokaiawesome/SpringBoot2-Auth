package com.monster.auth.service;

import com.monster.auth.pojo.po.RbacRole;

/**
 * 
 * @description RBAC权限管理的角色管理
 * @author guokai
 * @date 2018年7月15日
 * @version v1.0
 */
public interface RbacRoleService {
	
	/**
	 * 
	 * @description 根据主键查找对应角色记录
	 * @param id
	 * @return
	 */
    RbacRole selectByPrimaryKey(Long id);

}

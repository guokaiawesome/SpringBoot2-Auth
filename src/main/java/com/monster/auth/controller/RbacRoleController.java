package com.monster.auth.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.auth.constant.CodeAndMsgEnum;
import com.monster.auth.constant.CommonConstant;
import com.monster.auth.pojo.po.RbacRole;
import com.monster.auth.response.CommonResponseResult;
import com.monster.auth.response.FailureResponseResult;
import com.monster.auth.response.SuccessResponseResult;
import com.monster.auth.service.RbacRoleService;

/**
 * 
 * @description RBAC角色管理的api
 * @author guokai
 * @date 2018年7月15日
 * @version v1.0
 */
@RestController
@RequestMapping("/rbac/roles")
public class RbacRoleController {

	@Autowired
	RbacRoleService rbacRoleService;

	@GetMapping("/role/{id}")
	public CommonResponseResult role(@PathVariable("id") Long id) {
		//这个还要改一下，date不要放在构造器里面，以免延后，也可以先放进去，避免因为忘了，后面重新设置一下就可以了
		FailureResponseResult failRet = new FailureResponseResult(CommonConstant.FAILURE,
				CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getCode(), CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(),
				CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(), LocalDateTime.now());

		Map<String, Object> error = new HashMap<>();
		Map<String, Object> errorParam = new HashMap<>();
		//采用动态绑定以后，其实id=null这种情况是不存在的，放在这里作为demo，后面移除
		if (id == null) {
			failRet.setSubMsg("你还未经过授权");
			errorParam.put("id", id);
			error.put("error_param", errorParam);
			failRet.setError(error);
			return failRet;
		}
		
		RbacRole record=rbacRoleService.selectByPrimaryKey(id);
		if(record==null) {
			failRet.setCode(CodeAndMsgEnum.RESOUCE_NOT_FOUND.getCode());
			failRet.setMsg(CodeAndMsgEnum.RESOUCE_NOT_FOUND.getMsg());
			failRet.setSubMsg("未找到对应的记录");
			errorParam.put("id", id);
			error.put("resource_not_found", errorParam);
			return failRet;
		}
		
		SuccessResponseResult successRet = new SuccessResponseResult(CommonConstant.SUCCESS,
				CodeAndMsgEnum.OK.getCode(), CodeAndMsgEnum.OK.getMsg(), "congratulation", LocalDateTime.now());
		Map<String, Object> data = new HashMap<>();
		data.put("record", record);
		successRet.setData(data);
		return successRet;
	}

}

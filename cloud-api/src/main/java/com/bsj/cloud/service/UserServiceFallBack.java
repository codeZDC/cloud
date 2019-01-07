package com.bsj.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFallBack implements UserService {

	@Override
	public String getById(Integer id) {
		return "没有找到相关用户";
	}

}

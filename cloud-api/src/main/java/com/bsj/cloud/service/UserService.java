package com.bsj.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="user")
//@FeignClient(value="user",fallback=UserServiceFallBack.class)
public interface UserService {
	
	@GetMapping("getById")
	public String getById(@RequestParam("id")Integer id);
	
}

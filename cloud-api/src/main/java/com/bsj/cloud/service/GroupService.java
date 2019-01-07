package com.bsj.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bsj.cloud.domain.Group;

@FeignClient("group")
public interface GroupService {
	
	@GetMapping("getById")
	Group getById(@RequestParam("id")Integer id);
	
	@PostMapping("save")
	boolean save(Group group);
	
}

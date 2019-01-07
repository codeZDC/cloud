package com.bsj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsj.cloud.domain.Group;
import com.bsj.cloud.domain.User;
import com.bsj.cloud.service.GroupService;

@RestController
public class UserController {
	
	@Autowired	
	private GroupService groupService; 
	
	@GetMapping("getById")
	public User getById(Integer id){
		if(id == 0){
			Assert.isNull("", "kong...");
		}
		String groupName = groupService.getById(id).getGroupName();
		return new User().setId(id).setUsername("username"+id).setRemarks("所在分组名称:"+groupName);
	}
	
	@GetMapping("save")
	public boolean save(Group group){
		return groupService.save(group);
	}
}
	
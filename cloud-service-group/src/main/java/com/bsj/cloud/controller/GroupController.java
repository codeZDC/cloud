package com.bsj.cloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsj.cloud.domain.Group;
import com.bsj.cloud.service.UserService;

@RestController
public class GroupController {
	
	private static Map<Integer,Group> groups;
	
	static{
		groups = new HashMap<Integer, Group>();
		groups.put(0, new Group().setId(0).setGroupName("研发0部"));
		groups.put(1, new Group().setId(1).setGroupName("研发1部"));
		groups.put(2, new Group().setId(2).setGroupName("研发2部"));
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("getById")
	public Group getById(Integer id){
		return groups.get(id%groups.size());
	}
	
	@GetMapping("getById2")
	public String getById2(Integer id){
		System.err.println("获取用户信息 : " + userService.getById(id));
		return groups.get(id%groups.size()).toString();
	}
	
	@PostMapping("save")
	public boolean save(@RequestBody Group group){
		groups.put(groups.size(), group );
		System.err.println(group);
		return true;
	}
	@GetMapping("list")
	public Object list(){
		return groups;
	}
}

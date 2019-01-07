package com.bsj.cloud.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)//链式
public class User {

	private Integer id;
	private String username;
	private Integer groupId;
	private String remarks;
	
}

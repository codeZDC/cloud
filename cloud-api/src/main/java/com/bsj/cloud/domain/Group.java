package com.bsj.cloud.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)//链式
public class Group {
	
	private Integer id;
	
	private String groupName;
	
}

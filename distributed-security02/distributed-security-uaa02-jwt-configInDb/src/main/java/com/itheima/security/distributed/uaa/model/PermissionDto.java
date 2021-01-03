package com.itheima.security.distributed.uaa.model;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
public class PermissionDto {

    private String id;
    private String code;
    private String description;
    private String url;
    
    public static void main(String[] args) {
		PermissionDto p = new PermissionDto();
		p.setCode("abc");
		
		System.out.println(p.getCode());
	}
}

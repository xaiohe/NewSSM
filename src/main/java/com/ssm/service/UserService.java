package com.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.IUserMapper;

@Service("userService")
public class UserService implements IUserService {

	@Resource
	private IUserMapper userMapper;
	
	public void addUser() {
		System.out.println("--addUser---");
		userMapper.addUser();
		userMapper.addUser();
	}

}

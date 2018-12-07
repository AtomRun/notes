package com.leeup.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.leeup.service.UserService;

//注意使用dubbo包的service
@Service
public class UserServiceImpl implements UserService{

	@Override
	public String getName() {
		return "李闯";
	}

}

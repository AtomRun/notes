package com.leeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leeup.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	//不能使用自动装配的注解，因为他根本不在该工程，要使用阿里巴巴的@Reference注解
	@Reference
	private UserService userService;
	
	@RequestMapping("/showName")
	//加了ResponseBody表示返回值直接输出，不加表示返回的是一个页面
	@ResponseBody
	public String showName() {
		
		return userService.getName();
	}
}

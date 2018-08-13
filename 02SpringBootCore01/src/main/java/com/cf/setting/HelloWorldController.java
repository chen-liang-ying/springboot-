package com.cf.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cf.setting.config.UserConfig;

@RestController
public class HelloWorldController {
	@Value("${test.user}")
	private String name;
	@Value("${test.age}")
	private int age;
	
	@Autowired
	private UserConfig config;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("user1:" + name + " age1:" + age);
		
		System.out.println("user2:" + config.getName() + " age2:" + config.getAge());
		
		return "hello-world, welcome!";
	}
}

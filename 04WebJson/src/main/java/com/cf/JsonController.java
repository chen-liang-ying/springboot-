package com.cf;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	@RequestMapping("/getUser")
	public User getUser () {
		User user = new User();
		user.setUserId("001");
		user.setUserName("ZhangSan");
		user.setCreateDate(new Date());
		user.setAge(20);
		
		return user;
	}
	
}

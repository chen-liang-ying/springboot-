package com.cf;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String,Object> map){

		map.put("hello", "123456");
		return "index";
	}
}


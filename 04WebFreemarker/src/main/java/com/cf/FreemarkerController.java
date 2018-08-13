package com.cf;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
	@RequestMapping("/hello")
	public String helloFtl(Map<String,Object> map){
		map.put("hello","from TemplateController.hello");
		return "/hello";
	}

}

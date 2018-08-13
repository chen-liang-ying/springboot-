package com.cf;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	/**
	 * 返回html模板.
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String,Object> map){
		map.put("hello","from ThymeleafController.NewFile");
		return "/NewFile";
	}

}

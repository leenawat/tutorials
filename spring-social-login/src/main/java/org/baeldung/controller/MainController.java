package org.baeldung.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/hello")
	@ResponseBody
	public String Hello(Map<String, Object> model) {
		model.put("Hello", ", This is Test Service");
		return "Hello, This is Test Service";
	}

	@RequestMapping("/model")
	@ResponseBody
	public Map<String, Object> model(Map<String, Object> model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", "leenawat");
		map.put("last_name", "papahome");
		return map;
	}
}

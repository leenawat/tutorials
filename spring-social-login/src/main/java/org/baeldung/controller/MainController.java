package org.baeldung.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public ModelAndView callback(ModelAndView model) {
		model.setViewName("callback");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = "/request_login", method = RequestMethod.POST)
	public @ResponseBody String request_login(@RequestParam String access_token) {

		System.out.println("access_token");
		StringBuffer result = new StringBuffer();
		String line = "";
		try{
		String url = "http://ictportal.moph.go.th/api/user";

		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
//		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "Bearer "+access_token);
		
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
			result.append(line);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return line;

	}

}

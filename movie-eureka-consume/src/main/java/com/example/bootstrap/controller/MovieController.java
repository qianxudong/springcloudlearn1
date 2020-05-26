package com.example.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bootstrap.feginServices.IUserService;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IUserService userService;
	private static final String applicationName = "user-provider";
	
	@RequestMapping(value = "feignRequest")
	public Object feignObject() {
		String nice = userService.nice();
		return nice;
	}
	
	@RequestMapping(value = "commonRequest")
    public Object commonRequest(){
        String url = "http://"+ applicationName +"/hello";
        String s = restTemplate.getForObject(url,String.class);
        return s;
    }
}

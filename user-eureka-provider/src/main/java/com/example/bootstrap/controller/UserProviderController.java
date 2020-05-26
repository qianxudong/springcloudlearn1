package com.example.bootstrap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProviderController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/hello")
	public String hello(){
		List<String> services = discoveryClient.getServices();
		for(String s : services){
			System.out.println(s);
		}
		return "hello spring cloud!";
	}

	@RequestMapping(value = "/nice")
	public String nice(){
		List<String> services = discoveryClient.getServices();
		for(String s : services){
			System.out.println("gogogo" + s);
		}
		return "nice to meet you!";
	}

}

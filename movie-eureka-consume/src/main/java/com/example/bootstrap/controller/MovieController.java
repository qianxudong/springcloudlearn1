package com.example.bootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.bootstrap.feginServices.IUserService;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
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
	
	@RequestMapping("/getUser/{id}")
	public String getUser(@PathVariable ("id") Long id) {
		String url = "http://"+ applicationName +"/user/"+id;
		ServiceInstance instance = loadBalancerClient.choose(applicationName);
		String testForGetServicePort = String.format(" Get request from %s ", instance.getPort());
		System.out.println(testForGetServicePort);
		return restTemplate.getForObject(url,String.class) + testForGetServicePort;
	}
	

}

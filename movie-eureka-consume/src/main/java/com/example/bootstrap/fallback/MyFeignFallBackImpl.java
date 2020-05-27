package com.example.bootstrap.fallback;

import org.springframework.stereotype.Component;

import com.example.bootstrap.feginServices.IUserService;

@Component
public class MyFeignFallBackImpl implements IUserService{

	@Override
	public String hello() {
		System.out.println("熔断，默认回调函数 hello");
		return "熔断，默认回调函数 hello";
	}

	@Override
	public String nice() {
		System.out.println("熔断，默认回调函数  nice");
		return "熔断，默认回调函数 nice";
	}
	
}

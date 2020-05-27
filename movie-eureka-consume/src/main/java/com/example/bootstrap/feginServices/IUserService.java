package com.example.bootstrap.feginServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bootstrap.fallback.MyFeignFallBackImpl;

/**
 * IUserService
 * 配置服务提供者：user-provider 是服务提供者的 application.name
 */

/*
 * value : 1。首先会找到注册在eureka中指定名字的服务  2.调用实现类api
 * fallback : 当熔断器开启或半开状态会调用此方法，会配置特定的挡板返回.
 */
@FeignClient(value = "user-provider",fallback = MyFeignFallBackImpl.class)  
public interface IUserService {

    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "nice")
    String nice();
}


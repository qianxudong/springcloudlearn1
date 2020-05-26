package com.example.bootstrap.feginServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IUserService
 * 配置服务提供者：user-provider 是服务提供者的 application.name
 */
@FeignClient("user-provider")  //1。首先会找到注册在eureka中指定名字的服务 2.调用相关api
public interface IUserService {

    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "nice")
    String nice();
}

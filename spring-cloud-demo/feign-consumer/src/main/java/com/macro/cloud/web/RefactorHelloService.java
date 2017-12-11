package com.macro.cloud.web;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zhenghong on 2017/12/4.
 */
@FeignClient("hello-service")
public interface RefactorHelloService extends com.macro.cloud.service.HelloService {
}

package com.macro.cloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhenghong on 2017/12/4.
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        User user = new User();
        user.setName("DIDI");
        user.setAge(25);
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI",25)).append("\n");
        sb.append(helloService.hello(user)).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("DIDI")).append("\n");
        sb.append(refactorHelloService.hello("DIDI", 25)).append("\n");
        sb.append(refactorHelloService.hello(new com.macro.cloud.dto.User("DIDI", 25))).append("\n");
        return sb.toString();
    }
}

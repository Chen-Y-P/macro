package com.macro.cloud;

import com.macro.cloud.filter.CustomErrorAttributes;
import com.macro.cloud.filter.CustomFilterProcessor;
import com.macro.cloud.filter.pre.AccessFilter;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        FilterProcessor.setProcessor(new CustomFilterProcessor());
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

//    @Bean
//    public DefaultErrorAttributes errorAttributes(){
//        return new CustomErrorAttributes();
//    }
}

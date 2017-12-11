package com.macro.cloud.rxjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhenghong on 2017/12/8.
 */
@EnableRxJavaProcessor
public class App1 {
    private static Logger logger = LoggerFactory.getLogger(App1.class);

    @Bean
    public RxJavaProcessor<Object, Object> processor() {
        return input -> input.map(data -> {
            logger.info("Received:" + data);
            return data;
        }).buffer(5).map(data -> String.valueOf("From input channel return-" + data));
    }

}

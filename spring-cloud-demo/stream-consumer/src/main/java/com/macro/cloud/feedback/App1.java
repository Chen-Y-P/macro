package com.macro.cloud.feedback;

import com.macro.cloud.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by zhenghong on 2017/12/8.
 */
//@EnableScheduling
//@EnableBinding(Processor.class)
public class App1 {
    private static Logger logger = LoggerFactory.getLogger(App1.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("receive:" + payload);
        return "From input channel return-:" + payload;
    }

    /**
     * spring-intergation 方式的反馈消息
     */
//    @ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
//    public Object receive(Object payload) {
//        logger.info("receive:" + payload);
//        return "From input channel return-:" + payload;
//    }
}

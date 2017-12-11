package com.macro.cloud.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macro.cloud.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

/**
 * Created by zhenghong on 2017/12/8.
 */
//@EnableBinding(Sink.class)
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(com.macro.cloud.intergation.SinkReceiver.class);
    @StreamListener(Sink.INPUT)
    public void receive(User payload) {
        logger.info("receive:" + payload);
    }
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    public void receive(User payload) {
//        logger.info("receive:" + payload);
//    }
//
//    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
//    public User transform(String message) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        User user = objectMapper.readValue(message, User.class);
//        return user;
//    }
}

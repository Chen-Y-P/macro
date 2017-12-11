package com.macro.cloud.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhenghong on 2017/12/6.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String text = "hello" + new Date();
        System.out.println("sender :" + text);
        amqpTemplate.convertAndSend("hello", text);
    }
}

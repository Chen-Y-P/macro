package com.macro.cloud;

import com.macro.cloud.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by zhenghong on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StreamHelloApplication.class)
@WebAppConfiguration
public class StreamHelloApplicationTest {
    @Autowired
    private SinkSender sinkSender;
    @Autowired
    @Qualifier("input")
    private MessageChannel messageChannel;

    @Test
    public void send() {
        sinkSender.output().send(MessageBuilder.withPayload("hello").build());
    }

    @Test
    public void send2() {
        messageChannel.send(MessageBuilder.withPayload("hello2").build());
    }
}
package com.macro.cloud.receiver;

import com.macro.cloud.sender.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by zhenghong on 2017/12/7.
 */
@EnableBinding({Sink.class, SinkSender.class})
public class SinkReceiver {
    private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        log.info("Received:" + payload);
    }
}

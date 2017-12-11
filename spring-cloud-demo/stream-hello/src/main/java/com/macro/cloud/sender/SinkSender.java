package com.macro.cloud.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * Created by zhenghong on 2017/12/7.
 */
public interface SinkSender {
    @Output(Sink.INPUT)
    MessageChannel output();
}

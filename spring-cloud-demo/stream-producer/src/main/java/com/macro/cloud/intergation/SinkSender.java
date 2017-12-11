package com.macro.cloud.intergation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhenghong on 2017/12/7.
 */
//@EnableBinding(SinkSender.SinkOutput.class)
public class SinkSender {
    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    /**
     * 每隔2秒发送一次消息
     */
    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    /**
     * 对输出消息进行转换
     */
    @Transformer(outputChannel = SinkOutput.OUTPUT, inputChannel = Sink.INPUT)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(message);
    }

    public interface SinkOutput {
        String OUTPUT = "input";

        @Output(OUTPUT)
        MessageChannel output();
    }
}

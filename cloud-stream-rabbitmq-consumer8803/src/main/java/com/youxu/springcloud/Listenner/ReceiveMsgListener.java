package com.youxu.springcloud.Listenner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMsgListener {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg){
        log.info("consumer-8803*****received msg:{}",msg.getPayload());
    }

}

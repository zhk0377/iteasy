package com.iteasy.kafka.consumer;

import com.iteasy.kafka.message.Demo01Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @className: Demo01Consumer
 * @description: 消费者
 * @author: kai.zheng
 * @date: 2021/5/6
 **/
@Component
@Slf4j
public class Demo01Consumer {
    @KafkaListener(topics = Demo01Message.TOPIC,groupId = "demo01-consumer-group-"+Demo01Message.TOPIC)
    public void onMessage(Demo01Message message){
        log.info("[onMessage][线程编号：{} 消息内容：{}]",Thread.currentThread().getId(),message);
    }
}

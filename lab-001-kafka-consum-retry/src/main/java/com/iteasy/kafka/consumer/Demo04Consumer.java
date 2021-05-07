package com.iteasy.kafka.consumer;

import com.iteasy.kafka.message.Demo04Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: Demo01Consumer
 * @description: 消费者
 * @author: kai.zheng
 * @date: 2021/5/6
 **/
@Component
@Slf4j
public class Demo04Consumer {
    private AtomicInteger count = new AtomicInteger(0);
    @KafkaListener(topics = Demo04Message.TOPIC,groupId = "demo04-consumer-group-"+ Demo04Message.TOPIC)
    public void onMessage(Demo04Message message){
        count.getAndIncrement();
        log.info("[onMessage][线程编号：{} 消费次数：{} 消息内容：{}]",Thread.currentThread().getId(),count,message);
        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("我就是故意抛出一个异常");
    }
}

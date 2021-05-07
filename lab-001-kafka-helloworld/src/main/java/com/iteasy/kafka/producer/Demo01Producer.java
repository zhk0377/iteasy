package com.iteasy.kafka.producer;

import com.iteasy.kafka.message.Demo01Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @className: Demo01Producer
 * @description: 生产者
 * @author: kai.zheng
 * @date: 2021/5/6
 **/
@Component
public class Demo01Producer {
    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    /**
     * 同步发送消息
     * @param id
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        //创建demo消息
        Demo01Message message = new Demo01Message();
        message.setId(id);
        //同步发送消息
        return kafkaTemplate.send(Demo01Message.TOPIC,message).get();
    }

    /**
     * 异步发送消息
     * @param id
     * @return
     */
    public ListenableFuture<SendResult<Object,Object>> asyncSend(Integer id){
        //创建demo消息
        Demo01Message message = new Demo01Message();
        message.setId(id);
        //异步发送消息
        return kafkaTemplate.send(Demo01Message.TOPIC,message);
    }
}

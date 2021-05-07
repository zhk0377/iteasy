package com.iteasy.kafka.producer;

import com.iteasy.kafka.message.Demo02Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @className: Demo02Producer
 * @description: TODO 类描述
 * @author: kai.zheng
 * @date: 2021/5/7
 **/
@Component
public class Demo02Producer {
    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    public ListenableFuture<SendResult<Object,Object>> asyncSend(Integer id){
        //创建demo消息
        Demo02Message message = new Demo02Message();
        message.setId(id);
        //异步发送消息
        return kafkaTemplate.send(Demo02Message.TOPIC,message);
    }
}

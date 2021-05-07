package com.iteasy.kafka.producer;

import com.iteasy.kafka.Lab001KafkaConsumRetryApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @className: Demo02ProducerTest
 * @description: TODO 类描述
 * @author: kai.zheng
 * @date: 2021/5/7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Lab001KafkaConsumRetryApplication.class)
@Slf4j
class Demo02ProducerTest {
    @Autowired
    private Demo04Producer producer;

    @Test
    void asyncSend() throws InterruptedException, ExecutionException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
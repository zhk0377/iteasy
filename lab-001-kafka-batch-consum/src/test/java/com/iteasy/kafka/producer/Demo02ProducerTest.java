package com.iteasy.kafka.producer;

import com.iteasy.kafka.Lab001KafkaBatchConsumApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

/**
 * @className: Demo02ProducerTest
 * @description: TODO 类描述
 * @author: kai.zheng
 * @date: 2021/5/7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Lab001KafkaBatchConsumApplication.class)
@Slf4j
class Demo02ProducerTest {
    @Autowired
    private Demo02Producer producer;

    @Test
    void asyncSend() throws InterruptedException {
        log.info("[testAsyncSend][开始执行]");

        for (int i = 0; i < 3; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.asyncSend(id).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {

                @Override
                public void onSuccess(SendResult<Object, Object> result) {
                    log.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, result);
                }

                @Override
                public void onFailure(Throwable e) {
                    log.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
                }
            });
            // 故意每条消息之间，隔离 10 秒
            Thread.sleep(10 * 1000L);
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
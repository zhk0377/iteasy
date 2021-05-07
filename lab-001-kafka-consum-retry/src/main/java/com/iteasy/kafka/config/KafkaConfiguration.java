package com.iteasy.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.*;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @className: KafkaConfiguration
 * @description: TODO 类描述
 * @author: kai.zheng
 * @date: 2021/5/7
 **/
@Configuration
public class KafkaConfiguration {
    @Bean
    @Primary
    public ErrorHandler KafkaErrorHandler(KafkaTemplate<?, ?> template) {
        // <1> 创建 DeadLetterPublishingRecoverer 对象
        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(template);
        // <2> 创建 FixedBackOff 对象
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        // <3> 创建 SeekToCurrentErrorHandler 对象
        return new SeekToCurrentErrorHandler(recoverer, backOff);
    }

    @Bean
    @Primary
    public BatchErrorHandler kafkaBatchErrorHandler() {
        // 创建 SeekToCurrentBatchErrorHandler 对象
        SeekToCurrentBatchErrorHandler batchErrorHandler = new SeekToCurrentBatchErrorHandler();
        // 创建 FixedBackOff 对象
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        batchErrorHandler.setBackOff(backOff);
        // 返回
        return batchErrorHandler;
    }
}

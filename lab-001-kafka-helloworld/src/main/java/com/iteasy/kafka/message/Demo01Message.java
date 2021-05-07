package com.iteasy.kafka.message;

import lombok.Data;

/**
 * @className: Demo01Message
 * @description: 消息
 * @author: kai.zheng
 * @date: 2021/5/6
 **/
@Data
public class Demo01Message {
    public static final String TOPIC = "DEMO_01";

    /**
     * 编号
     */
    private Integer id;
}

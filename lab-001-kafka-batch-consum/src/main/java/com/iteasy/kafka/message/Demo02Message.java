package com.iteasy.kafka.message;

import lombok.Data;

/**
 * @className: Demo02Message
 * @description: TODO 类描述
 * @author: kai.zheng
 * @date: 2021/5/7
 **/
@Data
public class Demo02Message {
    public static final String TOPIC = "DEMO_012";

    /**
     * 编号
     */
    private Integer id;

    // ... 省略 set/get/toString 方法

}

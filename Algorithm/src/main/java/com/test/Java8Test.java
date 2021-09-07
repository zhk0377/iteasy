package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: jdk8
 * @Author kai.zheng
 * @Date 2021/6/26
 */
public class Java8Test {
    public static void main(String[] args) {
        List<Object> orderList = new ArrayList<>();
        System.out.println(orderList.stream().map(v->v).collect(Collectors.toList()));
    }
}

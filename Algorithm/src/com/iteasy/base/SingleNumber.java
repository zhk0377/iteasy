package com.iteasy.base;

/**
 * @author kai.zheng
 * @Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @date 2019-03-20 15:34
 */
public class SingleNumber {
    public static void main(String[] args) {
        int a=2;
        System.out.println(Integer.toBinaryString(2));
        System.out.println("a 非的结果是："+(~a));
        int[] arr={4,2,2};
        int x=0;
        for (int i = 0; i <arr.length ; i++) {
            x^=arr[i];
        }
        System.out.println(x);
        byte b=-5;
        System.out.println(b<<2);
        System.out.println(b>>2);
        b=5;
        System.out.println(b<<2);
        System.out.println(b>>2);
        System.out.println(-5>>>1);
    }
}

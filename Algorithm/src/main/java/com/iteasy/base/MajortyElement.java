package com.iteasy.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai.zheng
 * @Description: 求众数
 * @date 2019-03-20 15:13
 */
public class MajortyElement {
    public static void main(String[] args) {
//        int[] nums={2,1,2};
        int[] nums={2,2,2,1,1,2};

        System.out.printf("数组：");
        showAllElement(nums);
        System.out.println("众数为："+getMajortyElement1(nums));
        System.out.println("众数为："+getMajortyElement2(nums));
    }

    private static void showAllElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i]+"\t");
        }
        System.out.println("");
    }

    private static int getMajortyElement1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int result=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
                if(map.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }else{
                map.put(nums[i],1);
            }
        }
        return result;
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    private static int getMajortyElement2(int[] nums) {
        int count=1;
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(result==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    result=nums[i];
                    count++;
                }
            }
        }
        return result;
    }

}

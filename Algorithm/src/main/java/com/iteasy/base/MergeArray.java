package com.iteasy.base;

/**
 * @author kai.zheng
 * @Description: 两个有序数组合并
 * @date 2019-03-20 17:20
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,4,5};
        System.out.println("第一个数组:");
        showAllElement(nums1);
        System.out.println("第二个数组:");
        showAllElement(nums2);
        System.out.println("合并之后的数组:");
        merge(nums1,3,nums2,3);
        showAllElement(nums1);
    }
    private static void showAllElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i]+"\t");
        }
        System.out.println("");
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,writeIndex=m+n-1;
        while(i>=0 && j>=0){
            nums1[writeIndex--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        while (j>=0){
            nums1[writeIndex--]=nums2[j--];
        }
    }

}

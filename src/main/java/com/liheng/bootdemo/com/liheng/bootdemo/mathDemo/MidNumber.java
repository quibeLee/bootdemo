package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.math.BigDecimal;

public class MidNumber {
    /**
     * 暴力解法：合并两个数组，取中位数，判断奇偶，判断其中一个数组为空时，判断其中一个数组所有数都比另一个数组大。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m+n];
        if(m == 0){
            if(n % 2 == 0){
                return (nums2[n/2 - 1] + nums2[n/2]) / 2.0;
            }else {
                return nums2[n/2] / 1.0;
            }
        }
        if(n == 0){
            if(m % 2 == 0){
                return (nums1[m/2 -1] + nums1[m/2]) / 2.0;
            }else {
                return nums1[m/2] / 1.0;
            }
        }

        int count = 0;
        int i = 0;
        int j = 0;
        while(count != (m + n)) {
            if (i == m) {
                while (j != n)
                    nums[count++] = nums2[j++];
                break;
            }
            if (j == n) {
                while (i != m)
                    nums[count++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if(count % 2 != 0){
            return nums[count/2];
        }else {
            return (nums[count/2 -1] + nums[count/2])/2.0;
        }

    }



    @Test
    public   void Test(){
        /*int[] nums1 = {7,8,9};
        int[] nums2 = {2,4};
        double midNumber = findMedianSortedArrays(nums1,nums2);
        String str = "org.junit.Test";
        System.out.println(str.substring(0,str.lastIndexOf(".")));*/
        BigDecimal value = new BigDecimal("2020202020202021.11");
        BigDecimal value2 = new BigDecimal("999999999999933111.11");
        System.out.println(value.doubleValue());
        System.out.println(value2.doubleValue());
        String string = "1111111111111111111111111111";
        System.out.println(value.toString());
        System.out.println(value2.toString());
        double a = 11111111111111111111111111111111.0;
        System.out.println(a);

    }
}

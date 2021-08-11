package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /***
     * 遍历数组，除同
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        for(int i = 0;i < nums.length -1;i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /***
     *
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSumHash(int[] nums, int target){
        Map<Integer,Integer> twoSumHashMap = new HashMap();
        for(int i = 0;i < nums.length;i++){
            if(twoSumHashMap.containsKey(nums[i])){
                return new int[]{twoSumHashMap.get(nums[i]),i};
            }
            twoSumHashMap.put(target - nums[i],i);
        }
        return null;
    }

    /***
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案
     */
    @Test
    public void test(){
        int[] nums = {1,3,5,9};
        int target = 6;
        twoSum(nums,target);
        System.out.println(Arrays.toString(twoSum(nums,target)));
        System.out.println(Arrays.toString(twoSumHash(nums,target)));
    }
}
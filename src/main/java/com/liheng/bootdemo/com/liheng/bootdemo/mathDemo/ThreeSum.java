package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List list = new ArrayList();
        if(nums == null) return list;
        int len = nums.length;
        if(len < 3) return list;
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = len-1;
            int sums = 0;
            while (l < r){
                sums = nums[i]+nums[l]+nums[r];
                if(sums == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sums < 0) l++;
                 else if(sums > 0) r--;
            }
        }
        return list;
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null) return 0;
        int len = nums.length;
        if(len < 3) return 0;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            int l = i+1;
            int r = len-1;
            while (l < r){
                int sums = nums[i]+nums[l]+nums[r];
                if (Math.abs(sums - target) < Math.abs(ans - target)){
                    ans = sums;
                }
                if (sums > target)
                    r--;
                else if (sums < target)
                    l++;
                else if (sums == target)
                    return ans;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums).toString());
    }
}

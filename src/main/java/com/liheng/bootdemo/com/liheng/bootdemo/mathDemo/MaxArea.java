package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

/**
 * 题目描述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
 * (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class MaxArea {
    /**
     * 双指针法：寻求最优解
     * 每次都移动自己最差的一边，虽然可能变得更差，但是总比不动（或者减小）强，动最差的部分可能找到更好的结果，但是动另一边总会更差或者不变。
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int r = height.length - 1;
        int l = 0;
        int maxArea = 0;
        while (l < r){
            int area = Math.min(height[l],height[r]) * (r - l);
            maxArea = Math.max(area , maxArea);
            if(height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxArea;
    }
    @Test
    public void test(){
        int[] height = {1,2,1};
        System.out.println(maxArea(height));
    }
}

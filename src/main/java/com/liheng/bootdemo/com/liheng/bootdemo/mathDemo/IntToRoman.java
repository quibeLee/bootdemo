package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

/**
 * 题目描述:整数转罗马数字
 *
 */
public class IntToRoman {

    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    /**
     * 贪心算法：在当前时间匹配最优的数（最大的数）
     */
    public String intToRoman(int num){
        StringBuilder sb = new StringBuilder();
        //用当前数字匹配整数数组中的最大数，直到该数字为0
        for(int i = 0;i<values.length && num>0;i++){
            //若整数数组数大于当前数字，数组指针右移；否则匹配到当前允许的最大数
            while (values[i] <= num){
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 罗马数转整数： 左值大于右值作加法，左值小于右值作减法
     * @param s
     * @return
     */

    public int romanToInt(String s){
        int sum = 0;
       // char[] chars = s.toCharArray();
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            int num = getValue(s.charAt(i));
            if(preNum < num){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    @Test
    public void test(){
        System.out.println(intToRoman(9));
        System.out.println(romanToInt("IL"));
    }
}

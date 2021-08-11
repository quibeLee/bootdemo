package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringLengthOfLongest  {


    public int lengthOfLongest (String s){
        int len = s.length();  //字符串长度
        int left = 0;          //队列指针起始位置
        int max = 0;           //最大长度
        Map<Character,Integer> map = new HashMap();
        if(len == 0)           //如果字符串长度为0，返回0；
            return 0;
        for(int i = 0;i < len;i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1); //取当前字符串在map中的值，左指针右移
            }
            map.put(s.charAt(i),i);      //更新重复字符串的值，加入新字符串
            max = Math.max(max,i-left+1);   //取字符串最大长度
        }

        return max;
    }
    @Test
    public void test() throws CloneNotSupportedException {
        String s = "abcabcabcd";
        System.out.println(lengthOfLongest(s));

    }
}

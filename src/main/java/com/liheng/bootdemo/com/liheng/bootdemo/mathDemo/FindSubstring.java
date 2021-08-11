package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public List<Integer> findSubString(String s,String[] words){
        List<Integer> res = new ArrayList();
        if(s == null || s.length() == 0 || words.length == 0 || words ==null){
            return res;
        }
        int strLen = s.length();
        int wLen = words[0].length();
        int wsLen = words.length;
        int allLen = words.length * wLen;
        Map<String,Integer> map1 = new HashMap<String,Integer>();
        for(String word : words){
            map1.put(word,map1.getOrDefault(word,0) + 1);
        }
        for(int i = 0;i < strLen - allLen + 1;i++){
            Map<String,Integer> map2 = new HashMap<String,Integer>();
            int num = 0;
            while (num < wsLen){
                String newWord = s.substring(i + num * wLen,i + (num + 1) * wLen);
                if(map1.containsKey(newWord)){
                    map2.put(newWord,map2.getOrDefault(newWord,0) + 1);
                    if(map1.get(newWord) < map2.get(newWord)){
                        break;
                    }
                }else {
                    break;
                }
                num++;
            }
            if(num == wsLen){
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void test(){
        String[] a = new String[]{"foo","bar"};
        List list = findSubString("barfoothefoobarman",a);
        System.out.println(list.toString());
    }
}

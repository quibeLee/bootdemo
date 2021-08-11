package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

public class LongestCommonPrefix {
    /**
     * 返回一个字符串数组的公共子串
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){
        if(strs == null ||strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int len = strs.length;
        for(int i = 1;i < len;i++){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    /**
     * 返回两个字符串的公共字串
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonPrefix(String str1,String str2){
        int index = 0;
        int len = Math.min(str1.length(),str2.length());
        while (index < len && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }


}

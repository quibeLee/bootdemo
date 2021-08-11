package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

public class StrStrSolution {
    public int strStr(String haystack,String needle){
        int m = haystack.length();
        int n = needle.length();
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        for(int i = 0;i <= m-n;i++){
            int x = i;
            int y = 0;
            while (y < n &&a[x] == b[y]){
                y++;
                x++;
            }
            if(y == n)
                return i;
        }
        return -1;
    }
}

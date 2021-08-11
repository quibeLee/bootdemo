package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

public class LongestPalindrome {
    /***
     * 输入一个字符串。输出它的最长回文串
     * 回文串：海上自来水来自上海
     * 暴力解法：枚举所有回文串，取最长
     * time：O(N3）
     * space:O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int len = s.length();
        /*字符串长度小于等于1,返回该字符串*/
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        /* s.charAt(i)每次都会查数组边界，所以先把字符串转为字符数组 */
        char[] charArray = s.toCharArray();
        /*开始位置 字符串倒数第二位 */
        for(int i = 0;i < len -1;i++){
            /*结束位置 字符串最后一位*/
            for(int j = i+ 1;j < len;j++){
                /*判断截取的字符串是否大于最大字串，并且是回文串*/
                if(j - i + 1 > maxLen && validPalindromic(charArray,i,j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return  s.substring(begin,begin + maxLen);
    }
    /*判断字符数组是否为回文串*/
    public boolean validPalindromic(char[] charArray,int left,int right ){
        while (left < right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    /**
     *  判断一个整数是否为回文串
     *     转成字符串处理
     */
    public  boolean validPalindromic1(int a){
        String s = String.valueOf(a);
        char[] chars = s.toCharArray();
        int len = s.length();
        if(len < 2){
            return true;
        }
        int left = 0;
        int right = len - 1;
        return  validPalindromic(chars,left,right);
    }

    /**
     * 反转数字
     * @return
     */
    public boolean validPalindromic2(int a){
        if(a < 0 || a%10 == 0 && a != 0){
            return false;
        }
        int b = 0;
        int c = a;
        while (c != 0){
            if(c/10 > Integer.MAX_VALUE/10 || c == Integer.MAX_VALUE/10 && (c%10 > Integer.MAX_VALUE%10)){
                return false;
            }
            b  =b*10 + c%10;
            c = c/10;
        }
        if(b != a) return false;
        return true;
    }

    /**
     * 半反转数字
     */
    public boolean validPalindromic3(int a){
        if(a < 0 || a%10 == 0 && a != 0){
            return false;
        }
        int b = 0;
        while(a > b){
            b  =b*10 + a%10;
            a = a/10;
        }
        return a == b || a == b/10;
    }

    /**
     * 动态规划：自底向上，用di[i][j]来表示字串是否为回文串，在字串长度小于3时，只需确保其为回文串，反之，还需确保字串的字串为回文串；
     * 当回文串成立，且其为最大时，更新起始位置和最大字串长度
     * @param s
     * @return
     */
    public String longestString(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArr = s.toCharArray();
        for (int j = 1; j < len; j++){
            for(int i = 0; i < j;i++){
                if(charArr[i] != charArr[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // j-i+1可以保证len>2
                if(dp[i][j] && j - i + 1 > maxLen){
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin ,begin + maxLen) ;
    }
    @Test
    public  void  test(){
        String s = "abab";
       /* System.out.println(longestPalindrome(s));
        System.out.println(longestString(s));
        System.out.println(validPalindromic1(1));*/
        System.out.println(validPalindromic2(1000000001));
        System.out.println(validPalindromic3(1111));
    }
}

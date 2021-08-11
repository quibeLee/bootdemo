package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

/**
 * 字符串转为整数，注意边界
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 */
public class StringInversionInt {
    public int myAtoi(String s) {
        int len = s.length();
        //s.charAt()每次都会检查数组下标
        char[] chars = s.toCharArray();
        int index = 0;
        //1.去除前导空格
        while (index < len && chars[index] == ' '){
            index++;
        }
        //2.若输入的字符串全为空格，返回0
        if(index == len){
            return 0;
        }
        //3.若出现符号字符，仅第一个有效，并记录正负
        int sign = 1;
        char firstChar = chars[index];
        if(firstChar == '+'){
            index++;
        }else if(firstChar == '-'){
            index++;
            sign = -1;
        }
        //将后续出现的数字字符进行格式转换，且不能用long存储
        int res = 0;
        while (index < len){
            char numChar = chars[index];
            //4.1判断数字字符边界（ACSII）
            if(numChar < '0' || numChar > '9'){
                break;
            }
            //4.2判断边界值
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && (numChar - '0') > Integer.MAX_VALUE % 10){
                   return Integer.MAX_VALUE;
            }else if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && (numChar - '0') > Integer.MIN_VALUE % 10){
                   return Integer.MIN_VALUE;
            }
            //4.3数字合法才进行格式转化
            res = res * 10 + sign * (numChar - '0');
            index++;
        }
        return  res;
    }

    @Test
    public void test(){
       /* System.out.println(myAtoi("             "));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));*/
        System.out.println(myAtoi("-2147483649"));
    }
}

package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 * 给出字符串s：ABCDEFGLMN，行数numRows：3
 * A   E   M
 * B D F L N
 * C   G
 * 输出：AEMBDFLNCG
 */
public class ZChangeClass {
    /**
     * 边界性：若行数小于2，输出原字符串，只需讨论行数大于等于2.
     * Z字形变换需要注意字符串的每一字符应该放在新的数组的那一行，行数极为需要开辟的一维数组数。
     * 算法流程：
     * res[i] += c; 把每个字符填入对应行
     * i += flag 更新当前字符的索引行
     * flag = -flag 当到达首行或者末行时（转折点）进行逆序
     * 复杂度：
     * 时间复杂度O(N)：遍历一遍字符串s
     * 空间复杂度O(N): 各行共占O(N)的额外空间  4N->N
     * @param s
     * @param numRows
     * @return
     */
    public String  convert(String s,int numRows){
        if(numRows < 2){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++) rows.add(new StringBuilder());
        int i = 0,flag = -1;
        for(char c : s.toCharArray()){
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag = -flag;
            i += flag;

        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows){
            res.append(sb);
        }
        return res.toString();
    }
    @Test
    public void test(){
        ZChangeClass zChangeClass = new ZChangeClass();
        String  s = zChangeClass.convert("abcdefg",3);
        System.out.println(s);
        int  i = 1/10;
        int  a = -1463847412;
        System.out.println(i);
        System.out.println(a);
    }
}

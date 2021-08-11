package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

/**
 * 整数反转
 * 输入x：123 输出y：321
 * 边界：-2147483648 <= x <= 2147483647， 若 -2147483648 <= y <= 2147483647，返回0；
 * 算法流程：
 *      对x进行反转，每次取x的最后一位，x%10，并且更新x的值，x/10
 *      y = x%10 + y*10
 *      x = x/10
 */
public class IntegerInversion {
    public int reverse(int x) {
        int y = 0;
        while(x != 0){
            if(y > 214748364 || y < -214748364){
                return 0;
            }
            y = y*10 + x%10;
            x = x/10;
        }
        return y;
    }

    /**
     * 测试用例：1234，2147483647
     */
    @Test
    public void test(){
        System.out.println(reverse(2147483647));
    }
}

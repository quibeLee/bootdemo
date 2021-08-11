package com.liheng.bootdemo.com.liheng.bootdemo.test;

import org.junit.Test;

public class SonarQubeTest {
    @Test
    public void test(){
        double dou1 = Double.POSITIVE_INFINITY;
        double dou2 = Double.POSITIVE_INFINITY;
        if(dou1 == dou2){
            System.out.println(" == ");
        }
        if(Double.doubleToLongBits(dou1) == Double.doubleToLongBits(dou2)){
            System.out.println(" == ");
        }
    }

}

package com.liheng.bootdemo.com.liheng.bootdemo.test;


import org.junit.Test;

import java.io.IOException;

public class SingleDemo {
    @Test
    public void singleCompare() {
        Runtime rt1 = Runtime.getRuntime();
        Runtime rt2 = Runtime.getRuntime();
        if(!(rt1 != rt2)){
            System.out.println("instance unique");
        }else {
            System.out.println("instance not unique");
        }

        Process process1 = null;

        try{
            process1 = rt1.exec("notepad");
        }catch (IOException e){
            e.getMessage();
            System.out.println("Error executing");
        }

    }

}

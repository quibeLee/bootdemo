package com.liheng.bootdemo.com.liheng.bootdemo.imageProxy;


import org.junit.Test;

public class TestImage {
    @Test
    public void test(){
        ProxyImage proxyImage = new ProxyImage("test.jpg");
        proxyImage.display();
        System.out.println("--------------");
        proxyImage.display();
    }
}

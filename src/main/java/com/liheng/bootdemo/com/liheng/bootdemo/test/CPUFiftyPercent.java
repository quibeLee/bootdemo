package com.liheng.bootdemo.com.liheng.bootdemo.test;


public class CPUFiftyPercent {
    public static void main(String[] args) throws InterruptedException {
        final int SAMPLING_COUNT = 200;  //抽样样本数
        final double PI = 3.141592654;   //圆周率
        final int TOTAL_AMPLITUDE = 300; //完整振幅
        int[] busySpan = new int[SAMPLING_COUNT];    //忙碌时间
        int amplitude = TOTAL_AMPLITUDE >> 1;        //振幅
        double radio = 0.0;                          //弧度
        double radioIncrement = 2.0 / (double)SAMPLING_COUNT;
        for(int i = 0;i < SAMPLING_COUNT;i++){
            busySpan[i] = (int)(Math.sin(PI * radio) * amplitude + amplitude);
            radio +=  radioIncrement;
        }
        long startTime = 0;
        for(int j=0;;j=(j+1) % SAMPLING_COUNT){
            startTime = System.currentTimeMillis();
            while((System.currentTimeMillis()-startTime)<=busySpan[j])
                ;
            Thread.sleep(TOTAL_AMPLITUDE-busySpan[j]);
        }

    }
}

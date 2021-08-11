package com.liheng.bootdemo.com.liheng.bootdemo.imageProxy;

public class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("display" + fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("loading" + fileName);
    }
}

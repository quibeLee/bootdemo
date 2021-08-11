package com.liheng.bootdemo.com.liheng.bootdemo.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryService {
    public static void main(String[] args) {
        try{
            //本地主机的远程对象注册表Registry的实例，默认端口1899
            Registry registry = LocateRegistry.createRegistry(1899);
            //创建一个远程对象
            HelloRegistryFacade helloRegistryFacade = new HelloRegistryFacadeImpl();
            //将远程对象注册到RMI注册表中
            registry.rebind("HelloRegistry",helloRegistryFacade);
            System.out.println("---------------启动RMI服务器成功----------");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

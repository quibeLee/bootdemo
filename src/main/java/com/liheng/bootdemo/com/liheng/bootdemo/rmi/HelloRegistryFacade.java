package com.liheng.bootdemo.com.liheng.bootdemo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRegistryFacade extends Remote {
    public String helloRegistry(String name) throws RemoteException;
}

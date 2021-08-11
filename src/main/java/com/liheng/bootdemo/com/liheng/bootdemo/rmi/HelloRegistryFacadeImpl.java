package com.liheng.bootdemo.com.liheng.bootdemo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRegistryFacadeImpl extends UnicastRemoteObject implements HelloRegistryFacade {
    public HelloRegistryFacadeImpl() throws RemoteException{
        super();
    }
    @Override
    public String helloRegistry(String name) throws RemoteException {
        return "[Registry]你好" + name;
    }
}

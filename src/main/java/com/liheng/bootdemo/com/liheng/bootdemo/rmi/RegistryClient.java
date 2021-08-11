package com.liheng.bootdemo.com.liheng.bootdemo.rmi;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1899);
            HelloRegistryFacade helloRegistryFacade = (HelloRegistryFacade) registry.lookup("HelloRegistry");
            String response = helloRegistryFacade.helloRegistry("Li Mrs");
            System.out.println("=======> " + response + " <=======");
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}

package com.lxm.netty.io.rpc.provider;

import com.lxm.netty.io.rpc.publicinterface.RemoteServer;

public class RemoteServerImpl implements RemoteServer {
    @Override
    public String hello(String user) {
        try {
            Thread.sleep(5000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "hello " + user;
    }
}

package com.lxm.netty.io.rpc.consumer;

import com.lxm.netty.io.rpc.publicinterface.RemoteServer;

import java.lang.reflect.Proxy;

public class TestRpc {
    public static void main(String[] args) {
        RemoteServer server = (RemoteServer) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{RemoteServer.class}, new RpcNettyClient());
        String result = server.hello("zhangsan");
        System.out.println(result);
    }
}

package com.lxm.netty.io.rpc.consumer;

import com.lxm.netty.io.rpc.publicinterface.RemoteServer;

import java.lang.reflect.Proxy;

public class TestRpc {
    public static void main(String[] args) {
        RemoteServer server = (RemoteServer) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{RemoteServer.class}, new RpcInvocationHandler());
        System.out.println("before invoke remote service");
        String result = server.hello("world");
        System.out.println(result);
        System.out.println("after invoke remote service");
    }
}

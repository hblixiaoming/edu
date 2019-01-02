package com.lxm.netty.io.rpc.consumer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvocationHandler implements InvocationHandler {
    private RpcNettyClient client;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("hello")) {
            if (client == null) {
                client = new RpcNettyClient();
                client.init();
            }
            String msg = (String) args[0];
            return client.sendMsg(msg);
        } else {
            return null;
        }
    }
}

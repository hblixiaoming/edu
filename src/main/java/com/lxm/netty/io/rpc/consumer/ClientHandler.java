package com.lxm.netty.io.rpc.consumer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.Callable;

public class ClientHandler extends SimpleChannelInboundHandler<String> implements Callable<String> {
    private ChannelHandlerContext context;
    private String result;
    private String param;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
    }

    @Override
    protected synchronized void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        result = msg;
        notify();
    }

    @Override
    public synchronized String call() throws Exception {
        context.writeAndFlush(param);
        wait();
        return result;
    }

    public synchronized void setParam(String param) {
        this.param = param;
    }
}

package com.lxm.netty.io.rpc.consumer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcNettyClient {
    private ClientHandler clientHandler;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private void connect(int port, String host) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        clientHandler = new ClientHandler();
        try {
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("decode", new StringDecoder());
                            ch.pipeline().addLast("encode", new StringEncoder());
                            ch.pipeline().addLast("handler", clientHandler);
                        }
                    });
            b.connect(host, port).sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class ClientHandler extends SimpleChannelInboundHandler<String> implements Callable<String> {
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

    public String sendMsg(String msg) throws Exception {
        clientHandler.setParam(msg);
        return executorService.submit(clientHandler).get();
    }

    public void init() throws Exception {
        connect(8080, "127.0.0.1");
    }
}

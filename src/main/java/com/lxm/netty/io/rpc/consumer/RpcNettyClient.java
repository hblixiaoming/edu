package com.lxm.netty.io.rpc.consumer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcNettyClient implements InvocationHandler {
    private ClientHandler client;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("hello")) {
            if (client == null) {
                init();
            }
            String msg = (String) args[0];
            client.setParam(msg);
            return executorService.submit(client).get();
        } else {
            return null;
        }
    }

    private void connect(int port, String host) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        client = new ClientHandler();
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
                            ch.pipeline().addLast("handler", client);
                        }
                    });
            b.connect(host, port).sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void init() throws Exception {
        connect(8080, "127.0.0.1");
    }
}

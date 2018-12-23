package com.lxm.netty.io.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EchoClient {
    public void connect(int port, String host) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientInHandler());
                        }
                    });

            Channel channel = b.connect(host, port).sync().channel();
            while (true) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));
                String input = reader.readLine();
                if (input != null) {
                    if ("quit".equals(input)) {
                        break;
                    }
                    ByteBuf resp = Unpooled.copiedBuffer(input.getBytes());
                    channel.writeAndFlush(resp);
                }
            }
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    private class EchoClientInHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println("Client receive msg:" + body);
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient().connect(8080, "127.0.0.1");
    }
}

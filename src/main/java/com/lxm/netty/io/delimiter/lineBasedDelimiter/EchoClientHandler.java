package com.lxm.netty.io.delimiter.lineBasedDelimiter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private int counter = 1;
    private byte[] req;


    public EchoClientHandler() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf messsage = null;
        for (int i = 0; i < 100; i++) {
            messsage = Unpooled.buffer(req.length);
            messsage.writeBytes(req);
            ctx.writeAndFlush(messsage);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is:" + body + ";zhe counter is:" + counter++);
    }
}

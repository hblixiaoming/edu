package com.lxm.netty.io.bytebuff;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Iterator;

public class TestByteBufHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headBuf = Unpooled.buffer();
        ByteBuf bodyBuf = Unpooled.buffer();
        messageBuf.addComponents(headBuf, bodyBuf);

        Iterator<ByteBuf> iterator = messageBuf.iterator();
        while (iterator.hasNext()) {
            ByteBuf byteBuf = iterator.next();

        }
        int read = messageBuf.readableBytes();
        byte[] tempArray = new byte[read];
        messageBuf.getBytes(read,tempArray);

        //messageBuf.readBytes()
        super.channelRead(ctx, msg);
    }
}

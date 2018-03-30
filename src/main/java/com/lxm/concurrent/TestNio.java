package com.lxm.concurrent;

import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TestNio {
    public static void main(String[] args) throws Exception {
//        URL url = new URL("http://www.baidu.com");
//        URLConnection connection = url.openConnection();

        ServerSocket socket = new ServerSocket(80);
        ServerSocketChannel channel = socket.getChannel();
        channel.configureBlocking(false);

        Selector selector = Selector.open();

        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;

        SelectionKey selectionKey = channel.register(selector, interestSet);

        String a = "a";

        selectionKey.attach(a);

        Object attachedObj = selectionKey.attachment();

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ, a);

        selector.wakeup();

    }
}

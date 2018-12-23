package com.lxm.socket.io.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NioChatClient implements Runnable {
    private SocketChannel socketChannel;
    private Selector selector;
    private ConcurrentLinkedQueue<String> buffedQueue;

    private void init() throws Exception {
        System.out.println("connecting server ...");
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress(8080));
        this.buffedQueue = new ConcurrentLinkedQueue<String>();
    }

    private void listen() throws Exception {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //删除防止内存泄漏
                iterator.remove();

                handle(selectionKey);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.listen();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handle(SelectionKey selectionKey) throws Exception {
        if (selectionKey.isConnectable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
                System.out.println("server connecting ok");
                socketChannel.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (selectionKey.isReadable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            this.readMsg(socketChannel);
            socketChannel.register(selector,SelectionKey.OP_WRITE);
        } else if (selectionKey.isWritable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            this.writeMsg(socketChannel);
            socketChannel.register(selector,SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) throws Exception {
        NioChatClient client = new NioChatClient();
        client.init();
        Thread thread = new Thread(client);
        thread.start();

        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String msg2;
        while ((msg2 = re.readLine()) != null) {
            client.buffedQueue.offer(msg2);
            System.out.println("inset msg:" + msg2);
        }
    }

    private void readMsg(SocketChannel socketChannel) throws Exception {
        ByteBuffer receive = ByteBuffer.allocate(1024);
        // 将缓冲区清空以备下次读取
        receive.clear();
        // 读取服务器发送来的数据到缓冲区中
        int readNum = socketChannel.read(receive);
        if (readNum > 0) {
            System.out.println("client receive msg:" + new String(receive.array()));
        }
    }

    private void writeMsg(SocketChannel socketChannel) throws Exception {
//        String msg;
//        while ((msg = buffedQueue.poll()) != null) {
//            ByteBuffer buffer = ByteBuffer.allocate(msg.getBytes().length);
//            buffer.put(msg.getBytes());
//            socketChannel.write(buffer);
//            buffer.flip();
//        }
        String msg = "hello server";

            ByteBuffer buffer = ByteBuffer.allocate(msg.getBytes().length);
            buffer.put(msg.getBytes());
            socketChannel.write(buffer);
//            buffer.flip();
//        }
    }
}

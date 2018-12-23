package com.lxm.socket.io.v2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NioChatClient implements Runnable {
    private SocketChannel socketChannel;
    private Selector selector;
    private ByteBuffer sendBuf = ByteBuffer.allocate(1024);

    private void init() throws Exception {
        System.out.println("connecting server ...");
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress(8080));
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
                socketChannel.configureBlocking(false);
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
        sendBuf.clear();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        if(message.equals("quit")){
            System.exit(-1);
        }
        sendBuf.put(message.getBytes());
        sendBuf.flip();
        socketChannel.write(sendBuf);
    }
}

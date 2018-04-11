package com.lxm.socket.io.v2;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioChatServer implements Runnable{
    private ServerSocketChannel serverSocketChannel;
    private ServerSocket serverSocket;
    private Selector selector;
    private SelectionKey selectionKey;
    private SocketChannel client;

    private void init() throws Exception {

        serverSocketChannel = ServerSocketChannel.open();

        serverSocket = serverSocketChannel.socket();

        serverSocket.bind(new InetSocketAddress(8080),1024);

        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();

        selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void listen() throws Exception {
        while (true) {
            int count = selector.select();

            System.out.println("ready channel num=" + count);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                iterator.remove();

                //handle zhe key
                handle(selectionKey);
            }
        }
    }

    private void handle(SelectionKey selectionKey) throws Exception {
        //if one channel connected
        if (selectionKey.isAcceptable()) {
            System.out.println("channel acceptable");
            // 返回为之创建此键的通道。
            serverSocketChannel = (ServerSocketChannel) selectionKey.channel();

            // 此方法返回的套接字通道（如果有）将处于阻塞模式。
            client = serverSocketChannel.accept();
            // 配置为非阻塞
            client.configureBlocking(false);
            // 注册到selector，等待连接
            client.register(selector, SelectionKey.OP_READ
                    | SelectionKey.OP_WRITE);

            //if zhe channel can read
        } else if (selectionKey.isReadable()) {
            System.out.println("channel readable");
            // 返回为之创建此键的通道。
            client = (SocketChannel) selectionKey.channel();

            ByteBuffer receive = ByteBuffer.allocate(1024);

            // 将缓冲区清空以备下次读取
            receive.clear();
            // 读取服务器发送来的数据到缓冲区中
            int readNum = client.read(receive);
            if(readNum>0){
                System.out.println(new String(receive.array()));
                selectionKey.interestOps(SelectionKey.OP_WRITE);

            }else if(readNum<0){
                selectionKey.cancel();
                client.close();
            }
        } else if (selectionKey.isWritable()) {
            System.out.println("channel writable");
            // 将缓冲区清空以备下次写入
            this.sendMsg(client, "hello you");
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }

    private void sendMsg(SocketChannel socketChannel, String msg) throws Exception {
        // 发送消息到客户端
        ByteBuffer buffer = ByteBuffer.allocate(msg.getBytes().length);
        buffer.put(msg.getBytes());
        socketChannel.write(buffer);
        buffer.flip();
    }

    public static void main(String[] args) throws Exception {
        NioChatServer server = new NioChatServer();
        server.init();
        new Thread(server).start();
    }

    @Override
    public void run() {
        try {
            this.listen();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

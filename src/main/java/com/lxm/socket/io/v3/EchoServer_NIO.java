package com.lxm.socket.io.v3;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServer_NIO {
    private Selector selector;
    private ByteBuffer sendBuf = ByteBuffer.allocate(1024);
    private ByteBuffer recBuf = ByteBuffer.allocate(1024);
    public EchoServer_NIO(){
        try {
            System.out.println("server starting ...");
            selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //设置非阻塞模式
            ssc.configureBlocking(false);
            //绑定端口
            ssc.bind(new InetSocketAddress(8080));
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server start success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("server start fail");
        }
    }

    public static void main(String[] args) {
        new EchoServer_NIO().service();
    }

    public void service(){
        while (true){
            try {
                int select = selector.select();
                if (select>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        //如果是有效的
                        if (key.isValid()){
                            if (key.isAcceptable()){
                                accept(key);
                            }else if(key.isReadable()){
                                read(key);
                            }else if(key.isWritable()){
                                write(key);
                            }
                        }
                    }
                    selectionKeys.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key){
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            sc.register(selector,SelectionKey.OP_READ);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void read(SelectionKey key) {
        try {
            recBuf.clear();
            SocketChannel sc = (SocketChannel) key.channel();
            int read = sc.read(recBuf);
            if (read<0){
                key.channel().close();
                key.cancel();
                return;
            }
            recBuf.flip();
            String recText = new String(recBuf.array(),0,read);
            System.out.println(recText);
            if (recText.equals("quit")){
                sendBuf.clear();
                sendBuf.put("bye".getBytes());
                sc.write(sendBuf);
                key.channel().close();
                key.cancel();
                return;
            }
            sc.register(selector,SelectionKey.OP_WRITE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void write(SelectionKey key) {
        try {
            SocketChannel sc = (SocketChannel) key.channel();
            sendBuf.clear();
            String sendText = "server speak hello";
            sendBuf.put(sendText.getBytes());
            sendBuf.flip();
            sc.write(sendBuf);
            sc.register(selector,SelectionKey.OP_READ);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

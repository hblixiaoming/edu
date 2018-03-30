package com.lxm.socket.io.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioChatClient {
    private SocketChannel socketChannel;

    private void init() throws Exception {
        socketChannel = SocketChannel.open();
        socketChannel.socket().connect(new InetSocketAddress(80));
        socketChannel.configureBlocking(false);
    }

    public void sendMsg(String msg) {
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        NioChatClient client = new NioChatClient();
        client.init();

        Thread thread = new Thread(client.new ReadTask());
        thread.start();

        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));

        String msg2;
        while ((msg2 = re.readLine()) != null) {
            client.sendMsg(msg2);
        }
    }

    private class ReadTask implements Runnable {
        private String receiveMsg() {
            String msg = null;
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                StringBuffer buf = new StringBuffer();
                int count = 0;
                //不一定一次就能读满，连续读
                while ((count = socketChannel.read(buffer)) > 0) {
                    buf.append(new String(buffer.array(), 0, count));
                }
                //有数据
                if (buf.length() > 0) {
                    msg = buf.toString();
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        public void run() {
            receiveMsg();
        }
    }
}

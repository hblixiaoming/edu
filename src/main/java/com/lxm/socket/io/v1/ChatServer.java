package com.lxm.socket.io.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<Socket> clientList = new ArrayList<Socket>();

    public static void main(String[] args) throws Exception {
        ChatServer server = new ChatServer();
    }

    public ChatServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(80);

        Thread thread2 = new Thread(new MultySend());
        thread2.start();

        while (true) {
            Socket socket = serverSocket.accept();
            clientList.add(socket);
            Thread thread = new Thread(new SendTask(socket));
            thread.start();
        }
    }

    private class SendTask implements Runnable {
        Socket socket;
        BufferedReader reader;
        PrintWriter printWriter;

        public SendTask(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuilder msg = new StringBuilder();
                msg.append("【");
                msg.append("client");
                msg.append(":");
                msg.append(socket.getPort());
                msg.append("】");
                String temp;
                while ((temp = reader.readLine()) != null) {
                    System.out.println(temp);
                    sendMsg(msg.toString() + temp);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    //reader.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }

        private void sendMsg(String msg) {
            for (Socket socket : clientList) {
                try {
                    printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(msg);
                    printWriter.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    //printWriter.close();
                }

            }
        }
    }

    private class MultySend implements Runnable {
        @Override
        public void run() {
            BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
            try {
                String msg2;
                while ((msg2 = re.readLine()) != null) {
                    this.sendMsg(msg2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void sendMsg(String msg) {
            StringBuilder header = new StringBuilder();
            header.append("【");
            header.append("server");
            header.append("】");

            PrintWriter printWriter;
            for (Socket socket : clientList) {
                try {
                    printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(header.toString() + msg);
                    printWriter.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    //printWriter.close();
                }
            }
        }
    }
}


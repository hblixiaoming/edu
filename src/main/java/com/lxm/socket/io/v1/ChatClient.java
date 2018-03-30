package com.lxm.socket.io.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    Socket socket;

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
    }

    public ChatClient() {
        try {
            socket = new Socket("127.0.0.1", 80);

            Thread thread = new Thread(new ReadTask(socket));
            thread.start();

            BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String msg2;
            while ((msg2 = re.readLine()) != null) {
                pw.println(msg2);
            }
            pw.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class ReadTask implements Runnable {
        Socket socket;
        public ReadTask(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader br;

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg1;
                while ((msg1 = br.readLine()) != null) {
                    System.out.println(msg1);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    //br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}

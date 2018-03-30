package com.lxm.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    class Producer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try{
                for(int i=0;i<100;i++){
                    queue.put(i);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}

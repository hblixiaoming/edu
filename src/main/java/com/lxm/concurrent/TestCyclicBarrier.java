package com.lxm.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 2; i++) {
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        int count = 0;
                        while (true) {
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + " run...");
                            count++;
                            if (count > 5) {
                                break;
                            }
                        }
                        cyclicBarrier.await();
                        System.out.println("run finish...");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }
}

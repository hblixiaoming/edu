package com.lxm.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLacth {
    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(2);

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
                        countDownLatch.countDown();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + " run...");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}

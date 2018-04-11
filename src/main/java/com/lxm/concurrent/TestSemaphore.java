package com.lxm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 3; i++) {
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        int count = 0;
                        while (true) {
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + " run...");
                            count++;
                            if (count > 10) {
                                break;
                            }
                        }
                        semaphore.release();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }
}

package com.lxm.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {
    private CountDownLatch countDownLatch = new CountDownLatch(10);

    private void test1() throws Exception {
        Demo1.Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread(counter, "Thread：" + i).start();
        }
        countDownLatch.await();
        System.out.println(counter.counter);
    }


    public static void main(String[] args) throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.test1();
    }

    private class Counter implements Runnable {
        public AtomicInteger counter = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread:" + Thread.currentThread().getName() + " counter:" + counter.incrementAndGet());
            }
            countDownLatch.countDown();
        }
    }
}

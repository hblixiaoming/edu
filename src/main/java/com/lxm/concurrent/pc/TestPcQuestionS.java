package com.lxm.concurrent.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPcQuestionS {
    private Integer plate;
    private ReentrantLock lock = new ReentrantLock();
    private Condition has = lock.newCondition();
    private Condition notHas = lock.newCondition();

    public TestPcQuestionS(Integer plate) {
        this.plate = plate;
    }

    private void putApple() {
        System.out.println(Thread.currentThread().getName() + ":put apple");
        plate = 1;
    }

    private boolean hasApple() {
        return plate == 1;
    }

    private void takeApple() {
        System.out.println(Thread.currentThread().getName() + ":take apple");
        plate = 0;
    }

    private class Producer implements Runnable {
        public Integer plate;

        public Producer(Integer plate) {
            this.plate = plate;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (hasApple()) {
                    try {
                        notHas.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                putApple();
                has.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    private class Consumer implements Runnable {
        private Integer plate;

        public Consumer(Integer plate) {
            this.plate = plate;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (!hasApple()) {
                    try {
                        has.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                takeApple();
                notHas.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Integer plate = new Integer(0);
        TestPcQuestionS test = new TestPcQuestionS(plate);
        for (int i = 0; i < 10; i++) {
            new Thread(test.new Producer(plate), "producer thread").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(test.new Consumer(plate), "consumer thread").start();
        }
    }
}

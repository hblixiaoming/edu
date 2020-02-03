package com.lxm.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LXM on 2019/12/31.
 */
public class TestThreeThread {
    private int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private class TaskA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (flag != 1) {
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    flag = 2;
                    condition2.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class TaskB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (flag != 2) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    flag = 3;
                    condition3.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class TaskC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (flag != 3) {
                        try {
                            condition3.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    flag = 1;
                    condition1.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args) {
        TestThreeThread test = new TestThreeThread();
        TaskA taskA = test.new TaskA();
        TaskB taskB = test.new TaskB();
        TaskC taskC = test.new TaskC();
        new Thread(taskA).start();
        new Thread(taskB).start();
        new Thread(taskC).start();
    }
}

package com.lxm.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SynchThreadV1 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private byte[] signals = new byte[]{0, 0};

    private class Thread1 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            System.out.println("Thread1 run");
            signals[0] = 1;
            condition1.signalAll();
            lock.unlock();
        }
    }

    private class Thread2 implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                if (signals[0] == 0) {
                    condition1.await();
                }
                System.out.println("Thread2 run");
                signals[1] = 1;
                condition2.signalAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private class Thread3 implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                if (signals[1] == 0) {
                    condition2.await();
                }
                System.out.println("Thread3 run");
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SynchThreadV1 sy = new SynchThreadV1();
        Thread thread1 = new Thread(sy.new Thread1());
        thread1.start();

        Thread thread2 = new Thread(sy.new Thread2());
        thread2.start();

        Thread thread3 = new Thread(sy.new Thread3());
        thread3.start();
    }
}

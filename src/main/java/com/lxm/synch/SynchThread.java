package com.lxm.synch;

import java.util.concurrent.atomic.AtomicBoolean;

public class SynchThread {
    private final AtomicBoolean mark1 = new AtomicBoolean(false);
    private final AtomicBoolean mark2 = new AtomicBoolean(false);

    private class Thread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread1 run");
            synchronized (mark1) {
                mark1.compareAndSet(false, true);
                mark1.notifyAll();
            }
        }
    }

    private class Thread2 implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (mark1) {
                    synchronized (mark2) {
                        if (!mark1.get()) {
                            mark1.wait();
                        }
                        System.out.println("Thread2 run");
                        mark2.compareAndSet(false, true);
                        mark2.notifyAll();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class Thread3 implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (mark2) {
                    if (!mark2.get()) {
                        mark2.wait();
                    }
                    System.out.println("Thread3 run");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SynchThread sy = new SynchThread();
        Thread thread1 = new Thread(sy.new Thread1());
        thread1.start();

        Thread thread2 = new Thread(sy.new Thread2());
        thread2.start();

        Thread thread3 = new Thread(sy.new Thread3());
        thread3.start();
    }
}

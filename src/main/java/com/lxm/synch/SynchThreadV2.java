package com.lxm.synch;

public class SynchThreadV2 {
    private class Thread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread1 run");
        }
    }

    private class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread2 run");
        }
    }

    private class Thread3 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread3 run");
        }
    }

    public static void main(String[] args) throws Exception {
        SynchThreadV2 sy = new SynchThreadV2();
        Thread thread1 = new Thread(sy.new Thread1());
        Thread thread2 = new Thread(sy.new Thread2());
        Thread thread3 = new Thread(sy.new Thread3());
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}

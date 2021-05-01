package com.lxm.concurrent.pc;

public class TestPcQuestion {
    private Integer plate;


    public TestPcQuestion(Integer plate) {
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
            synchronized (plate) {
                while (hasApple()) {
                    try {
                        plate.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                putApple();
                plate.notifyAll();
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
            synchronized (plate) {
                while (!hasApple()) {
                    try {
                        plate.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                takeApple();
                plate.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Integer plate = new Integer(0);
        TestPcQuestion test = new TestPcQuestion(plate);
        for (int i = 0; i < 10; i++) {
            new Thread(test.new Producer(plate), "producer thread").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(test.new Consumer(plate), "consumer thread").start();
        }
    }
}

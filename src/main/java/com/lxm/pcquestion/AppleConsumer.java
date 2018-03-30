package com.lxm.pcquestion;

public class AppleConsumer implements Consumer<Apple>, Runnable {
    private Container<Apple> container;

    public AppleConsumer(Container<Apple> container) {
        this.container = container;
    }

    @Override
    public Apple consumer() {
        try {
            Thread.sleep(500L);
            Apple apple = container.take();
            System.out.println("consumer: consumer apple=" + apple);
            return apple;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        while (true) {
            Apple apple = this.consumer();
            if (apple == null) {
                System.out.println("container empty");
            }
        }
    }
}

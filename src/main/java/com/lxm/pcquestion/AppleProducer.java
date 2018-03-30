package com.lxm.pcquestion;

import java.util.concurrent.atomic.AtomicInteger;

public class AppleProducer implements Producer<Apple>, Runnable {
    private Container<Apple> container;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public AppleProducer(Container<Apple> container) {
        this.container = container;
    }

    @Override
    public void producer(Apple apple) {
        System.out.println("producer: produce apple=" + apple);
        container.put(apple);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Apple apple = new Apple(atomicInteger.incrementAndGet());
                this.producer(apple);
                Thread.sleep(1000L);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

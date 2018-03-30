package com.lxm.pcquestion.v1;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockintQueueV1Container implements Container<Apple> {

    private BlockingQueue<Apple> blockingQueue;

    public BlockintQueueV1Container() {
        this.blockingQueue = new ArrayBlockingQueue<Apple>(10);
    }

    @Override
    public void put(Apple apple) {
        try {
            this.blockingQueue.put(apple);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Apple take() {
        Apple app = null;
        try {
            app = this.blockingQueue.take();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return app;
    }
}

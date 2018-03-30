package com.lxm.pcquestion.v2;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueV2Container implements Container<Apple> {

    private BlockingQueue<Apple> blockingQueue;

    public BlockingQueueV2Container() {
        this.blockingQueue = new ArrayBlockingQueue<Apple>(10);
    }

    @Override
    public void put(Apple apple) {
        try {
            this.blockingQueue.add(apple);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Apple take() {
        Apple app = null;
        try {
            app = this.blockingQueue.remove();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return app;
    }
}

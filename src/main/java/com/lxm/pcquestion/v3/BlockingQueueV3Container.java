package com.lxm.pcquestion.v3;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueV3Container implements Container<Apple> {

    private BlockingQueue<Apple> blockingQueue;

    public BlockingQueueV3Container() {
        this.blockingQueue = new ArrayBlockingQueue<Apple>(10);
    }

    @Override
    public void put(Apple apple) {
        try {
            boolean result = this.blockingQueue.offer(apple);
            if(!result){
                throw new RuntimeException("produce fail");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public Apple take() {
        Apple app = null;
        try {
            app = this.blockingQueue.poll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return app;
    }
}

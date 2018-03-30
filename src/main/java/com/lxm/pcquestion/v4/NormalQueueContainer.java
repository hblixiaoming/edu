package com.lxm.pcquestion.v4;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.Container;

import java.util.ArrayDeque;
import java.util.Queue;

public class NormalQueueContainer implements Container<Apple> {

    private Queue<Apple> queue;

    public NormalQueueContainer() {
        this.queue = new ArrayDeque<>(10);
    }

    @Override
    public void put(Apple apple) {
        try {
            boolean result = this.queue.offer(apple);
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
            app = this.queue.poll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return app;
    }
}

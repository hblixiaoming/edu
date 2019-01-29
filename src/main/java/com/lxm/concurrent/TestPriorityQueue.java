package com.lxm.concurrent;

import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}

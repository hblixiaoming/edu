package com.lxm.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by LXM on 2019/6/18.
 */
public class TestCallable {

    public class Job implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000L);
            return "hello world";
        }
    }

    public static void main(String[] args) throws Exception {
        TestCallable test = new TestCallable();
        Job job = test.new Job();
        FutureTask<String> task = new FutureTask(job);
        new Thread(task, "test thread").start();
        System.out.println(task.get());
    }
}

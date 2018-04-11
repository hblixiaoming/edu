package com.lxm.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable{
    @Override
    public Object call() throws Exception {
        Thread.currentThread().sleep(2000L);
        return "Hello World";
    }

    public static void main(String[] args)throws Exception{
        TestCallable callable = new TestCallable();
        FutureTask future = new FutureTask(callable);
        new Thread(future).start();
        System.out.println(future.get());
        System.out.println("thread end");
    }
}

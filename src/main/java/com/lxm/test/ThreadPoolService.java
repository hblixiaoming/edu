package com.lxm.test;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ThreadPoolService<T> {
    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    public Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    public void submit(Runnable task) {
        executor.submit(task);
    }
}

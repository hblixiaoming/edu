package com.lxm.thread.pool;

import java.util.concurrent.Callable;

/**
 * Created by LXM on 2019/6/18.
 */
public class CallableTask<T> implements Runnable {
    private Callable<T> callable;
    private Callback<T> callback;

    public CallableTask(Callable callable, Callback callback) {
        this.callable = callable;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            T result = callable.call();
            callback.callBack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

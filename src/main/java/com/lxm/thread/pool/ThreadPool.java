package com.lxm.thread.pool;

import java.util.concurrent.Callable;

public interface ThreadPool {
    void submit(Runnable runnable);

    <T> T submit(Callable callable);
}

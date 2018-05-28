package com.lxm.thread.pool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolService implements ThreadPool {
    private BlockingQueue<Runnable> cachedtaskQueue;
    private HashSet<Object> workThread;
    private int corePoolSize = 5;
    private int maxPoolSize = 10;
    private long keepAliveTime = 1000L;
    private AtomicInteger aliveThread = new AtomicInteger(0);


    public ThreadPoolService(int corePoolSize, int maxPoolSize) throws Exception {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        cachedtaskQueue = new ArrayBlockingQueue<>(maxPoolSize - corePoolSize);
        workThread = new HashSet<>(maxPoolSize);
        for (int i = 0; i < corePoolSize; i++) {
            workThread.add(new Thread("poolSize" + aliveThread.incrementAndGet()));
        }
    }

    public ThreadPoolService(ThreadPoolConfigration configration) throws Exception {
        this(configration.getCorePoolSize(), configration.getMaxPoolSize());
    }

    @Override
    public void submit(Runnable runnable) {
        //if has alive thread run zhe task
//        if (aliveThread.get() > 0 && !workThreadQueue.isEmpty()) {
//            Thread thread = workThreadQueue.take();
//            thread.run();
//        }
    }

    @Override
    public <T> T submit(Callable callable) {
        return null;
    }

    public class ThreadPoolConfigration {
        private int corePoolSize;
        private int maxPoolSize;
        private int keepAliveTime;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getKeepAliveTime() {
            return keepAliveTime;
        }

        public void setKeepAliveTime(int keepAliveTime) {
            this.keepAliveTime = keepAliveTime;
        }
    }
}

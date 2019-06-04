package com.lxm.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        executorService.schedule(() -> {
            System.out.println("hello boy");
        }, 5, TimeUnit.SECONDS);

        //下一次执行时间相当于是上一次的执行时间加上period，它是采用已固定的频率来执行任务
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("at fixed rate");
        }, 0, 2, TimeUnit.SECONDS);

        //与scheduleAtFixedRate方法不同的是，下一次执行时间是上一次任务执行完的系统时间加上period，
        // 因而具体执行时间不是固定的，但周期是固定的，是采用相对固定的延迟来执行任务
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("with fixed rate");
        }, 0, 2, TimeUnit.SECONDS);
    }
}

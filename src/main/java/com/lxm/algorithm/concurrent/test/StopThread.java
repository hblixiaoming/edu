package com.lxm.algorithm.concurrent.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by LXM on 2017/2/7.
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args)throws InterruptedException{
        Thread backgroundThread=new Thread(()->{
            int i=0;
            while(!stopRequested){
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested=true;
    }
}

package com.lxm.algorithm.concurrent.test;

import java.util.concurrent.TimeUnit;

/**
 * stopThread�Ľ���
 * Created by LXM on 2017/2/7.
 */
public class StopThread1 {

    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested=true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }


    public static void main(String[] args)throws InterruptedException{
        Thread backgroundThread=new Thread(()->{
            int i=0;
            while(!stopRequested()){
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}

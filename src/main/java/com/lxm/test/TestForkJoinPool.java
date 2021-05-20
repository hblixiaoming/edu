package com.lxm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class TestForkJoinPool {

    public void test() {
        List<Integer> batchContractList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            batchContractList.add(i);
        }
        List<String> resultList = new ArrayList<>();
        List<CompletableFuture<Void>> crmFuture = batchContractList.stream().map(w -> CompletableFuture.runAsync(() -> {
            //System.out.println(Thread.currentThread().getName() + ":" + w);
            resultList.add(w + "a");
        })).collect(Collectors.toList());
        crmFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(resultList);
        System.out.println(resultList.size());
    }

    public void test1() {
        List<Integer> batchContractList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            batchContractList.add(i);
        }
        Queue<String> resultList = new ConcurrentLinkedQueue<>();
        List<CompletableFuture<Void>> crmFuture = batchContractList.stream().map(w -> CompletableFuture.runAsync(() -> {
            //System.out.println(Thread.currentThread().getName() + ":" + w);
            resultList.offer(w + "a");
        })).collect(Collectors.toList());
        crmFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(resultList);
        System.out.println(resultList.size());
    }
    public static void main(String[] args) {
        TestForkJoinPool test = new TestForkJoinPool();
        test.test();
        //test.test1();
    }
}

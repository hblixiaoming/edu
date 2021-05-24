package com.lxm.test;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {
    /**
     * ForkJoinPool.commonPool-worker-1:runAsync...
     * main:main run...
     * ForkJoinPool.commonPool-worker-1:whenComplete...
     * @throws Exception
     */
    public void test1() throws Exception {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ":runAsync...");
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }).whenComplete((x, y) -> {
            System.out.println(Thread.currentThread().getName() + ":whenComplete...");
        });
        System.out.println(Thread.currentThread().getName() + ":main run...");
        future.get();
    }

    /**
     * ForkJoinPool.commonPool-worker-1:runAsync...
     * main:main run...
     * ForkJoinPool.commonPool-worker-1:whenComplete...
     * @throws Exception
     */
    public void test2() throws Exception {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ":runAsync...");
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }).whenCompleteAsync((x, y) -> {
            System.out.println(Thread.currentThread().getName() + ":whenComplete...");
        });
        System.out.println(Thread.currentThread().getName() + ":main run...");
        future.get();
    }

    /**
     * ForkJoinPool.commonPool-worker-1:runAsync...
     * main:main run...
     * ForkJoinPool.commonPool-worker-1:whenComplete...
     * ForkJoinPool.commonPool-worker-1java.lang.ArithmeticException: / by zero:exceptionally...
     * @throws Exception
     */
    public void test3() throws Exception {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ":runAsync...");
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
            int a = 1 / 0;
        }).whenComplete((x, y) -> {
            System.out.println(Thread.currentThread().getName() + ":whenComplete...");
            throw new NullPointerException("whenComplete null");
        }).exceptionally(ex -> {
            System.out.println(Thread.currentThread().getName() + ex.getMessage() + ":exceptionally...");
            return null;
        });
        System.out.println(Thread.currentThread().getName() + ":main run...");
        future.get();
    }

    public static void main(String[] args) throws Exception {
        TestCompletableFuture test = new TestCompletableFuture();
        test.test1();
    }
}

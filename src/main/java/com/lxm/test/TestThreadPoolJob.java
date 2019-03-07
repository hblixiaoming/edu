package com.lxm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPoolJob {

    /**
     * 将队列的数值每个数值加1后输出
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ConcurrentLinkedQueue<Integer> jobList = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            jobList.offer(i);
        }
        int nThread = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        List<Future> resultList = new ArrayList<>();
        for (int i = 0; i < nThread; i++) {
            Future<List<Integer>> result = executorService.submit(new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    List<Integer> tempResult = new ArrayList<>();
                    while (!jobList.isEmpty()) {
                        Integer num = jobList.poll();
                        num = num + 1;
                        tempResult.add(num);
                    }
                    return tempResult;
                }
            });
            resultList.add(result);
        }

        for (Future future : resultList) {
            if (future != null) {
                List<Integer> resultL = (List<Integer>) future.get();
                for (Integer i : resultL) {
                    System.out.println(i);
                }
            }
        }
        executorService.shutdown();
    }
}

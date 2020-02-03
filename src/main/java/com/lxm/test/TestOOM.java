package com.lxm.test;

/**
 * Created by LXM on 2019/12/28.
 */
public class TestOOM {
    private String test = "1";

    public static void main(String[] args) {
        TestOOM testOOM = new TestOOM();
        for (int i = 0; i < 40; i++) {
            new Thread(new Task(testOOM.test)).start();
        }
    }

    private static class Task implements Runnable {
        private String test;

        public Task(String test) {
            this.test = test;
        }

        @Override
        public void run() {
            while (true) {
                test = test.concat(new String("abcdefghigklmnopqrstuvwxyz"));
            }
        }
    }
}

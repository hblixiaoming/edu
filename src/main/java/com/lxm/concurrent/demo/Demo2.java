package com.lxm.concurrent.demo;

import java.math.BigDecimal;

public class Demo2 {

    public static void main(String[] args) {
        Account account = new Account(1, "0");
        Demo2 demo = new Demo2();

        Task1 task1 = demo.new Task1();
        task1.setAccount(account);

        Task2 task2 = demo.new Task2();
        task2.setAccount(account);

        Task3 task3 = demo.new Task3();
        task3.setAccount(account);

        new Thread(task1, "task1").start();
        //new Thread(task2, "task2").start();
        new Thread(task3, "task3").start();
    }


    private class Task1 implements Runnable {
        private Account account;

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                account.increaseBalance(new BigDecimal(1));
            }
        }
    }

    private class Task2 implements Runnable {
        private Account account;

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("Task2 code:" + Account.getCode());
            }
        }
    }

    private class Task3 implements Runnable {
        private Account account;

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                account.decreaseBalance(new BigDecimal(1));
            }
        }
    }
}

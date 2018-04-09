package com.lxm.algorithm.concurrent;
/**
 * ������
 * Created by LXM on 2017/2/7.
 */
public class Test {
    public static void main(String[] args) {
        Account account=new Account("1",0.0);
        new Thread(new BorrowThread(account,10)).start();
        new Thread(new SaveThread(account,40)).start();
    }
}

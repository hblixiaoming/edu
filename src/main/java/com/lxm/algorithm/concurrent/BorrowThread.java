package com.lxm.algorithm.concurrent;

/**
 * ��Ǯ�߳�
 * Created by LXM on 2017/2/7.
 */
public class BorrowThread implements Runnable{
    Account account;
    double borrowAmount;

    public BorrowThread(Account account,double borrowAmount){
        this.account=account;
        this.borrowAmount=borrowAmount;
    }

    public void run(){
        account.borrow(borrowAmount);
        System.out.println("borrow money total amount:"+account.getAmount());
    }
}

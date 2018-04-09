package com.lxm.algorithm.concurrent;

/**
 * ��Ǯ�߳�
 * Created by LXM on 2017/2/7.
 */
public class SaveThread implements Runnable{
    Account account;
    double saveAmount;

    public SaveThread(Account account,double saveAmount){
        this.account=account;
        this.saveAmount=saveAmount;
    }


    public void run(){
        account.save(saveAmount);
        System.out.println("save money total amount:"+account.getAmount());
    }


}

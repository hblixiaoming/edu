package com.lxm.algorithm.concurrent;

/**
 * �˻���
 * Created by LXM on 2017/2/7.
 */
public class Account {
    String id;
    double amount;

    public Account(String id,double amount){
        this.id=id;
        this.amount=amount;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void save(double money){
        synchronized (this){
            amount=amount+money;
            this.notifyAll();
        }
    }

    public void borrow(double money){
        synchronized (this){
            while(amount<money){
                try {
                    this.wait();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            amount=amount-money;
        }
    }


}

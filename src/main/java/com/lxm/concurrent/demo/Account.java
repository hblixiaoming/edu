package com.lxm.concurrent.demo;

import java.math.BigDecimal;

public class Account {
    private volatile BigDecimal balance;
    private Integer id;
    private static String code = "hello";

    public Account(Integer id, String balance) {
        this.id = id;
        this.balance = new BigDecimal(balance);
    }

    public BigDecimal getBalance() {
        return new BigDecimal(balance.toString());
    }

    public synchronized BigDecimal increaseBalance(BigDecimal amount) {
        System.out.println(Thread.currentThread().getName() + " increaseBalance");
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        balance = balance.add(amount);
        this.notifyAll();
        return balance;
    }

    public synchronized BigDecimal decreaseBalance(BigDecimal amount) {
        while (balance.compareTo(amount) < 0) {
            try {
                this.wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " decreaseBalance");
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return balance;
        } else {
            throw new RuntimeException("余额不足");
        }
    }

    public synchronized static String getCode() {
        System.out.println(Thread.currentThread().getName() + " getCode");
        try {
            Thread.sleep(100000);
        } catch (Exception ex) {

        }
        return code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.lxm.algorithm.leetCode;

/**
 * Created by LXM on 2019/6/23.
 */
public class Fib {

    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args){
        Fib fib = new Fib();
        System.out.println(fib.fib(7));
    }
}

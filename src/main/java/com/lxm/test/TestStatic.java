package com.lxm.test;

/**
 * Created by LXM on 2019/12/17.
 */
public class TestStatic {
    static {
        a = 2;
    }

    public static int a = 1;

    public static void main(String[] args){
        System.out.println(a);
    }
}

package com.lxm.test;

/**
 * Created by LXM on 2019/6/27.
 */
public class TestString {

    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        System.out.println(a == b);

        String c = new String("123");
        String d = new String("123");
        System.out.println(c == d);

        String e = "123";
        String f = new String("123");
        System.out.println(e == f);
    }
}

package com.lxm.test;

/**
 * Created by LXM on 2019/6/26.
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = new Integer("1");
        Integer b = new Integer("1");
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        Integer g = 127;
        Integer h = 127;
        System.out.println(g == h);

        Integer e = 150;
        Integer f = 150;
        System.out.println(e.equals(f));

        Integer i = -128;
        Integer j = -128;
        System.out.println(i == j);

        Integer k = -129;
        Integer l = -129;
        System.out.println(k == l);
    }
}

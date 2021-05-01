package com.lxm.test;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class TestArray {

    private void test1() {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        int[] b = Arrays.copyOf(a, 6);
        System.out.println(a == b);
        a[0] = 5;
        System.out.println(a[0]);
        System.out.println(b[0]);
    }


    private void test2() {
        List<Object> list = new LinkedList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list);
    }

    public void test3() {
        Vector<Object> list = new Vector<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list);
    }

    public void test4() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put(null, null);
        map.put("1", null);
        map.put(null, "2");
        System.out.println(map);
    }

    public void test5(){
        Map<Object, Object> map = new TreeMap<>();
        //map.put(null, null);
        map.put("1", null);
        //map.put(null, "2");
        System.out.println(map);
    }

    public static void main(String[] args) {
        TestArray test = new TestArray();
//        test.test1();
//        test.test2();
//        test.test3();
//        String a = "abc";
//        System.out.println(a.hashCode());
//        test.test4();
        test.test5();
    }
}

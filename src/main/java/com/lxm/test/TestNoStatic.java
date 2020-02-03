package com.lxm.test;

/**
 * Created by LXM on 2019/12/17.
 */
public class TestNoStatic {

    public TestNoStatic(){
    }

    private int a = 1;

    {
        a = 2;
    }

    public static void main(String[] args){
        TestNoStatic testNoStatic  = new TestNoStatic();
        System.out.println(testNoStatic.a);
    }
}

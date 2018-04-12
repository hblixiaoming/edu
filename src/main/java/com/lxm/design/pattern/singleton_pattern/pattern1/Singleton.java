package com.lxm.design.pattern.singleton_pattern.pattern1;

/**
 * 第一种单例类，
 *
 * lazy loading,not thread safe
 * 这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

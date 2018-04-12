package com.lxm.design.pattern.singleton_pattern.pattern2;

/**
 * lazy loading,thread safe,not productive
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是，遗憾的是，效率很低，99%情况下不需要同步
 * Created by LXM on 2016/8/26.
 */
public class Singleton {

    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

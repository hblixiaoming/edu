package com.lxm.design.pattern.singleton_pattern.pattern4;

/**
 *
 *  表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static Singleton instance = null;
    static {
        instance = new Singleton();
    }
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }

}
